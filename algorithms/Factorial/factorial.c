// C program to find factorial of given number 

#include<stdio.h> 

typedef long long int llu

// function to find factorial of given number 

llu factorial(llu n)       //Recursive function for the factorial
{ 
	if (n == 0) {
		return 1;      //Base case for recursive function factorial
	}
	
	else{
		return n*factorial(n-1);     //If base case is not achieved
	}
} 

int main()                         //Driver Function
{ 
	llu num;
	scanf(%lld, &num)
	printf("Factorial of %d is %d", num, factorial(num)); 
	return 0;
}
