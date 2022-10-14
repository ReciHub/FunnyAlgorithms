#include<iostream>
#include<iomanip>
using namespace std;
// ***************rhombus pattern************
int main(){
   int n, row;
   cout<<"enter n"<<endl;
   cin>>n;
   row=(n-1)+n;
   for (int i = 1; i <=n; i++)
   {
      for (int j = 1; j<=row; j++)
      {
         if(j<=n-i || j>row-(i-1))
         cout<<" ";
         else
         cout<<"* ";
      }
      cout<<endl;
   }
   return 0;
}