#include <stdio.h>

void main()
{
    int n,a,sum,t;
    printf("enter any number ");
    scanf("%d",&n);
    sum=0;
    t=n;
    while(n>0 )
    {
         a=n%10;
         n=n/10;
         sum=(sum*10)+a;
    }
         if(t==sum)
             printf("number is palindrome");
         else
             printf("number is not palindrome");

}
