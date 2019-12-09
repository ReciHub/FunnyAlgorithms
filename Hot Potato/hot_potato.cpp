#include <iostream>
#include <string.h>
#include <queue>

using namespace std;

string hot_potato(queue<string> names, int repetitions) {
    for (int i = 0; i < repetitions; i++) {
        string person = names.front();
        names.pop();
        names.push(person);
    }

    string personWhoGotCaught = names.front();
    names.pop();
    return personWhoGotCaught;
}

int main() {
    queue<string> names;
    names.push("Nick");
    names.push("John");
    names.push("Connor");
    names.push("Mike");
    names.push("Paul");

    cout << hot_potato(names, 12);

    return 0;
}