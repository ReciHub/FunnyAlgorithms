fun main(args: Array<String>) {
	println(factorial(3))
}

fun factorial(num: Int): Long {
    var result = 1L
    for (i in 2..num) result *= i
    return result
}
