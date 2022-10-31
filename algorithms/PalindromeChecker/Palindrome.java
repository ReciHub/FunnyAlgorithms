import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        if(isPalindrome(word)) {
            System.out.println(String.format("the word '%s' is a palindrome!", word));
        } else {
            System.out.println(String.format("the word '%s' isn't a palindrome!", word));
        }
    }
 
    public static boolean isPalindrome(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if(word.charAt(i) != word.charAt(word.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}