import java.util.Scanner;

public class CalculadoraPitagoras {
    public static void main(String[] args) {
        double a, b;
        Scanner sc = new Scanner(System.in);

        System.out.printf("a: ");
        a = sc.nextDouble();

        System.out.printf("b: ");
        b = sc.nextDouble();

        System.out.println("Result: " + pitagoras(a, b));
    }

    public static double pitagoras(double a, double b)
    {
        double resultado = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        return resultado;
    }
}