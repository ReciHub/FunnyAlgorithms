//Checking if the number is perfect or not
#include <stdio.h>

int isPerfect(int num){
  if(num==1)return 0;
    int sum=1;
    int lim=sqrt(num);
    
    for(int n=2;n<=lim;n++){
        if(num%n==0){sum+=n+(num/n);}
    }
    
    if(sum==num)return 1;
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
