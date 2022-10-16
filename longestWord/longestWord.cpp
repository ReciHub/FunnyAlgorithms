#include <iostream>
#include <string.h>
using namespace std;

int main() {
    
	string input;
	cout<<"Enter a string: "<<endl;
	getline(cin,input);
	
	int len = 0;
	int cur_len = 0;
	string longest_word="";
	string cur_word="";
	
	for (int i = 0; i < input.size(); i++) {
	    
	    cur_len++;
	    cur_word += input[i];
	    
	    if (input[i]==' ') {
	        if (len <cur_len) {
	            len = cur_len;
	            longest_word = cur_word;
	        }
	        cur_len = 0;
	        cur_word = "";
	    }
	}
	cout<<longest_word<<endl;
	return 0;
}
