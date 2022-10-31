'''
Notação polonesa

na Notação Polonesa, ou notação prefixa, os operadores
são escritos antes dos operandos e, nesse caso, os parênteses não são
necessários pois não há ambiguidade. Exemplo: 
- 8 + 4 5
Vai subtrair o 4 do 8 e somar 5
A operação normalmente seria: (8 - 4) + 5
Que é diferente de: 8 - (4 + 5)
Os casos são escritos assim, respectivamente:
+ - 8 4 5 
e
- 8 + 4 5
A expressão é resolvida de dentro para fora. Assim, o primeiro operador é o mais
externo e o último é o mais interno. 

Foi criada uma pilha para poder resolver resolver. 

A separação dos elementos é feita por espaços em branco.

Exemplos de entrada: 
	+ 9 - 3 * 9 75
	* 3 + 4 84 
'''

class No:
	def __init__(self,dado):
		self.__dado = dado
		self.__prox= None 
		self.__ant=None

	def getdado(self):
		return self.__dado
	
	def getprox(self):
		return self.__prox

	def setprox(self,prox):
		self.__prox = prox

	def setant(self,ant):
		self.__ant = ant

class Listaencadeada:
	def __init__(self):
		self._inicio=None
		self._fim= None

	def isvazia(self):
		return self._inicio is None

	def inserirnoinicio(self,dado):
		novono = No(dado)
		if self.isvazia():
			self._inicio = novono
			self._fim = self._inicio
		else:
			novono.setprox(self._inicio)
			self._inicio.setant(novono)
			self._inicio = novono

	def removerdoinicio(self):
		if not self.isvazia():
			inicio=self._inicio.getdado()
			if self._inicio is not self._fim:
				self._inicio.getprox().setant(None)
				self._inicio = self._inicio.getprox()
			else:
				self._inicio = self._fim = None
			return inicio

	def __str__(self):
		no=self._inicio
		string=''
		while no is not None:
			string+=(str(no.getdado()))
			no=no.getprox()
		return string

def minhaFuncaoIn(lista,elemento):
	for i in lista:
		if i==elemento:
			return True
	return False 

while True:
	entrada=input("Digite a notação polonesa a ser resolvida: ").split()
	entrada=entrada[::-1] 										#pegamos o reverso da lista para adicionar os valores na pilha e realizar o cálculo
	pilha=Listaencadeada() 
	operadores=['+', '-', '*','/']
	try: 
		for i in range(len(entrada)): 
			if not minhaFuncaoIn(operadores,entrada[i]):      # Se for operador não empilha, caso contrário empilha
				pilha.inserirnoinicio(int(entrada[i]))
			else:
				num1=pilha.removerdoinicio()					# pegamos x e y para fazer a operação
				num2=pilha.removerdoinicio()
				if entrada[i] == '+':							# operação de soma, subtração, multiplicação e divisão respectivamente.
					pilha.inserirnoinicio(int(num1+num2))		# insere o resultado da soma dos elementos na pilha ( o mesmo com os outros casos)
				elif entrada[i] == '-':
					pilha.inserirnoinicio(int(num1-num2))
				elif entrada[i] == '*':
					pilha.inserirnoinicio(int(num1*num2))
				elif entrada[i] == '/':
					pilha.inserirnoinicio(int(num1/num2))
		resultado = pilha.removerdoinicio()	
		if pilha.isvazia():
			print("Resultado = {}".format(resultado))	  # Após todas as operações, a pilha ficará com um único elemento que é o resultado 
		else: 
			raise Exception
	except:
		print("Notação polonesa inválida, tente outra.")




