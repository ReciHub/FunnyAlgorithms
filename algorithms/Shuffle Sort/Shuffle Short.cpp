// CPP program Illustrating 
// the use of shuffle 
#include <bits/stdc++.h> 
using namespace std; 
  
// Driver Program 
int main() 
{ 
    array<int, 5> s{ 1, 2, 3, 4, 5 }; 
  
    // To obtain a time-based seed 
    unsigned seed = 0; 
  
    // Use of shuffle 
    shuffle(s.begin(), s.end(), default_random_engine(seed)); 
  
    cout << "shuffled elements are:"; 
    for (int& i : s) 
        cout << ' ' << i; 
    cout << endl; 
  
    return 0; 
} 
