#include <bits/stdc++.h>
using namespace std;

int main(void){

	string pin;
	int flag = 0, i = 1;	
	while(!flag){
		cout<< i <<endl;
		cout<< (i+1)<< endl;
		cout<< (i+2)<< endl;
		cin>> pin;
		i+=3;
		if(pin != "pin")
			flag = 1;
	}
	cout<< "você perdeu";
}
