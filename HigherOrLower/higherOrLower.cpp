#include <iostream>

using namespace std;

int main()
{
    cout<<"Think of a number between 1 and 100! and I'll guess it\n";
    cout<<"This is a simple way to show how Binary Search works...\n";

    int number, min{1}, max{100};
    number = (max+min)/2;
    char input{'a'};
    do
    {
        cout<<"Is your number "<< number <<"?\n";
        cout<<"The number is higher than this - H\n";
        cout<<"The number is Lower than this - L\n";
        cout<<"This is my number! - any key\n";

        cin>>input;

        switch (input)
        {
        case 'H':
        case 'h':
            min = number;
            break;
        case 'L':
        case 'l':
            max = number; 
        default:
            break;
        }   
        number = (max+min)/2;
    } while(input == 'H' || input == 'L' || input == 'h' || input == 'l');
    cout<<"Got it! Thanks for playing!\n";
    return 0;
}