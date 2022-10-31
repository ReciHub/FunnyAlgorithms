#include <iostream>

class Stack {
private:
	int top;
	int maxSize;
	int size;
	int* stack;

public:
	Stack(int _maxSize);
	bool isFull();
	bool isEmpty();
	void push(int input);
	void pop();
	int getTop();
	int getSize();
};

Stack::Stack(int _maxSize) {
	maxSize = _maxSize;
	size = 0;
	stack = new int[maxSize];
}

bool Stack::isFull() {
	if (size == maxSize) {
		return true;
	}
	return false;
}

bool Stack::isEmpty() {
	if (size == 0) {
		return true;
	}
	return false;
}

void Stack::push(int input) {
	if (isFull()) {
		std::cout << "Stack is full" << std::endl;
		return;
	}
	stack[size++] = input;
	top = stack[size-1];
}

void Stack::pop() {
	if (isEmpty()) {
		std::cout << "Stack is empty" << std::endl;
		return;
	}

	stack[--size] = 0;
	top = stack[size - 1];
}

int Stack::getTop() {
	if (isEmpty()) {
		std::cout << "Stack is empty" << std::endl;
		return NULL;
	}

	return top;
}

int Stack::getSize() {
	return size;
}

int main() {
	Stack s(5);

	s.push(1);
	s.push(2);
	std::cout << "SIZE : " << s.getSize() << std::endl;
	std::cout << "TOP : " << s.getTop() << std::endl;

	s.push(3);
	s.push(4);
	s.push(5);

	std::cout << "SIZE : " << s.getSize() << std::endl;
	std::cout << "TOP : " << s.getTop() << std::endl;

	s.push(6);

	s.pop();

	std::cout << "SIZE : " << s.getSize() << std::endl;
	std::cout << "TOP : " << s.getTop() << std::endl;

	return 0;
}