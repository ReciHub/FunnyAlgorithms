fun toSortedArray(str: String): List<Char> {
    val chars = str.lowercase().toCharArray()
    return chars.sortedArray().filter{ it != ' ' }
}

fun isAnagram(s1: String, s2: String): Boolean {
    return toSortedArray(s1).equals(toSortedArray(s2))
}

fun main() {
    print("Enter a word: ")
    val s1 = readln()
    print("Enter another word: ")
    val s2 = readln()

    if (isAnagram(s1, s2)) {
        println("$s1 and $s2 are anagrams.")
    } else {
        println("$s1 and $s2 are not anagrams.")
    }
}
