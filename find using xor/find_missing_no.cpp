// find the missing number from n-1 natural numbers using xor.

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int x = 0;
    for (int i = 0; i < n - 1; i++)
    {
        int k;
        cin >> k;
        x = x ^ k;
    }

    for (int i = 1; i <= n; i++)
    {
        x = x ^ i;
    }

    cout << "Missing number is: " << x << "\n";
    return 0;
}