//An Armstrong number of three digits is an integer such that the sum of the cubes of its digits is equal to the number itself.
// For example, 371 is an Armstrong number since 3**3 + 7**3 + 1**3 = 371.
#include <iostream>
using namespace std;
int main()
{
  int origNum, num, rem, sum = 0;
  cout << "Enter a positive  integer: ";
  cin >> origNum;

  num = origNum;

  while(num != 0)
  {
      rem = num % 10;
      sum =sum+ (rem * rem * rem);
      num =num/10; 
  }

  if(sum == origNum)
    cout << origNum <<" is an Armstrong number.\n";
  else
    cout << origNum <<" is not an Armstrong number.\n";

  return 0;
}
