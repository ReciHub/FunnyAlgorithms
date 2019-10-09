size = int(input("Enter number of elements in the list:"))
li = []
print("Enter elements one by one:")
for x in range (0,size):
	li.append(int(input()))
etf = int(input("Enter element to find: "))
li.sort()
min = 0
max = size-1
found = False
while(min<=max):
	mid = (min+max)//2
	if(li[mid] == etf):
		print("Element found at "+str(mid))
		found = True
		break
	elif(etf>li[mid]):
		min = mid+1
	else:
		max = mid-1
if(not found):
	print("Element not found")