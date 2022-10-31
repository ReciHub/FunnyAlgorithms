import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Implemented by tail recursion, i.e. after compilation it will become iterative.
  * Complexity of this implementation is O(N) for time and O(1) for memory.
  */
object Factorial extends App {
  println("Enter a number to factorialize: ")
  val n = StdIn.readInt()
  require(n >= 0, "Factorial is defined only for non-negative values")
  println(s"The factorial of $n is ${factorial(n)}")

  @tailrec
  def factorial(n: Int, accumulator: BigInt = 1): BigInt = {
    n match {
      case 0 => accumulator
      case _ => factorial(n - 1, accumulator * n)
    }
  }
}