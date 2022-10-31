Dado un arreglo ordenado ascendentemente de tama�o n, busca el elemento x y devuelve su posici�n, si no lo encuentra devuelve -1.

static int binary_search(int array[], int x){
	int l = 0, r = arr.length-1;
	while (l <= r) {
		int m = (l+r)/2;
		if(array[m] < x) l = m+1;
		else if (array[m] > x) r = m-1;
		else return m;
	}
	return -1;
}