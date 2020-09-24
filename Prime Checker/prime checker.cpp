#include <iostream>
using namespace std;

int prime(int n)
{
  	if (n == 1) 
	{
    		return 0;
  	}
  	else 
	{
    		for (int i = 2; i < n; i++) 
		{
      			if (n % i == 0)
				{
        				return 0;
      				}
    		}
    		return 1;
  	}
}

int main() 
{
	int n;
	cout<<"\n Enter the number to check for prime or not";
	cin>>n;
	int r = prime(n);
	if(r==1)
	{
		cout<<"\n prime";
	}
	else
	{
		cout<<"\n not prime";
	}
	return 0;
}
