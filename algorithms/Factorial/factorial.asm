	;	The input is a decimal number,
	;	Result is a hexadecimal number

section .text
	;	to make the printf out work the main 'method' is needed
	global main
	
	;	for printing numbers out
	extern printf

main:
	;	Find factorial for the initial value of ecx,
	mov ecx, 5
	
	;	Copy the initial value of ecx to eax, 
	;	eax is our factorial result
	mov eax, ecx
	
loop:
	;	If the counter is less or equal to 1, finish
	cmp ecx, 1
	jle end
	
	sub ecx, 1
	mul ecx
	jmp loop

end:
	; Display the message and exit
	push eax
	push message
	call printf
	add esp, 8
	ret

section .data
	message: db "The result is = %08X", 10, 0
