Dado un grafo acíclico dirigido (DAG), ordena los nodos linealmente de tal manera que si existe una arista entre los nodos u y v entonces u aparece antes que v.
Este ordenamiento es una manera de poner todos los nodos en una línea recta de tal manera que las aristas vayan de izquierda a derecha.

static final int MAX = 100005; //Cantidad maxima de nodos
static ArrayList<Integer> g[] = new ArrayList[MAX]; //Lista de adyacencia
static boolean[] vis = new boolean[MAX]; //Marca los nodos ya visitados
static LinkedList<Integer> topoSort = new LinkedList<>(); //Orden topologico del grafo
static int N, M; //Cantidad de nodos y aristas

static void dfs(int u) {
    vis[u] = true;
    for (int v : g[u]) {
        if (!vis[v]) dfs(v);
    }
    topoSort.addFirst(u);
}

static void init() {
    topoSort.clear();
    for(int i = 0; i <= N; i++) {
        g[i] = new ArrayList<>();
        vis[i] = false;
    }
}
