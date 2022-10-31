#include <iostream>

using namespace std;

int main() {
    int n, number, digit, reversed = 0;
    cin >> n;
    
    number = n;
    
    do
    {
        digit = number % 10;
        reversed = (reversed * 10) + digit;
        number = number / 10;
    } while (number != 0);
        
    if (n == reversed)
    {
        cout << "Liczba jest palindromem." << endl;
        return 0;
    } else
    {
        cout << "Liczna nie jest palindromem" << endl;
        return 0;
    }
}
