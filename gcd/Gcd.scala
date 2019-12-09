import  scala.annotation.tailrec

object Gcd {
  def main(args: Array[String]): Unit = {
    if (args.length != 2) {
      println("Provide 2 numbers as input to the program")
      println("Usage: scala Gcd.scala <num1> <num2>")
      System.exit(1)
    }
    else {
      println("GCD is "+ gcd(args(0).toInt,args(1).toInt))
    }
  }

  @tailrec
  def gcd(num1: Int, num2: Int) : Int = {
    if(num2 == 0) num1 else gcd(num2 , num1 % num2)
  }
}