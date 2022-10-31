#include<iostream>
using namespace std;

void fib(int n);

int main()
{
    int n;

    cout << "Enter a positive integer: ";
    cin >> n;
	cout << "Fib of " << n << " = " ;
	fib(n);
    return 0;
}

void fib(int n)
{
    int sum1=0,sum2=1,i,sum;
    cout<<"0 ";
    for(i=1;i<=n;i++)
    {
        sum=sum1+sum2;
        sum2=sum1;
        sum1=sum;
        cout<<sum<<" ";
}
}
