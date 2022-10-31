object Words {

    def countWords(str: String): Array[String] = {
        str.split(" ")
    }

    def main(args: Array[String]): Unit = {
        val input = scala.io.StdIn.readLine("Enter a sentence:")
        println(countWords(input).length)
    }
}