#python3
#program to calculate roots of a polynomial with error of .0001 

def f(x):
	return x*x - 12

def f2(x):
	return 2*x
	
print("Enter values of x0 ")
x0 = float(input())

e = .0001


m = x0-f(x0)/f2(x0)
i=1
while abs(f(m))>e:
			print (i,x0,m,f(m))
			m = m-f(m)/f2(m)
			i= i+1
			
print ("Root of polynomial :",m)
