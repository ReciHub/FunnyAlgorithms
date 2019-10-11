def LCSubStr(X, Y, m, n): 
    LCSuff = [[0 for k in range(n+1)] for l in range(m+1)] 
    result = 0
    for i in range(m + 1): 
        for j in range(n + 1): 
            if (i == 0 or j == 0): 
                LCSuff[i][j] = 0
            elif (X[i-1] == Y[j-1]): 
                LCSuff[i][j] = LCSuff[i-1][j-1] + 1
                result = max(result, LCSuff[i][j]) 
            else: 
                LCSuff[i][j] = 0
    return result 
X = input()
Y = input()
  
m = len(X) 
n = len(Y) 
  
print('Length of Longest Common Substring is', LCSubStr(X, Y, m, n)) 