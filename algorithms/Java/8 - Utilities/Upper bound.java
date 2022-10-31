Dado un arreglo ordenado ascendentemente de tamaño n, busca el elemento x y devuelve la posición siguiente a la ultima aparición de x. Si la posición se sale del arreglo devuelve -1.

static int upper_bound(int arr[], int x) {
	int l = 0, r = arr.length-1;
	if (arr[r] <= x) return -1;
	while (l < r) {
		int m = (l+r)/2;
		if (arr[m] <= x) l = m+1;
		else r = m;
	}
	return l;
}
