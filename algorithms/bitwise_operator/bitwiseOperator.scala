object BitwiseOperator extends App {

  val x = 16
  val y = 12

  println(s"Given values x = $x and y = $y")
  println(s"Bitwise AND of x & y = ${AND(x, y)}")
  println(s"Bitwise OR of x | y = ${OR(x, y)}")
  println(s"Bitwise Ones Complement of ~x = ${onesComplement(x)}")
  println(s"Bitwise XOR of x ^ y = ${XOR(x, y)}")
  println(s"Bitwise Left Shift of x << 2 = ${leftShift(x, 2)}")
  println(s"Bitwise Right Shift of x >> 2 = ${rightShift(x, 2)}")
  println(s"Bitwise Shift Right x >>> 2 = ${rightShiftZeroFill(x, 2)}")

  // Copies the bit to the result if the operator exists in both the operands.
  def AND(a: Int, b: Int): Int = a & b

  // Copies the bit to the result if the operator exists in either of the operands.
  def OR(a: Int, b: Int): Int = a | b

  // Every bit value is flipped. 1 becomes 0 and vice versa.
  def onesComplement(value: Int): Int = ~value

  // Copies if the bit is set in one of the operand but not both.
  def XOR(a: Int, b: Int): Int = a ^ b

  // The left operand value is moved left by the number of bits specified in the right operand.
  def leftShift(value: Int, n: Int = 1): Int = value << n

  // The left operand value is moved right by the number of bits specified by the right operand.
  def rightShift(value: Int, n: Int = 1): Int = value >> n

  // The left operands value is moved right by the number of bits specified by the right operand and shifted values are filled with zeros.
  def rightShiftZeroFill(value: Int, n: Int = 1): Int = value >>> n

}
