import java.util.Scanner;

public class Average {

    public static void main(String[] args) {
        double nota1, nota2, nota3, num1, num2, num3, resultado;
        Integer peso1, peso2, peso3, pesototal;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira a primeira nota");
        nota1 = scanner.nextDouble();
        System.out.println("Insira o primeiro peso");
        peso1 = scanner.nextInt();
        System.out.println("Insira a segunda nota");
        nota2 = scanner.nextDouble();
        System.out.println("Insira o segundo peso");
        peso2 = scanner.nextInt();
        System.out.println("Insira a terceira nota");
        nota3 = scanner.nextDouble();
        System.out.println("Insira o terceiro peso");
        peso3 = scanner.nextInt();

        num1 = nota1*peso1;
        num2 = nota2*peso2;
        num3 = nota3*peso3;
        pesototal = peso1+peso2+peso3;
        resultado = (num1+num2+num3) / pesototal;

        if(resultado >= 7){
            System.out.println("A sua média é: "+ resultado +" você foi aprovado.");
        }else
        System.out.println("A sua média é: "+ resultado +" você foi reprovado.");
    }
}
