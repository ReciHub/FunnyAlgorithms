#include<stdio.h>

void collatz(int Num){

	int iterations = 0;
	while ( Num > 1 ){
		Num = (Num%2 == 0) ? Num/2 : 3*Num+1;
		iterations ++;
	}
	printf("reached 1 after %d iterations\n", iterations);

}

int main(){

	int n;
	
	printf("Enter a +ve number = ");
	scanf("%d", &n);
	
	collatz(n);
	
	return 0;
}
