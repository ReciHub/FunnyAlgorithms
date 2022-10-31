# include<bits/stdc++.h>
# include<math.h>

using namespace std;

void simpleInterest(double principal, double ratePerYear,double timeInYear)
{
  double interest = principal * ratePerYear * timeInYear / 100;
  cout << "Total simple interest is :" << interest << endl;
  cout << "Total amount is :" << interest + principal << endl;
}


void compoundInterest(double principal, double ratePerYear,double timeInYear, double compounding)
{
  double final = principal * pow((1 + ratePerYear / (compounding * 100)), compounding * timeInYear);
  cout << "Total compound interest is :" << final - principal << endl;
  cout << "Total amount is :" << final << endl;
}

int main()
{
  // Simple Interest calculation
  simpleInterest(1000,7,3);

  // Compounding Interest calculation
  // compounding = 1  ==> Yearly compounding
  // compounding = 4  ==> Quarterly compounding
  // compounding = 6  ==> Half yearly compounding
  // compounding = 12 ==> Monthly compounding
  double compounding = 1;  // Yearly compounding

  compoundInterest(1000,7,3,compounding);

}
