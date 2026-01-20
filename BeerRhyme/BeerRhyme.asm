; This BeerRhyme is written in x86-Assembly for Linux (or unix-like systems)
;
; Compile it with nasm (or yasm, syntax is the same):
; nasm -f elf64 BeerRhyme.asm -o BeerRhyme.o
;
; Link it with ld:
; ld BeerRhyme.o -o BeerRhyme.out

global _start ;Main entry point for linker

section .text

; Print a string buffer to stdout
; The buffer has to be stored into rsi
; The length has to be stored into rdx
printBuffer:
    push rax                    ; Save rax and rdi on the stack
    push rdi

    mov rax, 1                  ; sys_write
    mov rdi, 1                  ; stdout
    syscall                     ; Call kernel

    pop rdi                     ; Restore rax and rdi from the stack
    pop rax
    ret                         ; Return

; Decreases a number in memory by 1 and save it back
; The address has to be stored in the rsi register
decreaseNumber:
    push rax

    mov rax, [rdi]
    dec rax
    mov [rdi], rax

    pop rax
    ret


; Converts a number to a string
; The number in memory has to be stored in rax
; The string buffer has to be stored into rdi
; The length pointer has to be stored into rsi
convertNumberToString:
    push rdx                    ; Save registers to the stack
    push rcx
    push r8

    mov rdx, 0                  ; Needed for division
    mov rcx, 10                 ; Divisor
    div rcx                     ; Divide by 10, quotient -> rax, remainder -> rdx
    mov r8, 2                   ; Preset the length to 2

    ; rax is the first number, rdx is the second one
    test rax, rax               ; Check if rax is 0 (only one digit)
    jnz .strTwoDigits           ; If two digits are used, skip the one digit code

    ; One digit
    mov rax, rdx                ; Copy second digit into first one
    mov r8, 1                   ; Set the length to 1

    .strTwoDigits:
    add rax, 0x30               ; Add 48 to number to get ASCII char
    add rdx, 0x30           

    mov [rdi + 0], al           ; Save lowest byte of first digit to memory
    mov [rdi + 1], dl           ; Save lowest byte of second digit to memory (even if it isn't used)
    mov [rsi], r8               ; Save length to memory

    pop r8                      ; Restore registers from stack
    pop rcx
    pop rdx
    ret

_start:
    ; Convert beer number to string
    mov rax, [numBeers]         ; Number of beers
    mov rdi, strBeers           ; Number string buffer
    mov rsi, numBeersLen        ; The length of the buffer
    call convertNumberToString

    .loopBeer:                  ; Main Loop

    ; Print number to stdout
    mov rsi, strBeers           ; Number string
    mov rdx, [numBeersLen]      ; string length
    call printBuffer

    ; Print "bottles of beer on the wall"
    mov rsi, lineBeerFirst      ; string
    mov rdx, lineBeerFirstLen   ; Length
    call printBuffer

    ; Print number again
    mov rsi, strBeers           ; Number string
    mov rdx, [numBeersLen]      ; string length
    call printBuffer

    ; Print "bottles of beer"
    mov rsi, lineBeerSecond     ; string
    mov rdx, lineBeerSecondLen  ; Length
    call printBuffer

    ; Print "Take one down, pass it around"
    mov rsi, lineTakeFirst      ; string
    mov rdx, lineTakeFirstLen   ; Length
    call printBuffer

    ; Decrease number
    mov rdi, numBeers           ; Number pointer
    call decreaseNumber

    ; Convert decreased beer number to string
    mov rax, [numBeers]         ; Number of beers
    mov rdi, strBeers           ; Number string buffer
    mov rsi, numBeersLen        ; The length of the buffer
    call convertNumberToString

    ; Print decreased number
    mov rsi, strBeers           ; Number string
    mov rdx, [numBeersLen]      ; string length
    call printBuffer

    ; Check if the number is 1, quit loop if so
    mov rax, 1
    cmp [numBeers], rax         ;
    je .finishLoop              ; Continue loop if numBeers > 1

    ; Print "bottles of beer on the wall"
    mov rsi, lineTakeSecond     ; string
    mov rdx, lineTakeSecondLen  ; Length
    call printBuffer

    jmp .loopBeer               ; Rerun the loop

    .finishLoop:
    ; Print "bottle of beer on the wall"
    mov rsi, lineTakeOne     ; string
    mov rdx, lineTakeOneLen  ; Length
    call printBuffer

    ; Print last lines
    mov rsi, lineLast           ; string
    mov rdx, lineLastLen        ; Length
    call printBuffer

    ; Quit
    mov rax, 60                 ; exit
    mov rdi, 0                  ; error code 0
    syscall


section .data ;Constants

lineBeerFirst: db " bottles of beer on the wall, "
lineBeerFirstLen: equ $-lineBeerFirst
lineBeerSecond: db " bottles of beer.", 0xa
lineBeerSecondLen: equ $-lineBeerSecond
lineTakeFirst: db "Take one down, pass it around, "
lineTakeFirstLen: equ $-lineTakeFirst
lineTakeSecond: db " bottles of beer on the wall.", 0xa, 0xa
lineTakeSecondLen: equ $-lineTakeSecond
lineTakeOne: db " bottle of beer on the wall.", 0xa, 0xa
lineTakeOneLen: equ $-lineTakeOne
lineLast: db "1 bottle of beer on the wall, 1 bottle of beer.", 0xa
          db "Take one down and pass it around, no more bottles of beer on the wall", 0xa, 0xa
          db "No more bottles of beer on the wall, no more bottles of beer.", 0xa
          db "Go to the store and buy some more, 99 bottles of beer on the wall.", 0xa
lineLastLen: equ $-lineLast

numBeers: dq 99
numBeersLen: dq 2

section .bss ;Variables

strBeers: resb 2