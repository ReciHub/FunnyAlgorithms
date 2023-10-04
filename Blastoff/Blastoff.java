import java.util.Scanner;

public class Blastoff {
    // Ignore the InterruptedException. It won't do anything wrong but we need this line here.
    public static void main(String[] args) throws InterruptedException {
        // Start the radio...
        System.out.println("czzzck... ## czzzzz..z..ck ...");
        // Is that radio static I hear...?
        System.out.println("Greetings... how many seconds do we have, boss? ");
        // Oh! Lemme check my watch!
        System.out.print("czzck## we have ... : ");
        // Create the scanner instance. This takes user input from the console!
        // This is as complicated as it gets :)
        Scanner inputScanner = new Scanner(System.in);
        // Await the user's response.
        int countdownStart = inputScanner.nextInt();
        // BEGIN THE COUNTDOWN!
        System.out.println("## ... # .. starting countdown ....c..zzz#..c.k");
        // The for loop to show the countdown
        // This iterates from countdownStart to 0, but stops at 0.
        for(int i = countdownStart; i > 0; i--) {
            // Show the countdown number
            System.out.println(i + "...");
            // Wait 1 second
            Thread.sleep(1000);
        }
        // Countdown finished!
        System.out.println("BLAST OFF!!!");
        // Wait for a user input to end the program.
        inputScanner.next();
    }
}
