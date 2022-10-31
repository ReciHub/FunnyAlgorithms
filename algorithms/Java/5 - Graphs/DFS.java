Búsqueda en profundidad sobre grafos. Recibe un nodo inicial u y visita todos los nodos alcanzables desde u.
DFS puede ser usado para contar la cantidad de componentes conexas en un grafo y puede ser modificado para que retorne información de los nodos dependiendo del problema.

static final int MAX = 100005; //Cantidad maxima de nodos
static ArrayList<Integer> g[] = new ArrayList[MAX]; //Lista de adyacencia
static boolean[] vis = new boolean[MAX]; //Marca los nodos ya visitados
static int N, M; //Cantidad de nodos y aristas

static void dfs(int u) {
    vis[u] = true;
    for (int v : g[u]) {
        if (!vis[v]) dfs(v);
    }
}

static void init() {
    for(int i = 0; i <= N; i++) {
        g[i] = new ArrayList<>();
        vis[i] = false;
    }
}
   
