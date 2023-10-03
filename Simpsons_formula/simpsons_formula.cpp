#include <bits/stdc++.h>
using namespace std;

// Function to calculate the square of a given number
double f(double x){
  return x*x;
}

// O(N)
const int N = 1000 * 1000; // Number of steps for Simpson's rule (already multiplied by 2)

// Function to perform Simpson's rule for numerical integration
// Calculates the definite integral of f(x) from 'a' to 'b'
double simpson_integration(double a, double b){
  double h=(b-a)/N; // Width of each subinterval
  double s=f(a)+f(b); // Initial and final points contribute to the sum with coefficient 1
  for (int i=1;i<=N-1;i++){ 
    double x=a+h*i;
    s+=f(x)*((i & 1)?4:2); // Alternating coefficients (4 or 2) for each subinterval
  }
  s*=h/3; // Multiply by the width and divide by 3 as per Simpson's rule
  return s;
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  double a = 9.0; // Lower limit of the interval
  double b = 27.0; // Upper limit of the interval
  cout<<"The definite integral of f(x) = x^2 over the interval ["<<a<<", "<<b<<"] is: "<<simpson_integration(a, b)<<"\n";
  return 0;
}
