package FunnyAlgorithms.HappyNumber;

import java.util.*;

public class HappyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(n);

        while (n != 1) {
            int nxt = 0;
            while (n > 0) {
                nxt += (int) Math.pow(n % 10, 2);
                n /= 10;
            }

            if (nxt == 1) {
                break;
            }

            if (hs.contains(nxt)) {
                return false;
            }

            hs.add(nxt);

            n = nxt;
        }

        return true;
    }
}
