import java.util.Scanner;
import java.util.Random;

public class DiceRoller {

    public static void main(String[] args) {

        String[][] dice = {
                {" ------- ","|       |","|   *   |","|       |"," ------- "},
                {" ------- ","|     * |","|       |","| *     |"," ------- "},
                {" ------- ","|     * |","|   *   |","| *     |"," ------- "},
                {" ------- ","| *   * |","|       |","| *   * |"," ------- "},
                {" ------- ","| *   * |","|   *   |","| *   * |"," ------- "}
        };

        String decision = "y";

        Scanner scanner = new Scanner(System.in);

        Random r = new Random();

        int x, y;

        while(decision.toLowerCase().equals("y")) {
            x = r.nextInt(5);
            y = r.nextInt(5);

            for(int i = 0; i < 5; i++) {
                System.out.println(dice[x][i] + dice[y][i]);
            }

            System.out.println("\nWould you like to roll again? y = yes, n = no\n");

            decision = scanner.nextLine();
        }

    }

}