Dado un grafo halla la distancia mínima entre cualquier par de nodos. g[i][j] guardará la distancia mínima entre el nodo i y el j.
    
static final int INF = (1<<30);
static final int MAX = 505; //Cantidad maxima de nodos
static int g[][]= new int[MAX][MAX]; //Matriz de adyacencia
static int N, M; //Cantidad de nodos y aristas

static void floydWarshall() {
    for (int k = 0; k < N; k++)
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
}

static void init() {
    for(int i = 0; i <= N; i++) {
        for(int j = 0; j <= N; j++) {
            g[i][j] = INF;
        }
    }
}
