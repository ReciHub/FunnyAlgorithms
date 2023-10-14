def power(a, n):
	if n==0: return 1
	if n%2 == 0: return power(a*a, n//2)
	else: return a*power(a*a,n//2)

if __name__=='__main__':
	a = input('Enter the value of a')
	n = input('Enter the value of the power')
	
	print(f'The value of {a} ^ {n} is {power(a,n)}')

