import java.util.ArrayList;
import java.util.List;

/**
 * Parse first parameter as number n and return list of all prime numbers less or equal n.
 * Time complexity is O(N * log(log N)), memory complexity is O(N)
 */
public class EratosthenesSieve {
    public static void main(String[] args) {
        int n = Integer.valueOf(args[0]);
        List<Integer> primeNumbers = sieve(n);
        primeNumbers.forEach(EratosthenesSieve::print);
    }

    private static List<Integer> sieve(int n) {
        List<Integer> primeNumbers = new ArrayList<>();
        boolean[] nonPrimes = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            if (!nonPrimes[i]) {
                primeNumbers.add(i);
                for (int j = i; j <= n / i; j++) {
                    nonPrimes[i * j] = true;
                }
            }
        }

        return primeNumbers;
    }

    private static void print(int x) {
        System.out.printf("%d ", x);
    }
}
