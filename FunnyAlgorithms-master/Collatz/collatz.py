def collatz(Num):
	iterations = 0
	while ( Num > 1 ):
		Num = Num//2 if(Num%2 == 0) else 3*Num+1
		iterations += 1
	print("reached 1 after", iterations, "iterations")
	
	
collatz(int(input("Enter a +ve number = ")))
