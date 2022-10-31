
def cutting_rod(n,values):

    memo = [None]*(n+1)
    memo[0] = 0

    for j in range(1,n+1):
        best = 0
        for i in range(0,j):
            best = max(best,values[i] + memo[j-i-1])
        memo[j] = best
        print(memo)
    return memo[n]

values = [1,3,4,7,8,9]

print(cutting_rod(len(values),values))
