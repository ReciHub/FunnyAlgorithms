Guarda en factors la lista de factores primos de n de menor a mayor. IMPORTANTE: Debe ejecutarse primero Sieve of Eratosthenes (al menos hasta un numero mayor a la raiz cuadrada de n).
		
static ArrayList<Integer> factors = new ArrayList<>();
    
public static void primeFactors(long n) {
    factors.clear();
    for (int i = 0, p = primes.get(i); p*p <= n; p = primes.get(++i)) {
        while (n % p == 0) {
            factors.add(p);
            n /= p;
        }
    }
    if (n > 1) factors.add(n);
}
