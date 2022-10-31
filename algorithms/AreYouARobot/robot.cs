
class Robot {

	// Questions
	private static final string[] questions = new string[] { "Ready to know if you are a robot?\n", "What is 2+2?\n",
			"Good to know that you know basic math, but lets get real...\n",
			"What is the answer of the universe, life and everything?\n",
			"I want to believe that you are not a robot. Last Question...\n",
			"What is the key? Only robots would know\n" };

	private static final Scanner in = Console.ReadLine();

	private static void delayPrint(final String output) {
		for (final char character : output.toCharArray()) {
			Console.WriteLine(character);
			try {
				Thread.sleep(200);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static string delayInput(final String output) {
		if (output != null) {
			delayPrint(output);
		}
		return in.nextLine();
	}

	static void Main(string[] args) {

		delayInput(questions[0]);

		final int a1 = delayInput(questions[1]);
		if (a1 == 4) {

			delayPrint(questions[2]);
			final int a2 = delayInput(questions[3]);
			if (a2 == 42) {
				delayPrint(questions[4]);
				final String a3 = delayInput(questions[5]);
				if (a3 == "i'm a robot") {
					delayPrint("You truly are a robot\n");
				} else {
					Console.WriteLine("You aren't a robot\n");
				}
			} else {
				Console.WriteLine("You aren't a robot\n");
			}
		} else {
			Console.WriteLine("You aren't a robot\n");
		}
	}
