//Printing n Perfect Numbers
#include <stdio.h>
#include <math.h>

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
  printf("How many perfect numbers you want to print>");
  scanf("%d",&num);
  for(int i=0;i<num;){
    if(isPerfect(temp)==1){
      printf("%d\n",temp);
      i++;
      temp++;
    }
    else
      temp++;
  }
  return 0;
}
