# Solves the maximum consecutive sum in a list
# rewritten from [Maximum_Consecutive_Sum.cpp]

def max_consec_sum(array):
    sum = 0;
    max_sum = array[0]
    for i in range(len(array)):
        sum += array[i]
        sum = max(0, sum)
        max_sum = max(sum, max_sum)
    return max_sum

# Maximum consecutive sum would be 6 + (-2) + 10 = 14
inp_list = [7, 6, -5, -8, 6, -2, 10]
print(max_conseq_sum(inp_list))
