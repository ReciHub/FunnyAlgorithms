/*
Program created by Erick Simões (@ErickSimoes)
This function returns smoothed values, reduces noise read
from a analogical sensor, for example.

The Smooth() function is given an integer value. It will
return the same value if the value is not less than itself
plus the range nor itself less than the range. If the read
value is out of range, it returns this new value.
*/

#define APIN 3  // Analog input (such as a potentiometer
                // or LDR)connected to pin 3

uint8_t rangeSize;
int val;

void setup() {
  Serial.begin(9600);
  rangeSize = 5; // This is a sample value
}

void loop() {
  val = analogRead(APIN);

  Serial.print(val);          // Raw values
  Serial.print(" | ");
  Serial.print(Smooth(val));  // Smoothed values
}

int Smooth(int val) {
  static int previousVal;

  if(val > (previousVal + rangeSize) || val < (previousVal - rangeSize)) {
    previousVal = val;
  }

  return previousVal;
}
