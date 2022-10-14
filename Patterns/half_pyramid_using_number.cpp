#include<iostream>
#include<iomanip>
using namespace std;
// ************half pyramid using number**************
int main(){
    int n;
    cout<<"enter n"<<endl;
    cin>>n;
    for (int i = 1; i <=n; i++)
    {
       for (int j = 1; j<=i; j++)
       {
          cout<<i<<" ";
       }
       cout<<endl;
    }
    return 0;
 }