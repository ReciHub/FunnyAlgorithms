#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

int longestConsecutiveAP(vector<int>& arr) {
    int n = arr.size();
    if (n <= 2) {
        return n; // If there are 2 or fewer elements, the answer is n.
    }

    // Create a map to store the length of the longest AP ending at index i with common difference d.
    unordered_map<int, unordered_map<int, int>> dp;

    int longestLength = 2; // Initialize with a minimum length of 2

    // Initialize dp for common difference 0 (single element).
    for (int i = 0; i < n; ++i) {
        dp[i][0] = 1;
    }

    for (int i = 1; i < n; ++i) {
        for (int j = i - 1; j >= 0; --j) {
            int diff = arr[i] - arr[j];
            dp[i][diff] = dp[j][diff] + 1; // Increment the length of the current AP

            // Update the longest length
            longestLength = max(longestLength, dp[i][diff]);
        }
    }

    return longestLength;
}

int main() {
    int n;
    cin >> n;

    vector<int> arr(n);

    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }

    int result = longestConsecutiveAP(arr);
    cout << result << endl;

    return 0;
}