fun main() {

    for (i in 99 downTo 2) {
        println("$i bottles of beer on the wall, $i bottles of beer.")
        if (i == 2) println("Take one down and pass it around, 1 bottle of beer on the wall.")
        else println("Take one down and pass it around, ${i - 1} bottles of beer on the wall.")

        println()
    }

    println("1 bottle of beer on the wall, 1 bottle of beer.\n" +
            "Take one down and pass it around, no more bottles of beer on the wall.\n" +
            "\n" +
            "No more bottles of beer on the wall, no more bottles of beer.\n" +
            "Go to the store and buy some more, 99 bottles of beer on the wall."
    )
}