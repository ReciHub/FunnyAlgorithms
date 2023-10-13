#include <iostream>
#include <vector>
#include <string>

std::string longest_common_subsequence(const std::string& str1, const std::string& str2) {
    int m = str1.length();
    int n = str2.length();

    // Create a table to store the length of LCS at each (i, j) position
    std::vector<std::vector<int>> lcs_table(m + 1, std::vector<int>(n + 1, 0));

    // Build the LCS table
    for (int i = 1; i <= m; ++i) {
        for (int j = 1; j <= n; ++j) {
            if (str1[i - 1] == str2[j - 1]) {
                lcs_table[i][j] = 1 + lcs_table[i - 1][j - 1];
            } else {
                lcs_table[i][j] = std::max(lcs_table[i - 1][j], lcs_table[i][j - 1]);
            }
        }
    }

    // Reconstruct the LCS
    int length = lcs_table[m][n];
    std::string lcs(length, ' ');

    int i = m, j = n;
    while (i > 0 && j > 0) {
        if (str1[i - 1] == str2[j - 1]) {
            lcs[length - 1] = str1[i - 1];
            --i;
            --j;
            --length;
        } else if (lcs_table[i - 1][j] > lcs_table[i][j - 1]) {
            --i;
        } else {
            --j;
        }
    }

    return lcs;
}

int main() {
    std::string str1 = "AGGTAB";
    std::string str2 = "GXTXAYB";
    std::string result = longest_common_subsequence(str1, str2);
    std::cout << "Longest Common Subsequence: " << result << std::endl;
    return 0;
}
