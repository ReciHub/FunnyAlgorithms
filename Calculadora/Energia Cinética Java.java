import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        double massa, vel;

        System.out.println("Massa: ");

        Scanner scanner_massa = new Scanner(System.in);
        massa = scanner_massa.nextDouble();

        System.out.println("Velocidade: ");
        Scanner scanner_vel = new Scanner(System.in);
        vel = scanner_vel.nextDouble();

        System.out.println("");

        System.out.println(EC(massa, vel));

    }

    public static double EC(double massa, double vel) {
        double resultado = (massa * Math.pow(vel, 2)) / 2;
        return resultado;
    }
}