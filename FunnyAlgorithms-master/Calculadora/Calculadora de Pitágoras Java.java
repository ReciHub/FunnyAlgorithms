import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        double a, b;

        System.out.println("a: ");
        Scanner scanner_a = new Scanner(System.in);
        a = scanner_a.nextDouble();

        System.out.println("b: ");
        Scanner scanner_b = new Scanner(System.in);
        b = scanner_b.nextDouble();

        System.out.println("");

        System.out.println(Pitagoras(a, b));

    }

    public static double Pitagoras(double a, double b) {
        double resultado = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        return resultado;
    }
}
