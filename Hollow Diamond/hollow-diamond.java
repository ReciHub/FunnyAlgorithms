import java.util.Scanner;

public class HollowDiamondPattern1 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = scan.nextInt();
        System.out.print("Enter the symbol you want to print: ");
        char symbol = scan.next().charAt(0);
        for (int i = 1; i <= rows; i++) {
            for (int j = rows; j > i; j--) {
                System.out.print(" ");
            }
            System.out.print(symbol);
            for (int j = 1; j < (i - 1) * 2; j++) {
                System.out.print(" ");
            }
            if (i == 1) {
                System.out.print("\n");
            } else {
                System.out.print(symbol + "\n");
            }
        }
        for (int i = rows - 1; i >= 1; i--) {
            for (int j = rows; j > i; j--) {
                System.out.print(" ");
            }
            System.out.print(symbol);
            for (int j = 1; j < (i - 1) * 2; j++) {
                System.out.print(" ");
            }
            if (i == 1) {
                System.out.print("\n");
            } else {
                System.out.print(symbol + "\n");
            }
        }
    }
}