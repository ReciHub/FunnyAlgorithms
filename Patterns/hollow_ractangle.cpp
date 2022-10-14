#include<iostream>
#include<iomanip>
using namespace std;
// *******************hollow ractangle******************
int main(){
   int row, col;
   cout<<"enter row and colum"<<endl;
   cin>>row>>col;
   for (int i = 1; i <= row; i++){
   for(int j=1; j<= col; j++)
   {
      if (i==1 || i==row)
      {
         cout<<"*";
      }
      else if (j==1||j==col)
      {
         cout<<"*";
      }
      else
      cout<<" ";
   }  
      cout<<endl;
   }
   return 0;
   }