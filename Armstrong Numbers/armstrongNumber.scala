object ArmstrongNumber extends App {

  val armstrongNumber: Int = 153
  println(s"$armstrongNumber ${(sayResult _ compose isArmstrongNumber)(armstrongNumber)}")

  val notArmstrongNumber: Int = 9475
  println(s"$notArmstrongNumber ${(sayResult _ compose isArmstrongNumber)(notArmstrongNumber)}")

  def isArmstrongNumber(value: Int): Boolean = {
    val numberAsString = value.toString
    val result = numberAsString
      .map(_.asDigit)
      .map(Math.pow(_, numberAsString.length))
      .sum

    result == value
  }

  private def sayResult(answer: Boolean): String = {
    if (answer) "is an Armstrong number" else "is not an Armstrong number"
  }

}
