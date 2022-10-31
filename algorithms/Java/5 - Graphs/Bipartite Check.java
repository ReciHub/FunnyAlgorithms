Modificación del BFS para detectar si un grafo es bipartito.
    
static final int MAX = 100005; //Cantidad maxima de nodos
static ArrayList<Integer> g[] = new ArrayList[MAX]; //Lista de adyacencia
static int color[] = new int[MAX]; //Almacena el color de cada nodo
static boolean bipartite; //true si el grafo es bipartito
static int N, M; //Cantidad de nodos y aristas

void bfs(int u) {
    Queue<Integer> q = new LinkedList<>();
    q.add(u);
    color[u] = 0;
    
    while (!q.isEmpty()) {
        u = q.poll();
        for (int v : g[u]) {
            if (color[v] == -1) {
                color[v] = color[u]^1;
                q.add(v);
            } else if (color[v] == color[u]) {
                bipartite = false;
                return;
            }
        }
    }
}

static void init() {
    bipartite = true;
    for(int i = 0; i <= N; i++) {
        g[i] = new ArrayList<>();
        color[i] = -1;
    }
}
  
