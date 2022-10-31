/**
 * @created October 2, 2019
 *
 * Example in kotlin on how to solve a classic question in Kotlin.
 *
 * Objective :
 *
 * Push all the zero’s of a given array to the end of the array.
 * The order of all other elements should be same.
 *
 * For example :
 *
 * If the given arrays is 		{1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}
 * Then it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}
 *
 * Time complexity is O(n) and Space complexity is O(1)
 *
 */

import java.util.*

fun pushZerosToEnd(array: IntArray) {
    val n = array.size
    var k = 0
    (0..(n - 1)).forEach {
        if (array[it] != 0) {
            array[k++] = array[it]
        }
    }
    while (k < n) {
        array[k++] = 0
    }
}

fun main() {
    println("How many elements will have your array?")
    val n = readLine()!!.toInt()
    val array = IntArray(n)

    (0..(n - 1)).forEach {
        print("Value for element ${it + 1}: ")
        array[it] = readLine()!!.toInt()
        println()
    }

    println("Initial array values: ${Arrays.toString(array)}")
    println()
    pushZerosToEnd(array)
    println("Array after pushing zeros to the back: ")

    array.forEach {
        print("$it ")
    }
    println()

}