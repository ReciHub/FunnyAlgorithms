#include <iostream>
#include <iomanip>
using namespace std;
// **************floyd's triangle************
int main()
{
   int n, k = 1, j = 0, i = 0;
   cout << "enter n" << endl;
   cin >> n;
   for (i = 1; i <= n; i++)
   {
      for (j = 1; j <= i; j++)
      {
         cout << k << " ";
         k++;
      }
      // k=k;
      cout << endl;
   }
   return 0;
}