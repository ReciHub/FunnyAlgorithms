//Fastest runninig algorithm for Plindrome checker and optimized too

class Solution {
public boolean isPalindrome(int x) {
    if (x < 0) return false; // Number is less than 0 no point of palindrome
    if (x < 10) return true; // Number is less than 10 no point of reversing number its Rational
	
    int result = 0,temp = x;
    while (x > 0) {
        result = result * 10 + (x % 10);
        x /= 10;
    }
	
    return result ==temp;
    }
}
