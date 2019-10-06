# Athlete sort
# Sort by key of list:

# arr.sort(key = lambda x: x[index]) 
# OR
# sorted(arr,key=lambda x: x[i])



if __name__ == '__main__':
    nm = input().split()
    n = int(nm[0])
    m = int(nm[1])
    arr = []
    for _ in range(n):
        arr.append(list(map(int, input().rstrip().split())))
        #print(arr)
    k = int(input())
    arr.sort(key = lambda x:x[k])
    for x in arr:
        for e in x:
            print(e,end=' ')
            #print(str(e).join(' '))
        print('')
    #print(arr)