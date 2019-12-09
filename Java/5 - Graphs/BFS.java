Búsqueda en anchura sobre grafos. Recibe un nodo inicial u y visita todos los nodos alcanzables desde u.
BFS tambien halla la distancia mas corta entre el nodo inicial u y los demas nodos si todas las aristas tienen peso 1.
    
static final int MAX = 100005; //Cantidad maxima de nodos
static ArrayList<Integer> g[] =  new ArrayList[MAX]; //Lista de adyacencia
static long dist[] = new long[MAX]; //Almacena la distancia a cada nodo
static int N, M; //Cantidad de nodos y aristas

void bfs(int u) {
    Queue<Integer> q = new LinkedList<>();
    q.add(u);
    dist[u] = 0;

    while (!q.isEmpty()) {
        u = q.poll();
        for (int v : g[u]) {
            if (dist[v] == -1) {
                dist[v] = dist[u] + 1;
                q.add(v);
            }
        }
    }
}

static void init() {
    for(int i = 0; i <= N; i++) {
        g[i] = new ArrayList<>();
        dist[i] = -1;
    }
}
