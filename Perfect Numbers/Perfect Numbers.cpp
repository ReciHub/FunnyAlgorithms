#include <iostream>

using namespace std;

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
  cout<<"How many perfect numbers you want to print>";
  cin>>num;
  for(int i=0;i<num;){
    if(isPerfect(temp)==1){
      cout<<temp<<endl;
      i++;
      temp++;
    }
    else
      temp++;
  }
  return 0;
}