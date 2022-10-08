t = int(input())
while(t>0):
    t-=1
    n = int(input())
    mus = dict()
    while(n>0):
        n-=1
        a,b = list(map(int,input().split()))
        if(a not in mus):
            mus[a] = list()
        mus[a].append(b)
    x = []
    y = []
    z = []
    mus = (sorted(mus.items()))
    for i in mus:
        if(i[0] not in x):
            x.append(i[0])
            y.append(min(i[1]))
            i[1].remove(min(i[1]))
            if(len(i[1])>0):
                z+=(i[1])
    ans = 0
    for j in range(len(y)):
        ans = ans + (j+1)*y[j]
    for k in range(len(z)):
        ans = ans + len(y)*z[k]
    print(ans)
    
