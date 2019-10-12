public class Rot13 {

	public static void main(String[] args) {
		System.out.println(rot13("cat")); // Output: png
		System.out.println(rot26("cat")); // Output: cat
	}

	public static String rot13(String text) {
		StringBuilder builder = new StringBuilder();
		for (int index = 0; index < text.length(); index++) {
			char chr = text.charAt(index);

			if (chr >= 'a' && chr <= 'm') chr += 13;
			else if (chr >= 'A' && chr <= 'M') chr += 13;
			else if (chr >= 'n' && chr <= 'z') chr -= 13;
			else if (chr >= 'N' && chr <= 'Z') chr -= 13;
			builder.append(chr);
		}

		return builder.toString();
	}
	
	public static String rot26(String text) {
		return rot13(rot13(text));
	}
}