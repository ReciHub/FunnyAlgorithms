# 
# python3 version
# LCS
#

def main():
    
    a = "OldSite:GeeksforGeeks.org" 
    b = "NewSite:GeeksQuiz.com"

    print(solve(a, b))

def solve(str_a, str_b):
    
    dp = [[0 for x in range(len(str_b)+1)] for y in range(len(str_a)+1)]
    res = 0;
    for i in range(1, len(str_a)+1): 
        for j in range(1, len(str_b)+1):
            if str_a[i-1] == str_b[j-1]:
                dp[i][j] = dp[i-1][j-1]+1;
                res = max(res, dp[i][j])
            else:
                dp[i][j] = 0

    return res

main()
