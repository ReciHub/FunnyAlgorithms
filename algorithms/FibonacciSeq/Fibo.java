import java.util.Scanner;

class Fibo{

    public static void fibo(int limit){

        int a = 0, b = 1, c;

        while( limit > 0 ){
            System.out.print(a + ", ");
            c = a + b;
            a = b;
            b = c;
            limit--;
        }

    }

    public static void main(String args[]){

        Scanner in = new Scanner(System.in);

        System.out.print("Enter limit : ");
        int n = in.nextInt();

        System.out.println("\nFibonacci Series :");
        fibo(n);

    }
}
