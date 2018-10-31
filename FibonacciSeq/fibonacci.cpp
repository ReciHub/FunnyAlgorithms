#include<iostream>
using namespace std;

int fib(int n);

int main()
{
    int n;

    cout << "Enter a positive integer: ";
    cin >> n;
	cout << "Fib of " << n << " = " << fib(n) << std::endl;
    return 0;
}

int fib(int n)
{
	if(n == 0 || n == 1)
	{
		return 1;
	}
    else if(n > 1)
    {
        return (fib(n - 2) + fib(n - 1));
    }
}
