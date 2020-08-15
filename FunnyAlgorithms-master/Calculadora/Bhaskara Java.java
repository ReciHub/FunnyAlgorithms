package program;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        double a, b, c, delta, bhaskara;

        a = 0;
        b = 0;
        c = 0;
        delta = 0;
        bhaskara = 0;

        System.out.println("a: ");
        Scanner scanner_a = new Scanner(System.in);
        a = scanner_a.nextDouble();

        System.out.println("b: ");
        Scanner scanner_b = new Scanner(System.in);
        b = scanner_b.nextDouble();

        System.out.println("c: ");
        Scanner scanner_c = new Scanner(System.in);
        c = scanner_c.nextDouble();

        delta = CalculoDelta(a, b, c);

        System.out.println("");

        System.out.println("Positivo: " + CalculoBhaskaraP(a, b, delta, bhaskara) + "  - Negativo: " + CalculoBhaskaraN(a, b, delta, bhaskara));

    }

    public static double CalculoDelta(double a, double b, double c) {
        double delta = (b * b) - (4 * (a * c));
        return delta;
    }

    public static double CalculoBhaskaraP(double delta, double bhaskarap, double a, double b) {
        double quadrado = (double) Math.sqrt(delta);
        bhaskarap = (-b + quadrado) / (2 * a);
        return bhaskarap;
    }

    public static double CalculoBhaskaraN(double delta, double bhaskaran, double a, double b) {
        double quadrado = (double) Math.sqrt(delta);
        bhaskaran = (-b - quadrado) / (2 * a);
        return bhaskaran;
    }
}
