package GenerateParanthesis;

import java.util.*;

public class GenerateParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        solve(0, 0, n, "", ans);

        return ans;
    }

    private static void solve(int open, int unbal, int n, String s, List<String> ans) {
        if (open == n) {
            while (unbal > 0) {
                s += ")";
                unbal--;
            }

            ans.add(s);
            return;
        }

        solve(open + 1, unbal + 1, n, s + "(", ans);

        if (unbal > 0) {
            solve(open, unbal - 1, n, s + ")", ans);
        }
    }
}
