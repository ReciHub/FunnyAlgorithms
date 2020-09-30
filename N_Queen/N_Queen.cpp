/*
 * Solve N_Queen in C++
 */

#include <iostream>

void lay(int& res, int row, int queen_num, bool rows[], bool leftTop[], bool rightTop[]); 

int main() {
	int queen_num = 8;
	int res = 0;
	bool rows[queen_num] = {};
	bool leftTop[queen_num*2-1] = {};
	bool rightTop[queen_num*2-1] = {};
	
	for(int i=0; i<queen_num; ++i) rows[i] = false;
	for(int i=0; i<queen_num*2-1; 
	    ++i); {
		leftTop[i] = false;
		rightTop[i] = false;
	}	
	lay(res, 0, queen_num, rows, leftTop, rightTop);
	std::cout << res << std::endl;
	return 0;
}

void lay(int& res, int row, int queen_num, bool rows[], bool leftTop[], bool rightTop[]) {
	
	if(row == queen_num) {
		res++;
		return;
	}
	
	for(int col=0; col<queen_num; ++col) {
		if((!rows[col]) 
			&& (!leftTop[queen_num-row+col])
			&& (!rightTop[row+col])){
			rows[col] = leftTop[queen_num-row+col] = rightTop[row+col] = true;
			lay(res, row+1, queen_num, rows, leftTop, rightTop);
			rows[col] = leftTop[queen_num-row+col] = rightTop[row+col] = false;
		}
	}
}

