// This algorithm gets your age+2 and your age-2 to calculate your age.
// Very useful
#include<iostream>

using namespace std;

int main(){
    int ageplus, ageminus, age;
    cout << "Enter your age+2: ";
    cin >> ageplus;
    cout << endl << "Enter your age-2: ";
    cin >> ageminus;
    cout << endl << endl << endl << "Calculating...";

    age = ageplus - 2;

    cout << endl << endl << endl << "Your age is " << age << " !!!!" << endl;
    
    return 0;
}