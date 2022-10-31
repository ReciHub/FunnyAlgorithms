/**
  * Parse first parameter as number n and return list of all prime numbers less or equal n.
  * Time complexity is O(N * log(log N)), memory complexity is O(N)
  */
object EratosthenesSieve extends App {
  val n = Integer.valueOf(args(0))
  val primeNumbers = sieve(n)
  println(primeNumbers.mkString(" "))

  private def sieve(n: Int): Seq[Int] = {
    val isPrime = Array.fill[Boolean](n + 1)(true)

    for (i <- 2 to math.sqrt(n).toInt if isPrime(i)) {
      for (j <- i * i to n by i) {
        isPrime(j) = false
      }
    }

    (2 to n).filter(isPrime)
  }
}
