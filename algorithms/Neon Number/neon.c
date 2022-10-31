#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include<stdlib.h>

int main(void)

{
	int number,square,sum=0,tmp;
	printf("enter a number\n");
	scanf("%d", &number);

	square = number * number;	
	tmp = square;
	do	{
		sum += square% 10;
		square = square / 10;
	} while (square > 0);
	printf("%d\n", sum);
	if (number == sum)
	{
		printf("is a neon number\n");
		getch();
		return 0;
	}
	printf("isn't a neon number\n");
	


	getch();
}
