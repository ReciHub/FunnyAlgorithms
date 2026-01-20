#include <iostream>
#include <vector>
using namespace std;

int partition(vector<int> &array, int low, int high)
{
    int pivot = array[high];
    int i = low - 1;
    for (int j = low; j < high; j++)
    {
        if (array[j] <= pivot)
        {
            i++;
            swap(array[i], array[j]);
        }
    }
    swap(array[i + 1], array[high]);
    return i + 1;
}

void quickSort(vector<int> &array, int low, int high)
{
    if (low < high)
    {
        int pi = partition(array, low, high);
        quickSort(array, low, pi - 1);
        quickSort(array, pi + 1, high);
    }
}

int main()
{
    vector<int> data;
    int num;
    cout << "Enter integers separated by spaces, and type a non-integer to end the input: " << endl;
    while (cin >> num)
    {
        data.push_back(num);
    }

    cout << "Unsorted Array:" << endl;
    for (int i = 0; i < data.size(); i++)
    {
        cout << data[i] << " ";
    }
    cout << endl;

    int size = data.size();

    quickSort(data, 0, size - 1);

    cout << "Sorted Array in Ascending Order:" << endl;
    for (int i = 0; i < data.size(); i++)
    {
        cout << data[i] << " ";
    }
    cout << endl;

    return 0;
}
