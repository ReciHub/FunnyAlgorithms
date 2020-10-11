public class PalindromeChecker {

  public static void main(String wordToCheck) {
    String wordToCheckOriginal = wordToCheck;
    wordToCheck = wordToCheck.replaceAll("\\s+", "").toLowerCase();

    for (int i = 0; i < (wordToCheck.length()); i++) {
      if (wordToCheck.charAt(i) != (wordToCheck.charAt(wordToCheck.length() - i))) {
        System.out.println(wordToCheckOriginal + " is not a palindrome.");
        return;
      }
    }

    System.out.println(wordToCheckOriginal + " is a palindrome!");
  }
}
