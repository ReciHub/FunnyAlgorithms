#include<iostream>
#include<iomanip>
using namespace std;
// ************ 0-1 pattern**********
int main(){
   int n;
   cout<<"enter n"<<endl;
   cin>>n;
   for (int i = 1; i <=n; i++)
   {
     for (int j = 1; j<=i; j++)
     {
        if((i+j)%2==0)
        cout<<1<<" ";
        else
        cout<<0<<" ";
     }
     cout<<endl;
   }
   return 0;
}