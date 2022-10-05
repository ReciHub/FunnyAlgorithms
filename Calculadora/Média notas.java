import java.util.Scanner;

public class Average {

    public static void main(String[] args) {
        double n1, n2, n3, n4, media;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira a primeira nota");
        n1 = scanner.nextDouble();
        System.out.println("Insira a segunda nota");
        n2 = scanner.nextDouble();
        System.out.println("Insira a terceira nota");
        n3 = scanner.nextDouble();
        System.out.println("Insira a quarta nota");
        n4 = scanner.nextDouble();
        media = (n1+n2+n3+n4)/4;

        if(media >= 7)
        System.out.println("Sua média é "+ media + ", você foi aprovado.");
        else{
            System.out.println("Sua média é "+ media + ", você foi reprovado.");
        }

    }
}
