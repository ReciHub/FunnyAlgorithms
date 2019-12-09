Estructura de datos que permite procesar consultas por rangos y actualizaciones individuales sobre un arreglo.
    
static int N = 100000;
static int bit[] = new int[N+1];

void add(int k, int val) {
    for (; k <= N; k += k&-k) bit[k] += val;
}

int rsq(int k) {
    int sum = 0;
    for (; k >= 1; k -= k&-k) sum += bit[k];
    return sum;
}

int rsq(int i, int j) { return rsq(j) - rsq(i-1); }

int lower_find(int val) { /// last value < or <= to val
    int idx = 0;
    for(int i = 31-Integer.numberOfLeadingZeros(N); i >= 0; --i) {
        int nidx = idx | (1 << i);
        if(nidx <= N && bit[nidx] <= val) { /// change <= to <
            val -= bit[nidx];
            idx = nidx;
        }
    }
    return idx;
}
