#include <iostream>
#include <cmath>

using namespace std;

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
