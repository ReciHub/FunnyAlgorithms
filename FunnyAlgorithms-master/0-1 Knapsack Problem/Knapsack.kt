class Knapsack {
    // A utility function that returns maximum of two integers
    internal fun max(a: Int, b: Int): Int {
        return if (a > b) a else b
    }

    // Returns the maximum value that can be put in a knapsack of capacity W
    internal fun knapSack(W: Int, wt: IntArray, `val`: IntArray, n: Int): Int {
        // Base Case
        if (n == 0 || W == 0)
            return 0

        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        return if (wt[n - 1] > W)
            knapSack(W, wt, `val`, n - 1)
        else
            max(`val`[n - 1] + knapSack(W - wt[n - 1], wt, `val`, n - 1),
                    knapSack(W, wt, `val`, n - 1)
            )// Return the maximum of two cases:
        // (1) nth item included
        // (2) not included
    }


    // Driver program to test above function
    @JvmStatic
    fun main(args: Array<String>) {
        val `val` = intArrayOf(60, 100, 120)
        val wt = intArrayOf(10, 20, 30)
        val W = 50
        val n = `val`.size
        println(knapSack(W, wt, `val`, n))
    }
}
