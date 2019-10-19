#include <bits/stdc++.h>
using namespace std;
int main()
{
  int origNum, num, rem, sum = 0,store_orignum;
  cout << "Enter a positive  integer: ";
  cin >> origNum;

  store_orignum=num=origNum;
  int count=0;
  while(num!=0)  //counting the number of digits.
  {
    count++;
    num/=10;
  }
  while(origNum != 0)
  {
      rem = origNum % 10;
      sum =sum+pow(rem,count);
      origNum /= 10;
  }
  if(sum == store_orignum)
    cout << store_orignum<<" is an Armstrong number.\n";
  else
    cout << store_orignum<< " is not an Armstrong number.\n";

  return 0;
}
