#include <iostream>
#include <algorithm>
#include <random>
#include <vector>
#include <chrono>

// obtain a time-based seed:
unsigned seed = std::chrono::system_clock::now().time_since_epoch().count();


void shuffleArray(int *array, int size)
{
    std::shuffle(array, array + size, std::default_random_engine(seed));
}

bool isArraySorted(int *array, int size)
{
    for (int i = 0; i < (size - 1); i++)
    {
        if(array[i] > array[i + 1])
        {
            return false;
        }
    }
    return true;
}

int main()
{
    // You can try multiple array size to see how long and how many iterations
    const int arraySize = 10;
    int unsortedArray[arraySize];

    // Initialize the unsortedVector with 1 to 10
    for (int i = 0; i < arraySize; i++)
    {
        unsortedArray[i] = i + 1;
    }
    shuffleArray(unsortedArray, arraySize);

    // Print initial Shuffled Array
    std::cout << "Initial Array:\n";
    for (int i = 0; i < 10; i++)
    {
        std::cout << unsortedArray[i] << ' ';
    }
    std::cout << '\n';

    // Shuffle the array until it is sorted
    int iterationsCount = 0;
    while (!isArraySorted(unsortedArray, arraySize))
    {
        shuffleArray(unsortedArray, arraySize);
        iterationsCount++;
    }
    int *sortedArray = unsortedArray;

    // Print sorted Array
    std::cout << "Sorted Array:\n";
    for (int i = 0; i < 10; i++)
    {
        std::cout << unsortedArray[i] << ' ';
    }
    std::cout << '\n';
    std::cout << "Number of iterations: " << iterationsCount << '\n';
}