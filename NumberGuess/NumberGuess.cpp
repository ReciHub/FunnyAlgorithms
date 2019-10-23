#include <iostream>
#include <time.h>
using namespace std;

bool guessNum(int target, int guess){
     return (target == guess) ? true : false;                                
}                                                                            
                                                                              
int main(){                                                                  
    srand(time(NULL));
    int target = rand() % 101, guess;

    cout << "Guess the correct number from 1 - 100, you have 5 tries." << endl;       
                                                                                       
    for(unsigned int i = 0; i < 5; i++){                                              
         cin >> guess;                                                                
         if(guessNum(target, guess)){                                                 
              cout << "FOUND IT!" << endl;                                            
              break;                                                                  
         }                                                                            
         else cout << "Wrong, you have " << (4 - i) << " tries left." << endl;        
     }                                                                                 
     return 0;                                                                         
}      
