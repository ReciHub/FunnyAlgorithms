// A rod is given of length n. Another table is also provided, which contains different size and price for each size. Determine the maximum price by cutting the rod and selling them in the market.

// To get the best price by making a cut at different positions and comparing the prices after cutting the rod.
  
#include <iostream>
using namespace std;

int max(int a, int b) {
   return (a > b)? a : b;
}

int rodCutting(int price[], int n) {    //from price and length of n, find max profit
   int profit[n+1];
   profit[0] = 0;
   int maxProfit;

   for (int i = 1; i<=n; i++) {
      maxProfit = INT_MIN;    //initially set as -ve infinity
      for (int j = 0; j < i; j++)
         maxProfit = max(maxProfit, price[j] + profit[i-j-1]);
      profit[i] = maxProfit;
   }
   return maxProfit;
}

int main() {
   int priceList[] = {1, 5, 8, 9, 10, 17, 17, 20};
   int rodLength = 8;
   cout << "Maximum Price: "<< rodCutting(priceList, rodLength);
}

// Maximum Price: 22
