import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String e = scanner.nextLine();
        int count = 0;
        for(int i = 0; i < e.length(); i++)
        {
            if(e.charAt(i) == '{')
            {
                count++;
            }
            else if(e.charAt(i) == '}')
            {
                count--;
            }
        }
        System.out.println(count == 0 ? "S" : "N");
    }
}
