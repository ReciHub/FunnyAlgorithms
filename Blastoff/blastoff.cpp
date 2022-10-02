#include <iostream>
using namespace std;

int main()
{
    int n;
    cout << "How much you wanna blast: ";   //gettig input from the user
    cin >> n;
    
    cout << endl << endl;
    
    cout << "Before Blasting: ";  
    for(int i=1;i<=n;i++) cout << i <<' ';   //before reversing
    
    cout << endl << endl;
    
    cout << "After Blasting: ";
    for(int i=1;i<=n;i++) cout << n-i+1 <<' ';   //after reversing

    return 0;
}
