#include <iostream>
#include <vector>
#include <ctime>
#include <cstdlib>

using namespace std;

// Time complexity: O(n)
vector<int> randomUniverse() {
  vector<int> universe;
  srand(time(NULL));
  for(int i = 0; i < 100; i++) {
    universe.push_back(rand() % 1000);
  }
  return universe;
}

// Time complexity: O(n)
void printUniverse(string universeName, vector<int> universe) {
  int universeSize = universe.size();
  cout << universeName << ": [" << universe[0];
  for(int i = 1; i < universeSize; i++) {
    cout << ", " << universe[i];
  }
  cout << "]" << endl;
}

// Time complexity: O(n)
bool isSorted(vector<int> array) {
  int size = array.size();
  for(int i = 1; i < size; i++) {
    if(array[i - 1] > array[i]) {
      return false;
    }
  }
  return true;
}

// Time complexity: O(n)
void killRandomElement(vector<int>& universe) {
  int index = rand() % universe.size();
  universe.erase(universe.begin() + index);
}

// Time complexity: O(n ^ 2)
void killHalfUniverse(vector<int>& universe) {
  int halfUniverseSize = universe.size() / 2;
  for(int i = 0; i < halfUniverseSize; i++) {
    killRandomElement(universe);
  }
}

// Time complexity: O(n ^ 2 * log n)
void thanosSort(vector<int>& universe) {
  while(!isSorted(universe)) {
    killHalfUniverse(universe);
  }
}

// Time complexity: O(n ^ 2 * log n)
int main() {
  vector<int> universe = randomUniverse();
  printUniverse("Universe", universe);
  thanosSort(universe);
  printUniverse("Ordered universe: ", universe);
  return 0;
}
