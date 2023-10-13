# Longest Common Subsequence (LCS) Finder

This is a Python program that finds the Longest Common Subsequence (LCS) between two input strings. The LCS is the longest sequence of characters that appears in both strings in the same order but not necessarily consecutively.

## How It Works

The program uses dynamic programming to efficiently find the LCS. It constructs a table (`lcs_table`) to store the lengths of the LCS at each position. The key steps include:

1. Create an `m x n` table to store the lengths of the LCS of substrings of the input strings, where `m` and `n` are the lengths of the two input strings.

2. Initialize the table with zeros.

3. Fill in the table using a dynamic programming approach. If the characters at the current positions in the input strings match, the LCS length at that position is one plus the LCS length of the previous positions. If they do not match, it's the maximum of the LCS length from the previous row and the current row's previous column.

4. Reconstruct the LCS based on the completed table.

## How to Use

1. Replace the `str1` and `str2` variables with your desired input strings.

2. Run the script using Python.

3. The program will output the longest common subsequence found between the two input strings.

## Example

```python
str1 = "AGGTAB"
str2 = "GXTXAYB"
result = longest_common_subsequence(str1, str2)
print("Longest Common Subsequence:", result)
