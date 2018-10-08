
#include<iostream>
#include<cstring>
#include <sstream> 
#include <bits/stdc++.h>  
using namespace std;

    /**
     * @author james-flynn-ie
     *
     * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
     * Find the largest palindrome made from the product of two 3-digit numbers.
     */

   
int main()
   {
        int largestPalindrome = 0;
        int largestI = 0;
        int largestJ = 0;

        for (int i = 100; i <= 999; i++) {
            for (int j = 100; j <= 999; j++) {
                int result = i * j;
                cout<<result<<endl;

                //Convert result to String before reversing.
                String strResult = result.str();
                String reverseResult = reverse(strResult.begin(), strResult.end());
				
                    if(strcmp(strResult,reverseResult)) {
                    
					cout<<"Palindrome found"<<" "<<result;

                    if (result > largestPalindrome) {
                        largestI = i;
                        largestJ = j;
                        largestPalindrome = result;
                    }
                }
            }
        }
		
		
		cout<<"The largest palindrome from 2 three-digit numbers is"<<largestPalindrome<<endl;
		return 0;

        
    }

