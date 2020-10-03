/*
Beer O Clock in C++
*/

#include <iostream>
using namespace std;
void beer();
int main() {
	beer();
	return 0;
}
void beer() {
	char ip;
	cout << "> Should I check if it is time to have Beer ? (Y / N) ";
	cin >>ip;

	if (ip =='N' ||ip== 'n')
		cout << "> We check later" <<endl;
	else if (ip == 'Y' || ip == 'y')
		cout << "> It always is beer of clock. Cheers !!!" <<endl;
	else
		cout << "> Invalid input, try again." <<endl;
}
