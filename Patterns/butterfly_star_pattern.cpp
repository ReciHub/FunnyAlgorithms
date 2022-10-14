#include<iostream>
#include<iomanip>
using namespace std;  
// ***************butterfly pattern***************
int main(){
   int n;
   cout<<"enter n"<<endl;
   cin>>n;
   for(int i=1;i<=(n*2); i++)
   {
      for (int j = 1; j <=(n*2); j++)
      {
         if (i<=n)
         {
            if (j<=i||j>(2*n)-i)
               cout<<"* ";
            else
               cout<<"  ";
         } 
         else if(i>n)
         { 
            if (j<=2*n-i+1||j>=i)
               cout<<"* ";
            else
               cout<<"  ";
         }   
   
      }
         cout<<endl;
   }
      return 0;
}