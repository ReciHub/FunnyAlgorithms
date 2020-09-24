#include <stdio.h>

int prime(int n)
{
	int i;
  	if (n == 1) 
	{
    		return 0;
  	}
  	else 
	{
    		for (i = 2; i < n; i++) 
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
	printf("\n Enter the number to check for prime or not");
	scanf("%d", &n);
	int r;
	r = prime(n);
	if(r==1)
	{
		printf("\n prime");
	}
	else
	{
		printf("\n not prime");
	}
	return 0;
}
