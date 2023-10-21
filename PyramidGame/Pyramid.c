/*This program prompts the user to enter the height of the pyramid and then uses nested loops to print the spaces and asterisks to form the pyramid. Compile and run the program to see the pyramid output based on the user's input.*/
#include <stdio.h>

void buildPyramid(int height)
{
    for (int i = 1; i <= height; i++)
    {
        // Spaces
        for (int j = 0; j < height - i; j++)
        {
            printf(" ");
        }
        // Blocks
        for (int k = 0; k < i * 2 - 1; k++)
        {
            printf("*");
        }
        printf("\n");
    }
}

int main()
{
    int height, n;

    printf("Enter the height of the pyramid: ");
    scanf("%d", &height);
    printf("Enter how many pyramids you want ?");
    scanf("%d", &n);
    int i = 0;
    while (i < n)
    {
        buildPyramid(height);
        i++;
    }

    return 0;
}
