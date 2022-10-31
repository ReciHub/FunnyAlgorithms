La función de Miller-Rabin determina si un número dado es o no un número primo. IMPORTANTE: Debe agregarse los métodos de Modular Exponentiation y Modular Multiplication.

public static boolean isPrime(long p) {
    if (p < 2 || (p != 2 && p % 2 == 0)) {
        return false;
    }
    long s = p - 1;
    while (s % 2 == 0) {
        s /= 2;
    }
    for (int i = 0; i < 5; i++) {
        long a = (long) (Math.random() * p) % (p - 1) + 1;
        long temp = s;
        long mod = modpow(a, temp, p);
        while (temp != p - 1 && mod != 1 && mod != p - 1) {
            mod = modmul(mod, mod, p);
            temp *= 2;
        }
        if (mod != p - 1 && temp % 2 == 0) {
            return false;
        }
    }
    return true;
}
