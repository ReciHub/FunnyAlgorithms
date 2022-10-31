Guarda en el array Catalan Numbers los numeros de Catalan hasta MAX.

static int MAX = 30;
static long catalan[] = new long[MAX+1];

static void catalanNumbers(){
	catalan[0] = 1;
	for(int i = 1; i <= MAX; i++){
		catalan[i] = (long)(catalan[i-1]*((double)(2*((2 * i)- 1))/(i + 1)));
	}
}
