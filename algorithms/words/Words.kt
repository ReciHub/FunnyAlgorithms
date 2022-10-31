fun main() {
    print("Enter text: ")
    val str = readln().trim()
    val words = str.split(' ').filter { it != "" }
    if (words.size > 1) {
        println("Your text contains ${words.size} words.")
    } else {
        println("Your text contains ${str.length} characters.")
    }
}
