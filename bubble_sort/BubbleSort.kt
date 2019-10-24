
import java.util.*
import java.lang.*
import java.io.*

class BubbleSort {
    internal fun bubbleSort(arr: IntArray) {
        val n = arr.size
        for (i in 0 until n - 1)
            for (j in 0 until n - i - 1)
                if (arr[j] > arr[j + 1]) {
                    val temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                }
    }

    internal fun printArray(arr: IntArray) {
        val n = arr.size
        for (i in 0 until n)
            print(arr[i].toString() + " ")
        println()
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val ob = BubbleSort()
            val arr = intArrayOf(120, 24, 29, 172, 2, 1, 5)
            ob.bubbleSort(arr)
            println("Sorted array")
            ob.printArray(arr)
        }
    }
}
