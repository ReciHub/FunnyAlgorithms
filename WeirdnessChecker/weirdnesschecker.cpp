#include<iostream>
using namespace std;

	int main() {
		bool game_in_progress = true;
    
		while (game_in_progress) {
			cout<<"Do you eat kitkats in one big bite or in pieces?";
			cout<<"(Type in '1' for one big bite or '2' for pieces)";
			int kitkat_choice;
			cin>>kitkat_choice;
		
			if (kitkat_choice == 1) {
				cout<<"You are weird.";
				game_in_progress = false;
			} 
			else if (kitkat_choice == 2) {
				  cout<<"You are normal... so far.";
				  cout<<"Do you pour the milk first or the cereal?";
				  cout<<"(Type in '1' for milk or '2' for cereal)";
				  int breakfast_choice;
				  cin>>breakfast_choice;
				
			if (breakfast_choice == 1) {
				  	cout<<"You are weird";
					  game_in_progress = false;
			} 
			else if (breakfast_choice == 2) {
				cout<<"OK... you are still normal...";
				cout<<"Do you chomp out a whole bite of a string cheese stick or do you peel individual strings off and eat them?";
				cout<<"(Type in '1' for the first option or '2' for the second one)";

				int cheese_choice;
				cin>>cheese_choice;
					
				if (cheese_choice == 1) {
  					cout<<"Nope. You're weird.";
	  				game_in_progress = false;
		  		} 
		  		else if (cheese_choice == 2) {
			  		cout<<"You made it! Congratulations, you're not weird.";
				  	game_in_progress = false;
				} 
				else {
				    cout<<"Invalid Input. Restart"<<endl;
				}
			} 
			else {
				cout<<"Invalid Input. Restart"<<endl;
			}
				
		} 
		cout<<"Invalid Input. Restart";
		return 0;
	}}
