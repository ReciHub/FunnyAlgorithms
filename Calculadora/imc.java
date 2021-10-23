import java.util.Scanner;

public class Average {

    public static void main(String[] args) {
        Double peso, altura, imc;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira seu peso");
        peso = scanner.nextDouble();
        System.out.println("Insira sua altura em metros");
        altura = scanner.nextDouble();

        imc = peso/(Math.pow(altura,2));

        if (imc < 18.5) {
            System.out.println("Seu imc é "+ imc + " você tá só o osso.");
        }else if (imc >= 18.5 && imc < 25){
            System.out.println("Seu imc é "+ imc + " você está mec.");
        }else if (imc >= 25 && imc < 29.9){
            System.out.println("Seu imc é "+ imc + " você está fofinho.");
        }else if (imc >= 29.9 && imc < 39.9){
            System.out.println("Seu imc é "+ imc + " você está gordão.");
        }else{
            System.out.println("Seu imc é "+ imc + " você é o williangORDOx.");
        }
    }
}
