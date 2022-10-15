#include <iostream>
using namespace std;

int main(){

   for (int i=1; i<=100; i++){

      if (i%15 == 0)
         cout<<"Fizz Buzz,\t";
      else if ((i%3) == 0)
         cout<<"Fizz,\t";
      else if ((i%5) == 0)
         cout<<"Buzz,\t";
      else
         cout<<i<<",\t";
   }
   return 0;
}
