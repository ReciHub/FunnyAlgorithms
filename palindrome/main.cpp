#include <iostream>

using namespace std;

int main() {
    string n;
    cin >> n;
    
    for (int i = 0; i < n.length(); i++)
    {
        if (n[i] != n[n.length() - 1 - i])
        {
            cout << "Word is a palindrome!";
            return 0;
        }
    }
    
    cout << "Word is not a palindrome!" << endl;
    return 0;
}
