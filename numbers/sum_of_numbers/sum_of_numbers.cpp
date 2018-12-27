#include <iostream>

using namespace std;

int sum_of_numbers_iterative(int n){
    int the_sum = 0;

    for(int i=0; i<=n; i++)
        the_sum += i;

    return the_sum;
}

int main(){

	int n;

	cout<<"Enter a number: ";
	cin>>n;

	cout<<sum_of_numbers_iterative(n);  //5+4+3+2+1 = 15

	return 0;
}
