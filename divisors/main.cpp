#include <iostream>
#include <math.h>

using namespace std;

int main() {
    unsigned int n;
    cin >> n;

    for (int i = 1; i <= sqrt(n); i++)
    {
        if (n % i == 0)
        {
            cout << i << endl;
        }
    }
    for (int i = sqrt(n); i >= 1; i--)
    {
        if (n % i == 0)
        {
            if (i * i != n)
            {
                cout << n / i << endl;
            }
        }
    }
}