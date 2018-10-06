public class BogoSort {
    /**
     * @author james-flynn-ie
     *
     * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
     * Find the largest palindrome made from the product of two 3-digit numbers.
     */

    public static void main(String[] args) {
        int largestPalindrome = 0;
        int largestI = 0;
        int largestJ = 0;

        for (int i = 100; i <= 999; i++) {
            for (int j = 100; j <= 999; j++) {
                int result = i * j;
                System.out.println("(" + i + ") * (" + j + ") = " + result);

                //Convert result to String before reversing.
                String strResult = Integer.toString(result);
                String reverseResult = new StringBuffer(strResult).reverse().toString();

                if ((reverseResult).equals(Integer.toString(result))) {
                    System.out.println("Palindrome found! " + result);

                    if (result > largestPalindrome) {
                        largestI = i;
                        largestJ = j;
                        largestPalindrome = result;
                    }
                }
            }
        }

        System.out.println("The largest palindrome from 2 three-digit numbers is: (" + largestI + ") * (" + largestJ + ") = " + largestPalindrome);
    }
}