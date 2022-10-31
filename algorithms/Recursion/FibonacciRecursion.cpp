#include <iostream>
using namespace std;

int main(){
    int n, n1 = 0, n2 = 1, n3 = 0;

    cout << "Enter number: ";
    cin >> n;

    cout << "Fibonacci sequence: ";

       cout << "Fibonacci Series: " << n1 << ", " << n2 << ", ";

    n3 = n1 + n2;
    while(n3 <= n)
    {
        cout << n3 << ", ";
        n1 = n2;
        n2 = n3;
        n3 = n1 + n2;
    }
    return 0;
}