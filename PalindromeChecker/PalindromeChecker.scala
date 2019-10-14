object PalindromeChecker extends App {
    
  val palindromeWord: String = "madam"
  println(s"$palindromeWord ${ (sayResult _ compose isPalindrome)(palindromeWord) }")
  
  val notPalindromeWord: String = "plane"
  println(s"notPalindromeWord ${ (sayResult _ compose isPalindrome)(notPalindromeWord) }")

  def isPalindrome(word: String): Boolean = {
    (for (x <- 0 to word.length/2) yield (word(x) == word(word.length - x - 1)))
      .reduceLeft((acc,n)=> acc && n)
  }
  
  def sayResult(answer: Boolean): String = {
    if (answer) "is a palindrome" else "is not a palindrome"
  }
  
}
