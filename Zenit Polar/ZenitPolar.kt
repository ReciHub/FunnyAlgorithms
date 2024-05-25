fun transformToZenitPolar(text: String): String {
    val zenitPolarMap = mapOf(
        'z' to 'p', 'p' to 'z',
        'e' to 'o', 'o' to 'e',
        'n' to 'l', 'l' to 'n',
        'i' to 'a', 'a' to 'i',
        't' to 'r', 'r' to 't',
        'P' to 'Z', 'Z' to 'P',
        'O' to 'E', 'E' to 'O',
        'L' to 'N', 'N' to 'L',
        'A' to 'I', 'I' to 'A',
        'R' to 'T', 'T' to 'R'
    )

    return text.map { zenitPolarMap[it] ?: it }.joinToString("")
}

fun main() {
    println("Enter text:")
    val text = readLine() ?: ""
    val zenitPolarText = transformToZenitPolar(text)

    println("Original text: $text")
    println("Encrypted text: $zenitPolarText")
}
