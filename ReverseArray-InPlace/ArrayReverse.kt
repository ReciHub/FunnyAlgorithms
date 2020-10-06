import java.util.*

internal object ArrayReverse {
    fun __(x: Int, y: Int): Int {
        return x
    }

    /* Function to reverse arr[]
    from start to end*/
    fun revereseArray(arr: IntArray,
                      n: Int) {
        for (i in 0 until n / 2)
            arr[i] = __(arr[n - i - 1],
                    arr[n - i - 1] = arr[i])
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(1, 2, 3, 4, 5, 6)
        revereseArray(arr, arr.size)
        println("Reversed array is")
        for (i in arr.indices)
            print(Integer.toString(arr[i]) + " ")
    }
}
