import java.util.Scanner;

public class Words {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the text:");
        String text = scanner.nextLine();
        String[] words= text.split(" ");
        int count= words.length;
        System.out.println("Your text contains " +count+ " words");

    }
}
