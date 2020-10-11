#include <iostream>
using namespace std;

int main()
{
	float r,h,v;

	cout << "Enter the radius of the cylinder:" << endl;
	cin >> r;

	cout << "Enter the height of the cylinder:" << endl;
	cin >> h;

	v = (22 * r * r * h) / 7;

	cout << "The volume of cylinder is:" << v << endl;

	return 0;
}