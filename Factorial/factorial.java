import java.util.Scanner;
/*This a example of Factorization*/
public class Main {
    public static long factorial(int n){
        long accumulator = 1;

        for(; n > 0; n--){
            accumulator *= n;
        }

        return accumulator;
    }

    public static boolean isInteger(String text){
        try{
            Integer.parseInt(text);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number to factorialize: ");
        String input = scanner.nextLine();

        if(isInteger(input)){
            try{
                int num = Integer.parseInt(input);
                System.out.println("The factorial of " + num + " is " + factorial(num));
            }catch(NumberFormatException e){
                System.out.println("What happened there ?");
            }
        }else {
            System.out.println("The input was not a number");
        }
    }
}