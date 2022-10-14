#include<iostream>
#include<iomanip>
using namespace std;  
// *************number pyramid**************
int main(){
   int n;
   cout<<"enter n"<<endl;
   cin>>n;
   for (int i = 1; i <=n; i++)
   {
      int count=1;
      for (int j = 1; j <=n-i; j++)
      { 
         cout<<" ";
      }
   
      for(int k=1; k<=i; k++){
      cout<<count<<" ";
      if (k<n)
      {
         count++;
      }
      else
      count--;
      }
      cout<<endl;
   }
   return 0;
}