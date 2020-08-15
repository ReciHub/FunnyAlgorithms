#include<iostream>

using namespace std;

void collatz(int Num){

	int iterations = 0;
	while ( Num > 1 ){
		Num = (Num%2 == 0) ? Num/2 : 3*Num+1;
		iterations ++;
	}
	cout<<"reached 1 after " <<iterations <<" iterations\n";

}

int main(){

	int n;
	
	cout<<"Enter a +ve number = ";
	cin>>n;
	
	collatz(n);
	
	return 0;
}
