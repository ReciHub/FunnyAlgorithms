#include <iostream>
#include <vector>

void stalinSort(std::vector<int> &arr, std::vector<int> &sorted)
{
    sorted.push_back(arr[0]);
    for (int i = 1; i < arr.size(); i++)
    {
        if (arr[i] > sorted[sorted.size() - 1])
        {
            sorted.push_back(arr[i]);
        }
    }
}

int main()
{
    std::vector<int> arr = {1,4,6,8,3,5,7,9,20,18,29};
    std::vector<int> sortedArr;

    stalinSort(arr, sortedArr);

    std::cout << "Before Stalin Sort\n";
    for (int a : arr)
    {
        std::cout << a << " ";
    }
    std::cout << "\nAfter Stalin Sort: Unsorted numbers are sent to gulag!\n";
    for (int a : sortedArr)
    {
        std::cout << a << " ";
    }
    std::cout << "\n";

    return 0;
}