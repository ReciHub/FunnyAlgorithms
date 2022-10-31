#include <stdio.h>

int main(){

  int n,i,j;
  printf("Enter the number: ");
  scanf("%d",&n);

  int is_prime[n+1];

  for(i = 2; i <= n; i++)
    is_prime[i] = 1;

  // Optimisation - 1: Checking till the sqaure root of the number
  for(i = 2; i*i <= n; i++){
    if(is_prime[i]){
      // Optimisation - 2: Checking from the sqaure of the number
      for(j = i*i; j <= n; j += i){
        is_prime[j] = 0;
      }
    }
  }

  for(i = 2; i <= n; i++){
    if(is_prime[i]){
      printf("%d ", i);
    }
  }

  return 0;
}