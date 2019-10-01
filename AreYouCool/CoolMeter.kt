import java.util.concurrent.ThreadLocalRandom

fun main() {
    while (true) {
        println("From 0-100 how cool you think you are?: ")
        val x = readLine().orEmpty().toInt()
        val list = mutableListOf<Int>()
        var i = 0;
        while (i < x) {
            val value = ThreadLocalRandom.current().nextInt(0, x + 1)
            if (list.contains(value) || value == 0) {
                i--
                i++
                continue
            }
            list.add(value)
            i++
        }

        val posi = list[ThreadLocalRandom.current().nextInt(0, x)]
        println(when {
            posi > x / 2 -> "You are cool!"
            posi < x / 2 -> "You are not so cool!"
            else         -> "You are kinda cool, but not so much"
         })
    }
}
