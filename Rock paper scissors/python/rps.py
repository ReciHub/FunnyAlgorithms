#Desenvolvido por Welton Felix (https://github.com/weltonfelix)

import random
##############
rock = "Pedra"
paper = "Papel"
scissors = "Tesoura"
lizard = "Lagarto"
spock = "Spock"
possibleChoices = [rock, paper, scissors, lizard, spock] #Escolhas Possíveis
winner = False #Vencedor fica como falso
stop = False #Parar fica Falso
pcPoints = 0 #Pontos do pc zerado
userPoints = 0 #Pontos do usuário zerado
stopOptions = ["Parar", "Encerrar","Finalizar", "Pare", "Fim"] #Palavras-chave para encerrar
while stop == False: 
  #PARTE DE ESCOLHA DO PC
  pcChoice = possibleChoices[random.randint(0,2)] #Um número é randomizado, e ele diz qual é o objeto: 0 = Pedra, 1 = Papel e 2 = Tesoura (O Pc não pode escolher nem lagarto, nem Spock)
  #PARTE DA ESCOLHA DO USUÁRIO
  userChoice = (input("Pedra, Papel ou Tesoura?").lower()).capitalize() 
  #TESTES LÓGICOS
  if userChoice in stopOptions:
    stop = True
    print("-----FIM DO JOGO-----")
    print("Pontos: ")
    print("PC:   " + str(pcPoints) + ' pts.')
    print("Você: " + str(userPoints) + ' pts.')
    if pcPoints > userPoints:
      print("O PC ganhou. Mais sorte na próxima.")
    elif userPoints > pcPoints: 
      print("PARABÉNS!! Você ganhou!")
    else: #(Pontos iguais)
      print("Empatou!")
    print("---------------------")
    exit = input("Para sair, aperte enter") #Solução para o usuário sair do programa, mas conseguir ler a msg de finalização
  elif userChoice in possibleChoices: 
    print("O PC escolheu " + pcChoice + " e você escolheu " + userChoice + ".")
    if pcChoice != userChoice:
      if pcChoice == rock or userChoice == rock:
        if pcChoice == paper or userChoice == paper: # e se um dos dois for papel...
          action = "embrulha"
          if pcChoice == paper:# se o pc que for papel
            winner = "pc" # o pc ganha
        elif pcChoice == scissors or userChoice == scissors:
          action = "amassa"
          if pcChoice == rock:
            winner = "pc"
        elif userChoice == lizard:
          action = "esmaga"
          winner = 'pc'
        elif userChoice == spock:
          action = 'vaporiza'
      elif pcChoice == paper or userChoice == paper:
        if userChoice == spock:
          action = 'rejeita'
          winner = 'pc'
        elif pcChoice == scissors or userChoice == scissors:
          action = "corta"
          if pcChoice == scissors:
            winner = "pc"
        elif userChoice == lizard:
          action = 'come'
      elif userChoice == spock:
        if pcChoice == scissors:
          action = 'destrói'
      elif userChoice == lizard:
        if pcChoice == scissors:
            action = 'decapita'
            winner = 'pc'
      if userChoice == spock or userChoice == lizard: #Se o usuário escolher lagarto ou spock
        print("Parabéns! Você descobriu uma referência de The Big Bang Theory")
      if winner: #se a var winner foi setada...
        print(pcChoice + ' ' + action + ' ' + userChoice + ', o PC venceu!')
        pcPoints += 1
      else:
        print(userChoice + ' ' + action + ' ' + pcChoice + ', você venceu!')#frase vc ganha
        userPoints += 1
    else:
      print("Empate!")
  else:
    print("Ops, você escolheu um objeto inválido")
  winner = False #Reseta o ganhador
  print(' ')
  print("========================================")
  print('PC: ' + str(pcPoints) + ' pontos  Você: ' + str(userPoints) + ' pontos')
  print('========================================')
  print(' ')
