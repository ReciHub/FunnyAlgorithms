#include <iostream>
#include <string>

using namespace std;

void caesarShift(string& phrase, int shiftAmount);

int main() {

    string phrase;
    int shiftAmount;

    // Get the shift parameters

    cout << "Enter your phrase: ";
    getline(cin, phrase);

    cout << "Enter your shift amount: ";
    cin >> shiftAmount;

    caesarShift(phrase, shiftAmount);

    cout << endl << phrase;

    return 0;
}

void caesarShift(string& phrase, int shiftAmount) {
    // Caesar Shift a certain phrase by a certain amount

    int normalizedAmount = shiftAmount % 26;  // Ensure that the shiftAmount keeps letters between a-z

    for (int i = 0; i < phrase.length(); i++) {  // Shift each letter

        if (phrase[i] >= 65 && phrase[i] <= 90 && phrase[i] + normalizedAmount > 90)  // Uppercase overflow
            phrase[i] = phrase[i] + normalizedAmount - 26;
        
        else if (phrase[i] >= 97 && phrase[i] <= 122 && phrase[i] + normalizedAmount > 122)  // Lowercase overflow
            phrase[i] = phrase[i] + normalizedAmount - 26;

        else if (!(phrase[i] >= 65 && phrase[i] <= 90) && !(phrase[i] >= 97 && phrase[i] <= 122))  // Leave all non-letter characters as they are
            continue;

        else
            phrase[i] = phrase[i] + normalizedAmount;
    }
}