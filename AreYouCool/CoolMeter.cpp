

#include <iostream>
#include <ctime>
#include <cstdlib>
#include <list>
#include <Iterator>
using namespace std;

int main()
{
	srand(time(0));
	int x;
	while (true) {
		cout << "\nFrom 1 - 100 how cool do you think you are: ";
		cin >> x;
		int i = 0;
		list <int> lista;
		list<int>::iterator it;

		while (i != x) {
			int value = (rand() % (x + 1));
			it = find(lista.begin(), lista.end(), value);
			if (lista.end() != it) {
				continue;
			}
			if (value == 0) {
				continue;
			}
			lista.push_back(value);
			i += 1;
	
		}
		
		int posi = (rand() % (x));
		it = lista.begin();
		next(it, posi);
		if (*it > x / 2) {
			cout << "\nYou are cool";
			break;
		}
		else if (*it < x / 2) {
			cout << "\nYou are not cool";
		}
		else {
			cout << "\nYou are the rarest kind of cool";
		}

	}
}


