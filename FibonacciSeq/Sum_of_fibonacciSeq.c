#include<stdio.h>
#include<stdlib.h>

int f(int x)
{
    if (x == 1)
        return 1;
    else if(x == 2)
        return 1;
    else
        return (f(x-1) + f(x-2));
}

int main()
{
    system("cls");
    int n;
    printf("Enter the value of n: ");
    scanf("%d",&n);
    
    printf("The sum of first %d terms of fibonacci series is %d", n,f(n));
    return 0;
}
