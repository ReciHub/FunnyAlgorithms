import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoveCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your First name: ");
        String a = scanner.nextLine().toLowerCase();
        System.out.print("Enter your partner's First name: ");
        String b = scanner.nextLine().toLowerCase();

        if (!a.matches("[a-zA-Z]+") || !b.matches("[a-zA-Z]+")) {
            System.out.println("\nINVALID INPUT");
            return;
        }

        Map<Character, Integer> love = new HashMap<>();

        for (char c : a.toCharArray()) {
            love.put(c, love.getOrDefault(c, 0) + 1);
        }

        for (char c : b.toCharArray()) {
            love.put(c, love.getOrDefault(c, 0) + 1);
        }

        int percent = 0;

        for (Map.Entry<Character, Integer> entry : love.entrySet()) {
            char s = entry.getKey();
            int i = entry.getValue();
            if (i > 1) {
                percent += (s - 'a') * i;
            }
        }

        if (percent >= 100) {
            System.out.println("\nWow, You two are Soulmates. With a perfect 100 % love.");
        } else if (percent >= 80) {
            System.out.println("\nThat's some serious love right there with " + percent + " %.");
        } else if (percent >= 60) {
            System.out.println("\nYou have good compatibility, with a love score of " + percent + " %.");
        } else {
            System.out.println("\nYou will face challenges, but your story will be an amazing one, my friend. Your love score is " + percent + " %.");
        }
    }
}

