#include<iostream>
using namespace std;

long long int factorial(long long int n)
{
    if(n > 1)
        return n * factorial(n - 1);
    else
        return 1;
}

int main()
{
    long long int n;

    cout << "Enter a positive integer: ";
    cin >> n;

    cout << "Factorial of " << n << " = " << factorial(n) << std::endl;

    return 0;
}

