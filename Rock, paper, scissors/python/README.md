# Pedra, Papel e Tesoura
Aplicação simples que permite o usuário jogar "Pedra, papel e tesoura" no console do Python 3.

## Como funciona?
  Usei a biblioteca random para randomizar a escolha do computador.
  O usuário digita sua opção que é convertida e adaptada, após isso acontece um teste lógico para saber o resultado e p que deve ser escrito na tela. Se o usuário digitar alguma das palavras que estão selecionadas como palavras-chave (```stopOptions = ["Parar", "Encerrar","Finalizar", "Pare", "Fim"]```)para a finalização do programa  o programa para é exibido o resultado junto com a pontuaçõ geral.
  
### Easter Eggs
  No jogo, existem Easter Eggs da série "The Big Bang Theory", onde o usuário pode escolher além dos objetos padrões, "Lagarto" ou "Spock": ``` possibleChoices = [rock, paper, scissors, lizard, spock] ```
  Entretanto, o computador não pode escolher os objetos que são *Easter Eggs* da série, por isso, as interações entre o "Lagarto" e o "Spock" não acontecem.
  
## Regras:
  1. Objetos iguais dão empate.
  2. Objetos Diferentes
     1. Pedra
          * É embrulhada pelo _Papel_ **(-)**           
          * Quebra _Tesoura_ __(+)__           
          * Esmaga _Lagarto_ **(+)**           
          * É vaporizada pelo _Spock_ __(-)__          
     2. Papel
          * Embrulha _Pedra_ **(+)**
          * É cortado pela _Tesoura_ **(-)**
          * É comido pelo *Lagarto* **(-)**
          * Refuta o _Spock_ __(+)__          
     3. Tesoura
          * É quebrada pela *Pedra* __(-)__
          * Corta o *Papel* **(+)**
          * Decapita _Lagarto_ __(+)__
          * É quebrada pelo _Spock_ __(-)__      
     4. Lagarto
          * É esmagado pela *Pedra* __(-)__
          * Come _Papel_ **(+)**
          * É decapitado pela *Tesoura* **(-)**
          * ~~Envenena *Spock* **(+)**~~ *(Como o computador não pode escolher opções easter eggs, essa opção não existe)*      
     5. Spock
          * Vaporiza a _Pedra_ __(+)__
          * É refutado pelo _Papel_ **(-)**
          * Quebra a _Tesoura_ **(+)**
          * ~~É envenenado pelo _Lagarto_ **(-)**~~ (Como o computador não pode escolher opções easter eggs, essa opção não existe)*

## Créditos
    Desenvolvido por [@weltonfelix](https://github.com/weltonfelix)
