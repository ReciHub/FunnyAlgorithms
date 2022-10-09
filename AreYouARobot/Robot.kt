val questions = arrayOf(
    "Ready to know if you are a robot?",
    "What is 2+2?",
    "Good to know that you know basic math, but lets get real...",
    "What is the answer of the universe, life and everything?",
    "I want to believe that you are not a robot. Last Question...",
    "What is the key? Only robots would know."
);

fun delayPrint(output: String) {
    for (character in output) {
        print(character);
        System.out.flush();
        try {
            Thread.sleep(200);
        } catch (e: InterruptedException) {
            e.printStackTrace();
        }
    }
    print("\n");
}

fun delayInput(output: String?): String {
    output?.let { delayPrint(output) };
    return readln();
}

fun main() {
    run check@{

        delayInput(questions[0]);
        val a1 = delayInput(questions[1]).toInt();
        if (a1 != 4) return@check;

        delayPrint(questions[2]);
        val a2 = delayInput(questions[3]).toInt();
        if (a2 != 42) return@check;

        delayPrint(questions[4]);
        val a3 = delayInput(questions[5]);
        if (a3 != "i'm a robot") return@check;

        delayPrint("You truly are a robot.");
        return;
    }
    println("You aren't a robot.");
}
