#include <iostream>
#include <iomanip>
using namespace std;
// ************full pyramid inverse*************
int main()
{
   int n;
   cout << "enter n" << endl;
   cin >> n;
   for (int i = n; i > 0; i--)
   {
      for (int k = 1; k <= n - i; k++)
      {
         cout << " ";
      }

      for (int j = 1; j <= i; j++)
      {
         cout << "* ";
      }
      cout << endl;
   }
}