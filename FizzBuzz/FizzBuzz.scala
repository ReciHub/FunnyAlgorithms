object FizzBuzz extends App {
  if (args.length != 1) {
    println("Error !!! Provide input number ")
    System.exit(0)
  }
  for (num <- 1 to args(0).toInt) {
    if (num % 15 == 0)
      println("FizzBuzz")
    else if (num % 3 == 0)
      println("Fizz")
    else if (num % 5 == 0)
      println("Buzz")
    else
      println(num)
  }
}
