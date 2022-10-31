#include <iostream>
#include <iomanip>
using namespace std;
// ***********full pyramid************
int main()
{
   int n;
   cout << "enter n" << endl;
   cin >> n;
   for (int i = 1; i <= n; i++)
   {
      for (int j = 1; j <= n - i; j++)
      {
         cout << " ";
      }
      for (int k = 1; k <= i; k++)
      {
         cout << "* ";
      }
      cout << endl;
   }
   return 0;
}