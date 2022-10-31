import java.util.Scanner;

public class Average {

    public static void main(String[] args) {
        Integer num1, num2, resultado;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o primeiro número");
        num1 = scanner.nextInt();
        System.out.println("Insira o segundo número");
        num2 = scanner.nextInt();

        resultado = num1+num2;
        System.out.println("O resultado da soma é: "+ resultado);
    }
}
