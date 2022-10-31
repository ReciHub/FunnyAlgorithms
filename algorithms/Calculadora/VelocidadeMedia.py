while(True):
	posInicial = float(input('Posição inicial: '))
	posFinal = float(input('Posição final: '))
	temInicial = float(input('\nTempo inicial: '))
	temFinal = float(input('Tempo final: ')) 
	print(f'Velocidade média = {(posFinal - posInicial) / (temFinal - temInicial)}')