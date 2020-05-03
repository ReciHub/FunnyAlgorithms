import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x,y,k,n,m;
        int r,l;
        x = scanner.nextInt();
        y = scanner.nextInt();
        k = scanner.nextInt();
        n = scanner.nextInt();
        m = scanner.nextInt();
        r = x + k * n;
        l = y + k * m;
        System.out.println(r + " " + l);
    }
}
