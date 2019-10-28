#Python implementation of Knapsack problem
#Using a recursive approach

def knapsack(W, wt , v, n):
    if n==0 or W==0:
        return 0
    if (wt[n-1]>W):
        return knapsack(W,wt,v,n-1)
    else:
        return max(v[n-1] + knapsack(W-wt[n-1], wt, v, n-1), knapsack(W,wt,v,n-1))
    
    
    
'''
Example:
    
v = [10,20,30]

wt = [20,10,12]

W = 60

n = len(v)

print(knapsack(W,wt,v,n))
60

v = [10,20,10]

wt = [20,10,30]

W = 50

n = len(v)

print(knapsack(W,wt,v,n))
30'''

