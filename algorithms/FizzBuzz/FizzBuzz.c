// FizzBuzz in C
#include <stdio.h>

void fizzbuzz(int limit)
{
    int i;
    for (i = 1; i <= limit; i++)
    {
        if (i % 15 == 0)
        {
            printf("FizzBuzz : %d\n", i);
        }
        else if (i % 3 == 0)
        {
            printf("Fizz : %d\n", i);
        }
        else if (i % 5 == 0)
        {
            printf("Buzz : %d\n", i);
        }
    }
}

int main()
{
    int limit;
    printf("Enter Limit-");
    scanf("%d", &limit);
    fizzbuzz(limit);
    return 0;
}