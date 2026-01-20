import Foundation

// Returns the first character of a string
func first(_ word: String) -> Character? {
    return word.first
}

// Returns the last character of a string
func last(_ word: String) -> Character? {
    return word.last
}

// Returns all but the first and last characters of a string
func middle(_ word: String) -> String {
    guard word.count > 2 else {
        return ""
    }
    return String(word.dropFirst().dropLast())
}

// Prints whether a word is a palindrome or not
func isPalindrome(_ word: String) {
    if word.count <= 1 {
        print("'\(word)' is a palindrome.")
        return
    }
    if first(word) != last(word) {
        print("'\(word)' is not a palindrome.")
        return
    }
    isPalindrome(middle(word))
}

// Main function to handle user input
func main() {
    print("Enter a word to check if it is a palindrome:")
    if let word = readLine()?.trimmingCharacters(in: .whitespacesAndNewlines) {
        isPalindrome(word)
    } else {
        print("Invalid input.")
    }
}

// Call the main function to start the program
main()
