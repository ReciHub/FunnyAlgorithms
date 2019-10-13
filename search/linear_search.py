l = int(input("Enter number of elements in the list:"))
li = []
print("Enter elements one by one:")
for x in range (0,l):
	li.append(int(input()))
etf = int(input("Enter element to find: "))
found = False
location = -1
counter = 0
for x in li:
	if(x==etf):
		found = True
		location = counter
		break
	counter+=1
if(found):
	print("Element "+str(etf)+" found at "+str(location))
else:
	print("Element not found")
