/**
 * Program created by Erick Simões (@ErickSimoes)
 * 
 * The factorial function is the simple way to
 * calculate the value of a factorial number.
 * 
 * The strategy used is with a recursive function
 * (which calls itself).
 */

void setup() {
  Serial.begin(9600);

  Serial.println("Factorial of 8 is ");
  Serial.print(factorial(8));
}

void loop() {}

int factorial(int val) {
  if(val == 1) {
    return 1;
  } else {
    return val * factorial(val - 1);
  }
}
