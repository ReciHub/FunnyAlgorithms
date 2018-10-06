import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Coolmetter{
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("From 0-100 how cool you think you are?: ");
            int x = in.nextInt();
            ArrayList lista = new ArrayList();
            for (int i = 0; i < x; i++) {
                int value = ThreadLocalRandom.current().nextInt(0, x+1);
                if(lista.contains(value) || value == 0){
                    i--;
                    continue;
                }
                lista.add(value);
            }
            int posi = ThreadLocalRandom.current().nextInt(0, x);
            if((int)lista.get(posi) > x/2){
                System.out.println("You are cool!");
            } else if((int)lista.get(posi) < x/2){
                System.out.println("You are not cool!");
            } else{
                System.out.println("You are the rarest kind of cool");
            }
        }
    }
}