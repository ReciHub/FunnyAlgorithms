#include<iostream>
#include<iomanip>
using namespace std;
//***************inverted half pyramid **************
// method 1
   int main(){
      int n;
      //char c = 2;
      char c=100;
      cout<<"enter the value of n"<<endl;
      cin>>n;
      for (int i = 1; i <=n; i++)
      {  
         cout<<c<<" ";
          if(i==n){
          n=n-1;
          i=0;
          cout<<endl;
          }
      }
      return 0;
   }
   
// method 2
 int main(){
    int n;
    cout<<"enter the n"<<endl;
    cin>>n;
    for (int i =n; i <= n; i--){
    for(int j =1; j<=i; j++)
    {
      cout<<"* ";
      if(j==i)
      cout<<endl;
    }
    }
    return 0;
 }