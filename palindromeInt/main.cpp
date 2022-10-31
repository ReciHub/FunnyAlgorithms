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
        cout << "This number is palindrome!" << endl;
        return 0;
    } else
    {
        cout << "This number is not palindrome!" << endl;
        return 0;
    }
}
