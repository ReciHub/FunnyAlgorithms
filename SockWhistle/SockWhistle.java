import java.util.Scanner;

public class SockWhistle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Sock Whistle Simulator!");
        System.out.print("Blow the sock whistle? (yes/no): ");
        String input = scanner.next();

        if (input.equalsIgnoreCase("yes")) {
            System.out.println("You blow the sock whistle gently...");
            System.out.println("Waiting for a response...");

            // Simulate a response from the sock using random chance
            if (Math.random() < 0.5) {
                System.out.println("Success! Your missing sock has been summoned!");
            } else {
                System.out.println("No response. Your sock might be camera shy.");
            }
        } else {
            System.out.println("No sock whistle blown. Try it next time you misplace a sock!");
        }

        scanner.close();
    }
}
