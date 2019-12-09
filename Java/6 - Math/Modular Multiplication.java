Realiza la operación (a * b) % mod minimizando posibles desbordamientos.

public static long modmul(long a, long b, long mod) {
    long x = 0;
    long y = a % mod;
    while (b > 0) {
        if (b % 2 == 1) {
            x = (x + y) % mod;
        }
        y = (y << 1) % mod;
        b >>= 1;
    }
    return x % mod;
}
