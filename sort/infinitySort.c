#include <stdio.h>
#include <time.h>
#include <stdlib.h>

#define FALSE 0
#define TRUE 1

char _isSorted(int *inputArray, int numberOfInputs);
void _changeElements(int inputArray[], int numberOfInputs);

int main(void)
{
    int numberOfInputs, actualNumber;
    printf("How many numbers do you want to receive?: ");
    scanf("%d", &numberOfInputs);
    int inputArray[numberOfInputs];
    srand(time(NULL));
    for (actualNumber = 0; actualNumber < numberOfInputs; actualNumber++)
    {
        scanf("%d", &inputArray[actualNumber]);
    }

    printf("Received %d array:\n", numberOfInputs);
    for (actualNumber = 0; actualNumber < numberOfInputs; actualNumber++)
    {
        printf("%d ", inputArray[actualNumber]); // PQ DA DANADOS ESSE PRINT NAO SAI QUANDO EU COLOCO 20?
    }

    while (!_isSorted(inputArray, numberOfInputs))
    {
        _changeElements(inputArray, numberOfInputs);
    }
    printf("Your array is sorted:\n");
    for (actualNumber = 0; actualNumber < numberOfInputs; actualNumber++)
        printf("%d ", inputArray[actualNumber]);
    return 0;
}

char _isSorted(int *inputArray, int numberOfInputs)
{
    int actualNumber;
    for (actualNumber = 0; actualNumber < numberOfInputs - 1; actualNumber++)
    {
        if (inputArray[actualNumber] > inputArray[actualNumber + 1])
            return FALSE;
    }
    return TRUE;
}

void _changeElements(int *inputArray, int numberOfInputs)
{
    int tmpElement, rand1, rand2;
    rand1 = rand() % numberOfInputs;
    rand2 = rand() % numberOfInputs;
    tmpElement = inputArray[rand1];
    inputArray[rand1] = inputArray[rand2];
    inputArray[rand2] = tmpElement;
}
