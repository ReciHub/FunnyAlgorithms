La función totient de Euler devuelve la cantidad de enteros positivos menores o iguales a n que son coprimos con n (gcd(n, i) = 1)

* Dado un valor n calcula el Euler totient de n. Debe ejecutarse primero Sieve of Eratosthenes (al menos hasta un numero mayor a la raiz cuadrada de n).

static long eulerTotient (long n) {
    long tot = n;
    for (int i = 0, p = primes.get(i); p*p <= n; p = primes.get(++i)) {
        if (n % p == 0) {
            while (n % p == 0) n /= p;
            tot -= tot / p;
        }
    }
    if (n > 1) tot -= tot / n;
    return tot;
}

* Calcular el Euler totient para todos los numeros menores o iguales a MAX.

static int MAX = 100;
static int[] totient = new int [MAX+1]; 
static boolean marked = new boolean[MAX+1];

static void eulerTotient() {
    marked[1] = 1;
    for (int i = 0; i <= MAX; i++) totient[i] = i;
    for (int i = 2; i <= MAX; i++) if (!marked[i]) {
        for (int j = i; j <= MAX ; j += i){
            totient[j] -= totient[j] / i;
            marked[j] = 1;
        }
        marked[i] = 0;
    }
}
