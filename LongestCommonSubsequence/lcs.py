def longest_common_subsequence(str1, str2):
    m, n = len(str1), len(str2)

    # Create a table to store the length of LCS at each (i, j) position
    lcs_table = [[0] * (n + 1) for _ in range(m + 1)]

    # Build the LCS table
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if str1[i - 1] == str2[j - 1]:
                lcs_table[i][j] = 1 + lcs_table[i - 1][j - 1]
            else:
                lcs_table[i][j] = max(lcs_table[i - 1][j], lcs_table[i][j - 1])

    # Reconstruct the LCS
    lcs = []
    i, j = m, n
    while i > 0 and j > 0:
        if str1[i - 1] == str2[j - 1]:
            lcs.append(str1[i - 1])
            i -= 1
            j -= 1
        elif lcs_table[i - 1][j] > lcs_table[i][j - 1]:
            i -= 1
        else:
            j -= 1

    return "".join(reversed(lcs))

# Example usage
str1 = "AGGTAB"
str2 = "GXTXAYB"
result = longest_common_subsequence(str1, str2)
print("Longest Common Subsequence:", result)
