/*
 * The spaghetti sort is a sorting algorithm that 
 * basically what it does is to take a bunch of spaghetti rods (the elements)
 * and whilst they're all standing upright, we lower our hand until it meets with a rod
 * - this one being the longest one - that rod is removed from the original list
 * and inserted into the front of the sorted list.  
*/

#include <iostream>
#include <vector>

int askForSize();
void readInput(std::vector<int> *, const int &);
void showVector(std::vector<int> *);
std::vector<int> *spaghettiSort(std::vector<int> *);

int main(int argc, char *argv[]) {
    std::vector<int> *unsortedElements = new std::vector<int>();
    std::vector<int> *sortedElements;

    // Asking users how many inputs they're gonna enter.
    int size = askForSize();
    readInput(unsortedElements, size);

    // Showing unsorted elements.
    std::cout << "Unsorted elements: " << std::endl;
    showVector(unsortedElements);
    std::cout << "-------------------" << std::endl;

    // Executing Spaghetti algorithm.
    sortedElements = spaghettiSort(unsortedElements);

    // Showing sorted elements.
    std::cout << "Sorted elements: " << std::endl;
    showVector(sortedElements);
    std::cout << "-------------------" << std::endl;

    delete unsortedElements;
    delete sortedElements;
    
    return 0;
}

std::vector<int> *spaghettiSort(std::vector<int> *unsortedVector) {
    std::vector<int> *sortedElements = new std::vector<int>();

    // Finding tallest spaghetto.
    auto tallestSpaghetto = [&]() -> int {
        std::vector<int>::iterator it = unsortedVector->begin();
        int currentTallest = *it;

        for(it = it + 1; it != unsortedVector->end(); ++it) {
            if(*it > currentTallest) currentTallest = *it;
        }

        return currentTallest;
    }(); 

    while(!unsortedVector->empty()) {
        for(int i = unsortedVector->size() - 1; i >= 0; --i) {
            // If a elements inside the unsorted elements is equal to the current
            // tallest spaghetto, then we push it to the front of the sorted vector
            // whilst at the same time we pop it off from the unsorted elements.
            if(unsortedVector->at(i) == (int)tallestSpaghetto) {
                sortedElements->insert(sortedElements->begin(), unsortedVector->at(i));
                unsortedVector->erase(unsortedVector->begin() + i);
            }
        } 

        // Decrease by one the tallestSpaghetto for next iteration.
        tallestSpaghetto -= 1;
    }

    return sortedElements;
}

int askForSize() {
    int size = 0;

    while(size <= 0) {
        std::cout << "How many numbers do you plan to input?: ";
        std::cin >> size;

        if(size <= 0) {
            std::cerr << "ERROR: Size can't be less or equal than zero." << std::endl;
        }
    }

    return size;
}

void readInput(std::vector<int> *unsortedNumbers, const int &size) {
    int input;

    for(int i = 0; i < size; ++i) {
        std::cout << "Input value '" << i + 1 << "': ";
        std::cin >> input;

        unsortedNumbers->push_back(input);
    }
}

void showVector(std::vector<int> *numbers) {
    std::vector<int>::iterator it;

    std::cout << "[ ";
    for(it = numbers->begin(); it != numbers->end(); ++it) {
        std::cout << *it << " ";
    }
    std::cout << "]" << std::endl;
}
