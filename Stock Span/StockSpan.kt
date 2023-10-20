fun stockSpan(prices: List<Int>): MutableList<Int> {
    val spans = mutableListOf<Int>()
    val prevs = mutableListOf<Pair<Int, Int>>()
    for (price in prices) {
        var days = 1
        while (!prevs.isEmpty() && (prevs.last().first <= price)) {
            days += prevs.removeLast().second
        }
        prevs.add(Pair(price, days))
        spans.add(days)
    }
    return spans
}

fun main() {
    val a = listOf(100,80,60,70, 60,75,85)
    for (x in stockSpan(a)) {
        print("$x ")
    }
}
