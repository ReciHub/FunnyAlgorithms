import java.util.Scanner;

class FizzBuzz {

    private static void fizzbuzz(int limit) {
        for (int i = 1; i < limit; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz : " + i);
            }
            if (i % 3 == 0) {
                System.out.println("Fizz : " + i);
            }
            if (i % 5 == 0) {
                System.out.println("Buzz : " + i);
            }
        }

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter limit : ");
        int n = in.nextInt();
        fizzbuzz(n);

    }
}
