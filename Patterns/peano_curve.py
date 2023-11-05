def f1(p):
    z=''
    for i in range (len(p)):
        if p[i]=='R':
            z=z+'L'
    
        elif p[i]=='U':
            z=z+'U'
        elif p[i]=='L':
            z=z+'L'
        elif p[i]=='D':
            z=z+'D'
    
    return z 
def f2(a):
    b=''
    for i in range (len(a)):
        if a[i]=='D':
            b=b+'U'
        if a[i]=='U':
            b=b+'D'
        if a[i]=='L':
            b=b+'L'
        if a[i]=='R':
            b=b+'R'
    return b
def f3(c):
    e=''
    for i in range (len(c)):
        if c[i] =='D':
            e=e+'U'
        if c[i]=='U':
            e=e+'D'
        if c[i] =='R':
            e=e+'L'
        if c[i]=='L':
            e=e+'L'
    return e 
def function(q):
    

    if q==1:
        return 'URDRU'
    else:
        return function(q-1)+'U'+f1(function(q-1))+'U'+f2(function(q-1))+'R'+f3(function(q-1))+'D'+f3(function(q-1))+'D'+f2(function(q-1))+'R'+function(q-1)+'U'+f1(function(q-1))+'U'+function(q-1)
def cordinate(h):
    l=[(1,1)]
    x=1
    y=1
    for i in range (len(h)):
        if h[i]=='D':
            x+=1
        elif h[i]=='R':
            y+=1
        elif h[i]=='U':
            x-=1
        elif h[i]=='L':
            y-=1
        l.append((x,y))
    return(l) 
q=(int(input("enter a number")))
print(cordinate(function(q)))
print()
     
        
    
    
