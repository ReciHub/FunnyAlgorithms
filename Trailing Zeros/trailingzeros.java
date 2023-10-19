import java.util.Scanner;

public class TrailingZerosInFactorial {
    public static int trailingZeros(int n) {
        int no = 0;
        for (int i = 5; n / i >= 1; i *= 5) {
            no += n / i;
        }
        return no;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int zeros = trailingZeros(n);
        System.out.println(zeros);
        scanner.close();
    }
}
