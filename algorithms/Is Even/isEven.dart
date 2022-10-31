import 'dart:io';
void main() {
	print("Let's check whether a number is even or not! Please enter any number:");
	var number = int.parse(stdin.readLineSync());
	if (number % 2 == 0){
		print("The number is EVEN!");
	}
	else{
		print("The number is ODD!");
	}
}