#include <bits/stdc++.h>
using namespace std;

void towerOfHanoi(int num, char from, char to, char aux){
	if(num == 1){
		
    cout<<"Move disk 1 from "<<from<<" to "<<to<<"\n";
		return;
	}
	
	towerOfHanoi(num-1, from, aux, to);
	cout<<"Move disk "<<num<<" from "<<from<<" to "<<to<<"\n";
	towerOfHanoi(num-1, aux, to, from);
	
	return;
}

int main(){
	int num; 
  cin>>num;
	towerOfHanoi(num, 'A', 'B', 'C');

	return 0;
}
