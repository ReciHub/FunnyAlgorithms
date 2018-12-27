#include <stdio.h>

int sum_of_numbers_iterative(int n){
    int the_sum = 0, i;

    for(i=0; i<=n; i++)
        the_sum += i;

    return the_sum;
}

void main(){
	int n;

	printf("Enter a number: ");
	scanf("%d", &n);

	printf("%d\n", sum_of_numbers_iterative(n));  //5+4+3+2+1 = 15
}
