#include<bits/stdc++.h>

using namespace std;

int main()
{
  int ndoors = 3;
  int tIter = 100000;
  int nCar = 0, nGoat = 0; 
  int r1, r2, goat_index = 0;
  
  string player_choice;
  string final_choice;
  
  for (int iter = 0; iter < tIter; iter++)
  {
    string game[3] = {"goat", "goat", "goat"};

    srand(iter + time(NULL));

    // assigning car to a random gate
    r1 = ((int) rand()) % ndoors;
    game[r1] = "car";

    // random choice of player
    r2 = ((int) rand()) % ndoors;
    player_choice = game[r2];

    // If player chooses to stick to same choice
    final_choice = game[r2];

    if (final_choice == "car")
    {
      nCar += 1;
    }
    else
    {
      nGoat += 1;
    }
  }
  
  cout << "Winning percentage of a car if player does not switch " << endl;
  cout << nCar * 100.0 / tIter << endl;
  cout << "So switching is always a wise choice!!" << endl;
}
