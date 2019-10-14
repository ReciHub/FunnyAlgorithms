#include <stdio.h>
#include <conio.h>

void main()
{
    int i, n, product;
    printf("enter a number \n");
    scanf("%d",&n);
    product=1;
    for(i=n; i>=1; i--)
    {
        product=product*i;
    }
    printf("%d",product);
    getch();
}
