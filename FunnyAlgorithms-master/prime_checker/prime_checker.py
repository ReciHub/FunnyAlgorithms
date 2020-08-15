# python script to check if a given number is prime
def isPrime(n):
	#first check if number is 2 or 3
	if n <= 3:
		return n > 1
	#check if divisible by 2 or 3
	elif n%2 == 0 or n%3 == 0:
		return False

	#since all numbers divisble by 2 and 3 are covered, the next prime dividor is 5
	#so this only checks for numbers bigger than 25
	c = 5
	while (c*c <= n):
		if n%c == 0 or n%(c+2)==0:
			return False
		c += 6

	#if all checks pass then it is a prime
	return True


#test statements
result = isPrime(5)
print(str(result) + ' should be True')
result = isPrime(10273)
print(str(result) + ' should be True')
result = isPrime(50)
print(str(result) + ' should be False')