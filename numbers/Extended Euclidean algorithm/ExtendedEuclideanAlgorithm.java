/**
 * Parse two parameters as number a and b, return x,y and gcd(a, b) such, that
 * <p> {@code a * x + b * y = gcd(a, b)}
 * <p> Time complexity is O(log(min(a, b))), memory complexity is O(log(min(a, b))) [for recursion]
 */
public class ExtendedEuclideanAlgorithm {
    public static void main(String[] args) {
        int a = Integer.valueOf(args[0]);
        int b = Integer.valueOf(args[1]);

        GcdResult result = gcd(a, b);
        System.out.printf("x = %d, y = %d, gcd = %d\n", result.x, result.y, result.gcd);
        System.out.printf(
                "(%d) * (%d) + (%d) * (%d) = %d\n",
                a, result.x, b, result.y, result.gcd
        );

    }

    /**
     * Because when we call gcd(a, b) it will:
     *  <p>- call gcd(b % a, a), which return x', y' and gcd, such that {@code (b % a) * x' + a * y' = gcd}
     *  <p>- but we want to get x and y such that {@code a * x + b * y = gcd}
     *  <p>{@code (b % a) = b - k * a}, where {@code k = floor(b / a)}
     *  <p>{@code (b - k * a) * x' + a * y' = gcd}
     *  <p>{@code b * x' - k * a * x' + a * y' = gcd}
     *  <p>{@code a * (y' - k * x') + b * x' = gcd} compare with {@code a * x + b * y = gcd}
     *  <p>so {@code x = y' - floor(b / a) * x'} and {@code y = x'}
     */
    private static GcdResult gcd(int a, int b) {
        if (a == 0) {
            return new GcdResult(0, 1, b);
        }
        GcdResult nextGcdResult = gcd(b % a, a);
        int x = nextGcdResult.y - (b / a) * nextGcdResult.x;
        int y = nextGcdResult.x;
        return new GcdResult(x, y, nextGcdResult.gcd);
    }

    private static class GcdResult {
        int x;
        int y;
        int gcd;

        GcdResult(int x, int y, int gcd) {
            this.x = x;
            this.y = y;
            this.gcd = gcd;
        }

    }
}
