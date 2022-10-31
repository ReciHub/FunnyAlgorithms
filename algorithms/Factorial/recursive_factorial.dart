import 'dart:io';

void main() {
  var n;
  n = int.parse(stdin.readLineSync());
  print("factorial of $n is ");
  print(factorial(n));
}

factorial(n) {
  if (n <= 0)
    return 1;
  else
    return (n * factorial(n - 1));
}
