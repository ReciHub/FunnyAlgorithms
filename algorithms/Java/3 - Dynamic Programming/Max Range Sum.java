Dado un arreglo de enteros, retorna la máxima suma de un rango de la lista.

static int maxRangeSum (int[] a) {
	int sum = 0, ans = 0;
	for (int i = 0; i < a.length; i++) {
		if (sum + a[i] >= 0) {  
			sum += a[i];
		  ans = Math.max(ans, sum);          
	  } else sum = 0;
	}
	return ans;
}
