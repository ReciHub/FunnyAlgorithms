Calcula el coeficiente binomial nCr, entendido como el número de subconjuntos  de k elementos escogidos de un conjunto con n elementos.

static long ncr(long n, long r) {
	if (r < 0 || n < r) return 0;
	r = Math.min(r, n - r);
	long ans = 1;
	for (int i = 1; i <= r; i++) {
		ans = ans * (n - i + 1) / i;
	}
	return ans;
}
