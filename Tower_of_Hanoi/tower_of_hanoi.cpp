#include <bits/stdc++.h>
using namespace std;
void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod)
{
    if (n > 0)
    {
    towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
    cout << "Move disk " << n << " from rod " << from_rod << " to rod " << to_rod << endl;
    towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
     }
}
int main()
{
    int n;
  cout<<" enter number of disks ";
  cin>>n;    //user defined number of disks;
    towerOfHanoi(n, 'A', 'C', 'B'); // A, B and C are names of rods
    return 0;
}
