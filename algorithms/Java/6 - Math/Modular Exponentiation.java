Realiza la operación (a ^ b) % mod.

static long modpow( long a,  long b,  long mod) {
    if (b == 0) return 1;
    if (b % 2 == 0) {
        long  temp = modpow(a, b/2, mod);
        return (temp * temp) % mod;
    } else {
        long  temp = modpow(a, b-1, mod);
        return (temp * a) % mod;
    }
}
