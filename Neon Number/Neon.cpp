#include <iostream>
using namespace std;
 
int main() {
   int n,sq,sum = 0;
   cout<<"Enter the number: ";
   cin>>n;
   sq = n * n;//find square of number
   /*calculating the sum of square*/
   while(sq > 0)
   {
       sum = sum + sq % 10;
       sq = sq / 10;
   }
   if(sum == n)
   {
       cout<<n<<" is a neon number.";
   }
   else
   {
       cout<<n<<" is not a neon number.";
   }
   return 0;
}
