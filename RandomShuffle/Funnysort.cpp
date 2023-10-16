// Created by :- Rohan

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void funnySort(vector<int> &arr)
{
    cout << "Shuffling array using the 'Random Shuffle' algorithm..." << endl;
    random_shuffle(arr.begin(), arr.end());
    cout << "Oops! Array shuffled, but not really sorted! 😄" << endl;
}

int main()
{
    vector<int> arr = {5, 2, 8, 1, 3};

    cout << "Original array: ";
    for (int num : arr)
    {
        cout << num << " ";
    }
    cout << endl;

    funnySort(arr);

    cout << "Shuffled array: ";
    for (int num : arr)
    {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}