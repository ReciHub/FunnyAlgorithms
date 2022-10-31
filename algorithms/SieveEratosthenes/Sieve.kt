import kotlin.math.sqrt

/**
 * @created October 2, 2019
 * Sieve of Erastothenes is an algorithm to output all the prime numbers less than 10^6
 *
 * @reference https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 */

private const val MAX = 1000

private fun sieve() {
    val prime = BooleanArray(MAX + 1)
    (2..MAX).forEach {
        prime[it] = true
    }
    (2..sqrt(MAX.toDouble()).toInt()).forEach { i ->
        if (prime[i]) {
            for (j in (i * i)..MAX step i) {
                prime[j] = false
            }
        }
    }
    println("All the prime numbers between 1 and $MAX:")
    (2..MAX).forEach {
        if (prime[it]) {
            print("$it ")
        }
    }
    println()
}

fun main() {
    sieve()
}