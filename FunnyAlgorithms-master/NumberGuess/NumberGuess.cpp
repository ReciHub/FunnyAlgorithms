#include <iostream>
using namespace std;

void guess_num(){
    int num = rand() % 100;
    int chance = 1;
    while(chance<=5){
        int n;
        cout << "Guess the number: " << endl;
        cin >> n;
        if(num==n) cout << "You Win" << endl;
        else{
            chance+=1;
            cout << "Try Again" << endl;
        }
    }
    cout <<"You Lose! The number was " << num << endl;
    return;
}

int main(){
    char game_play = 'y';
    while (game_play=='y' || game_play=='Y'){
        guess_num();
        cout << "Do You Wanna Play Again?" << endl;
        cin >> game_play;
    }
}
