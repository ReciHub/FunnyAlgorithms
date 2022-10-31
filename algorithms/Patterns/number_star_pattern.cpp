#include <bits/stdc++.h>
using namespace std;
// *************number star pattern***********
// pyramid of stars and numbers are in increasing order before stars and decreasing order after stars
int main()
{
    int n, count;
    cout << "enter the number of rows" << endl;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        count = 1;
        for (int j = 1; j < n * 2; j++)
        {
            if (j >= n - i && j <= n + i)
            {
                cout << "*";
            }
            else
            {
                cout << count;
                if (count <= n - i)
                {
                    count++;
                }
                else if (count > n + i)
                {
                    count--;
                }
            }
        }
        cout << endl;
    }
    return 0;
}