// Palindrome checker just with js funny inbuilt methods
function palind(word) {
    let reverseWord = word.split('').reverse().join('')
    return reverseWord == word
}
console.log(palind("rotator")) // true
console.log(palind("rotaor")) // false