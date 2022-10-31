n=int(input()) #input number of elements in array
l=[int(input()) for i in range(n)] #input elements of array
count=0
for i in range(n):
    if l[i]!=0:
        l[count]=l[i]
        count+=1
while(count<n):
    l[count]=0
    count+=1
print(l)
