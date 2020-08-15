#include<stdio.h>

void fibonacci(int n){

	int a = 0, b = 1, c;
	
	while(n>0){
		printf("%d, ", a);
		c = a+b;
		a = b;
		b = c;
		n--;
	}
}

int main(){

	int n;
	
	printf("Enter limit = ");
	scanf("%d", &n);
	
	fibonacci(n);
	
	return 0;
}
