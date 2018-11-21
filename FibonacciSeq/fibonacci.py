def fibonacci(limit):
	a = 0
	b = 1
	while ( limit > 0 ):
		print(a, end=", ")
		a, b = b, a+b
		limit -= 1
	
fibonacci(int(input("Number of fibonacci numbers needed = ")))
