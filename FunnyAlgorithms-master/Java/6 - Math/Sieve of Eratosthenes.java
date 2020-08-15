Guarda en primes los números primos menores o iguales a MAX. Para saber si p es un número primo, hacer: if (!marked[p])

static int MAX = 1000000;
static int SQRT = 1000;
static ArrayList<Integer> primes = new ArrayList<>();
static boolean marked[] = new boolean[MAX+1];

static void sieve() {
	marked[1] = true;
	int i = 2;
	for (; i <= SQRT; ++i) if (!marked[i]) {
		primes.add(i);
		for (int j = i*i; j <= MAX; j += i) marked[j] = true;
	}
	for (; i <= MAX; ++i) if (!marked[i]) primes.add(i);
}
