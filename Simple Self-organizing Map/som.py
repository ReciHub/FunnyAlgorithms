import numpy as np
import random

no_of_in = input("Enter the number of input units: ") # number of input units
no_of_in = int(no_of_in) # converting string to int

no_of_out = 2 # no of output units

d1 = d2 = 0 # Distance of input units from the output units

alpha = input("Enter the learing rate: ") # Learning rate
alpha = float(alpha)

check = input("Do you want to enter the individual values of the inputs (y/n): ")

if check == 'y':
	print("Enter inputs row-wise in a line separated by space")
	values = list(map(float,input().split()))
	print("The array of inputs is\n")
	mat = np.array(values).reshape(no_of_in,no_of_in)
	print(mat)
else:
	# generating random array
	mat = np.random.rand(no_of_in,no_of_in)
	print("The array of inputs is\n")
	print(mat)
	print("\n")


M = np.random.rand(no_of_in,no_of_out) # Matrix of weights for the 2 output units
print("The initial array of weights:\n")
print(M)
print("\n")

#calculating the euclid distance and updating weights
for u in range(0,no_of_in):
	print("Calculating for input unit",u+1)
	for ind,val in zip(range(0,no_of_in),mat[u]):
		d1 = d1 + ((val - M[ind][0])*(val - M[ind][0]))
	for ind,val in zip(range(0,no_of_in),mat[u]):
		d2 = d2 + ((val - M[ind][1])*(val - M[ind][1]))

	print("D1:",d1)
	print("D2:",d2)

	if d1 > d2:
		print("Unit 2 is less")
		for ind,val in zip(range(0,no_of_in),mat[u]):
			M[ind][1] = M[ind][1] + alpha * (val - M[ind][1])
	else:
		print("Unit 1 is less")
		for ind,val in zip(range(0,no_of_in),mat[u]):
			M[ind][0] = M[ind][0] + alpha * (val - M[ind][0])

	print("After unit",u+1)
	print(M)
	d1 = d2 = 0

print("\n")
print("==============================")
print("After all the updates are done:")
print("Input array\n")
print(mat)
print("\n")
print("Updated array of weights\n")
print(M)
print("\n")
print("==============================")


#printing cluster values
print("Results:")
for u in range(0,no_of_in):
	for ind,val in zip(range(0,no_of_in),mat[u]):
		d1 = d1 + ((val - M[ind][0])*(val - M[ind][0]))
	for ind,val in zip(range(0,no_of_in),mat[u]):
		d2 = d2 + ((val - M[ind][1])*(val - M[ind][1]))

	if d1 > d2:
		res = "Unit " + str(u+1) + " belongs to 1st output cluster"
		print(res)

	else:
		res = "Unit " + str(u+1) + " belongs to 2nd output cluster"
		print(res)
	d1 = d2 = 0
