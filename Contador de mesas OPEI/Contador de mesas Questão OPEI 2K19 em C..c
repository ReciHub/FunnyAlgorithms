#include <stdio.h>

int main()
{
    int numeroPessoas;
    int numeroDeMesas = 0;
    
    scanf("%d", &numeroPessoas);
    
    if (numeroPessoas > 4)
    {
        numeroDeMesas ++;
        numeroPessoas -= 3;
        
        while(numeroPessoas > 3)
        {
            numeroPessoas -= 2;
            numeroDeMesas++;
        }
        
        if (numeroPessoas > 1)
        {
            numeroDeMesas++;
        }
    }
    else
    {
        printf("4");
    }
    
    printf("%d", numeroDeMesas);
}

