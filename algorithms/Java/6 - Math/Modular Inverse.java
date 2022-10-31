El inverso multiplicativo modular de a % mod es un entero b tal que (a*b) % mod = 1. Éste existe siempre y cuando a y mod sean coprimos (gcd(a, mod) = 1).
El inverso modular de a se utiliza para calcular (n/a) % mod como (n*b) % mod.

* Se puede calcular usando el algoritmo de Euclides extendido. Agregar Extended Euclides.

public static long modInverse(int a, int mod) {
    long d = extendedEuclid(a, mod);
    if (d > 1) {
        return -1;
    }
    return (x % mod + mod) % mod;
}

* Si mod es un número primo, se puede calcular aplicando el pequeño teorema de Fermat. Agregar Modular Exponentiation.

public static long modInverse(int a, int mod) {
    return modpow(a, mod - 2, mod);
}

* Calcular el inverso modular para todos los numeros menores a mod.

static int inv[];

public static void modInverse(int mod) {
    inv = new int[mod];
    inv[1] = 1;
    for (int i = 2; i < mod; i++) {
        inv[i] = (mod - (mod / i) * inv[mod % i] % mod) % mod;
    }
}
