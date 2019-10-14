alist=list(map(int, input().split()))
for i in range(len(alist)-1):
    for j in range(i+1,len(alist)-1):
        if alist[i]>alist[j]:
            temp=alist[i]
            alist[i]=alist[j]
            alist[j]=temp
print(alist)
