#
# Python3 Version
# 0-1 Knapsack Problem using DP
#

def main():
    weights = [10, 20, 30]
    vals = [60, 100, 120]
    print(solve(3, 50, weights, vals))

def solve(item_num, max_weight, weights, vals):

    dp = [[0 for x in range(max_weight+1)] for y in range(item_num+1)]

    for i in range(1,item_num+1):
        for j in range(1,max_weight+1):
            if j-weights[i-1] >= 0:
                dp[i][j] = max(dp[i-1][j-weights[i-1]]+vals[i-1], dp[i-1][j])
            else:
                dp[i][j] = dp[i-1][j]

    return dp[item_num][max_weight]

main()
