import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        double dUm, dDois, tempoUm, tempoDois;

        System.out.println("Posição inicial: ");

        Scanner scanner_d1 = new Scanner(System.in);
        dUm = scanner_d1.nextDouble();

        System.out.println("Posição Final: ");
        Scanner scanner_d2 = new Scanner(System.in);
        dDois = scanner_d2.nextDouble();

        System.out.println("");

        System.out.println("Tempo Inicial: ");
        Scanner scanner_t1 = new Scanner(System.in);
        tempoUm = scanner_t1.nextDouble();

        System.out.println("Tempo Final: ");
        Scanner scanner_t2 = new Scanner(System.in);
        tempoDois = scanner_t2.nextDouble();

        System.out.println("");

        System.out.println(Velocidade(dUm, dDois, tempoUm, tempoDois));

    }

    public static double Velocidade(double dUm, double dDois, double tempoUm, double tempoDois) {
        double resultado = (dDois - dUm) / (tempoDois - tempoUm);
        return resultado;
    }
}