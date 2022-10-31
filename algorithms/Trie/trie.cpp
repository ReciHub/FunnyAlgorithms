#include <iostream>

class Trie {
public:
	Trie() {
		finish = false;
		for (int i = 0; i < 26; i++) {
			trieArr[i] = NULL;
		}
	}

	void push(Trie* parent, std::string str) {
		int index = str.at(0) - 'a';

		if (parent->trieArr[index] == NULL) {
			parent->trieArr[index] = new Trie();
		}
		if (str.length() == 1) {
			parent->trieArr[index]->finish = true;
			return;
		}

		push(parent->trieArr[index], str.substr(1, str.length()));
	}

	bool find(Trie* parent, std::string str) {
		int index = str.at(0) - 'a';

		if (parent->trieArr[index] == NULL) {
			return false;
		}
		else if (str.length() == 1 && parent->trieArr[index]->finish == true) {
			return true;
		}
		else if (str.length() == 1 && parent->trieArr[index]->finish == false) {
			return false;
		}
		return find(parent->trieArr[index], str.substr(1, str.length()));
	}

private:
	bool finish;
	Trie* trieArr[26]; //the number of Alphbet is 26 and dataArr is children of this Node
};

void hasWord(Trie* trie, std::string str) {
	if (trie->find(trie, str)) {
		std::cout << "Trie has \"" << str << "\"" << std::endl;
	}
	else {
		std::cout << "Trie doesn't have \"" << str << "\"" << std::endl;
	}
}

void test() {
	Trie* trie = new Trie();
	trie->push(trie, "to");
	trie->push(trie, "bee");
	trie->push(trie, "bear");
	trie->push(trie, "like");

	hasWord(trie, "to");
	hasWord(trie, "too");
	hasWord(trie, "bee");
	hasWord(trie, "be");
	hasWord(trie, "bear");
	hasWord(trie, "bea");
	hasWord(trie, "like");
	hasWord(trie, "liked");
}

int main() {

	test();

	return 0;
}