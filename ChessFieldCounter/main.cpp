#include <iostream>

using namespace std;

int main() {
	int n;
	int black = 0, white = 0;
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (black > white)
			{
				white++;
			}
			else
			{
				black++;
			}
		}
	}
	cout << white << endl << black;

	return 0;
}