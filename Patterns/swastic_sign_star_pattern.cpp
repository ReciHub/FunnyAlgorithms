#include<iostream>
#include<iomanip>
using namespace std;  
// ***************swastic sign**************
int main(){
   int n;
   cout<<"enter n"<<endl;
   cin>>n;
   int t=n*2-1;
   for (int i = 1; i <=t; i++)
   {
      for (int j= 1; j<=t; j++)
      {
         if (i<=n)
         {
            if (i==n)
            {
               cout<<"* ";
            }
            
            else if (j==1||j==n)
            {
               cout<<"* ";
            }
            else if (j>n&&i==1)
            {
               cout<<"* ";
            }
            else cout<<"  ";
            
         }
         else if(i>n){
            if (i==t&&j<=n)
            {
               cout<<"* ";
            }
            
           else if (j==n||j==t)
            {
                cout<<"* ";
            }
            else
            cout<<"  ";
         }
         
      }
            cout<<endl;
   }
   return 0;
}