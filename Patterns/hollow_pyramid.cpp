#include <iostream>
#include <iomanip>
using namespace std;
// ***********hollow pyramid*********
int main()
{
   int n;
   cout << "enter n" << endl;
   cin >> n;
   int t = n * 2 - 1;
   for (int i = 0; i <= n - 1; i++)
   {
      for (int j = 1; j <= t; j++)
      {
         if (i == n - 1)
         {
            cout << "*";
         }

         else if (j == n - i || j == n + i)
         {
            cout << "*";
         }
         else
            cout << " ";
      }
      cout << endl;
   }
   return 0;
}