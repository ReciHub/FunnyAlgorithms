//Printing n Perfect Numbers
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
  printf("How many perfect numbers you want to print>");
  scanf("%d",&num);
  for(int i=0;i<num;){
    if(isPerfect(temp)==1){
      printf("%d",temp);
      i++;
      temp++;
    }
    else
      temp++;
  }
  return 0;
}
