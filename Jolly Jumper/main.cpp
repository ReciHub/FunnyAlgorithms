// Program for Jolly Jumper Sequence
#include<bits/stdc++.h>
using namespace std;

// Function to check whether given sequence is
// Jolly Jumper or not
bool isJolly(int a[], int n)
{
    // Boolean vector to diffSet set of differences.
    // The vector is initialized as false.
    vector<bool> diffSet(n, false);

    // Traverse all array elements
    for (int i=0; i < n-1 ; i++)
    {
        // Find absolute difference between current two
        int d = abs(a[i]-a[i+1]);

        // If difference is out of range or repeated,
        // return false.
        if (d == 0 || d > n-1 || diffSet[d] == true)
            return false;

        // Set presence of d in set.
        diffSet[d] = true;
    }

    return true;
}
int main()
{
    int n;
    cout<<"Enter the size of array\n";
    cin >> n;
    int a[n];
    cout<<"Enter the elements of array\n";
    for(int i=0;i<n;++i)
        cin >> a[i];
    isJolly(a, n)? cout << "Yes" : cout << "No";
    return 0;
}