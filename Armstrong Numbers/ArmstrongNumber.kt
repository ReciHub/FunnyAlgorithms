/**
 * @created October 2, 2019
 * Armstrong Number logic in Kotlin
 * @explanation Armstrong number is a number that is equal to the sum of cubes of its digits.
 */

class ArmstrongNumber {

    fun solve() {
        var sum = 0
        var remainder: Int

        println("Input a number to check if it is an Armstrong number")
        val n = readLine()!!.toInt()

        var temporal = n
        while (temporal != 0) {
            remainder = temporal % 10
            sum += (remainder * remainder * remainder)
            temporal /= 10
        }

        if (n == sum) {
            println("$n is an Armstrong number.")
        } else {
            println("$n isn't an Armstrong number.")
        }
    }

}

fun main() {
    ArmstrongNumber().solve()
}