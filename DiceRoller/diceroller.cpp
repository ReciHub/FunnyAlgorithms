#include <iostream>
#include <stdlib.h>
 
using namespace std;
 
int main(int argc, char **argv)
{
    cout << "Enter the number of dice: ";
    int n;
    cin >> n;
    cout << "The values on dice are: ( ";
    for (int i = 0; i < n; i++)
        cout << (rand() % 6) + 1<<" ";
    cout<<")";
}
