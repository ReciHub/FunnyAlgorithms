#include<bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cout << "How long you want to blastoff: ";   // Taking input from user
    cin >> n;
    
    cout << endl << endl;   // endl to skip lines
    
    cout << "Before Blasting: ";
    for(int i=1;i<=n;i++) cout << i <<' ';  // Before reversing
    
    cout << endl << endl;
    
    cout << " After Blasting: ";
    for(int i=1;i<=n;i++) cout << n-i+1 <<' ';   //After reversing;
}
