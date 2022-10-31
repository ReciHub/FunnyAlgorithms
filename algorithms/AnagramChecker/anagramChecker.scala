object AnagramChecker extends App {

  val firstWord: String = "helloworld"
  val secondWord: String = "heworldllo"
  println(s"$firstWord and $secondWord ${sayResult(areAnagrams(firstWord, secondWord))}")

  def areAnagrams(s1: String, s2: String): Boolean = {
    if (s1.length != s2.length) false
    else if (s1 == s2) true
    else toSortedArray(s1) == toSortedArray(s2)
  }

  private def toSortedArray(s: String): String = s.toLowerCase.sorted

  private def sayResult(answer: Boolean): String = {
    if (answer) "are anagrams" else "are not anagrams"
  }

}
