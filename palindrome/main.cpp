#include <iostream>

using namespace std;

int main() {
    string n;
    cin >> n;
    
    for (int i = 0; i < n.length(); i++)
    {
        if (n[i] != n[n.length() - 1 - i])
        {
            cout << "Wyraz nie jest palindromem.";
            return 0;
        }
    }
    
    cout << "Wyraz jest palindromem." << endl;
    return 0;
}
