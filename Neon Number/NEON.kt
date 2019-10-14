/**
 * @created October 2, 2019
 * A neon number is a number where the sum of digits of square of the number is equal to the number.
 * For example if the input number is 9, its square is 9*9 = 81 and sum of the digits is 9. i.e. 9 is a neon number.
 */

class NEON {

    fun solve() {
        println("Input a number to check if it is a NEON number: ")
        val number = readLine()!!.toInt()
        if (neonNumber(number) == number) {
            println("$number is a NEON number.")
        } else {
            println("$number is not a NEON number.")
        }
    }

    private fun neonNumber(number: Int): Int {
        return sumDigits(number * number)
    }

    private fun sumDigits(number: Int): Int {
        var sum = 0
        var temporal = number
        while (temporal != 0) {
            sum += temporal % 10
            temporal /= 10
        }
        return sum
    }

}

fun main() {
    NEON().solve()
}