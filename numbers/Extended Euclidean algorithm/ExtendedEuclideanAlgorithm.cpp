/*
 * Euclidean algorithm in C++
 * Solve for GCD
 */

#include <iostream>

int SolveIter(int a, int b);
int SolveRec(int a, int b);

int main() {
	int a=98, b=56;
	std::cout << SolveRec(a, b) << std::endl;
	std::cout << SolveIter(a, b) << std::endl;
	return 0;
}

int SolveIter(int a, int b) {
	if(b) 
		while((a%=b) && (b%=a));
	return a+b;
}

int SolveRec(int a, int b) {
	if(b==0)
		return a;
	return SolveRec(b, a%b);
}
