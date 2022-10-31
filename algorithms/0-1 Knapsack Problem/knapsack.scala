object Knapsack extends App {

  val inputValues = List(60, 100, 120)
  val inputWeights = List(10, 20, 30)
  val inputCapacityWeight = 50
  println(s"Knapsack value is ${knapsack(inputCapacityWeight, inputWeights , inputValues, inputValues.length)}")

  def knapsack(capacityWeight: Int, weights: List[Int], values: List[Int], n: Int): Int = {
    if (n == 0 || capacityWeight == 0) return 0

    val currentWeight = weights(n - 1)

    if (currentWeight > capacityWeight) {
      knapsack(capacityWeight, weights, values, n - 1)
    } else {
      max(values(n - 1) + knapsack(capacityWeight - currentWeight, weights, values, n - 1), knapsack(capacityWeight, weights, values, n - 1))
    }
  }

  private def max(a: Int, b: Int): Int = if (a > b) a else b

}
