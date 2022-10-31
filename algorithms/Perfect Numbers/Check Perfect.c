//Checking if the number is perfect or not
#include <stdio.h>

int isPerfect(int num){
  int count=0;
  for(int i=1;i<num;i++){
    if(num%i==0){
      count+=i;
    }
  }
  if(num==count)
    return 1;
  else
    return 0;
}

int main(){
  int num,temp=1;
  printf("Enter a number to check>");
  scanf("%d",&num);
  if(isPerfect(num)){
    printf("\nThe number(%d) is perfect",num);
  }
  else{
    printf("\nThe number is NOT perfect");
  }
  return 0;
}
