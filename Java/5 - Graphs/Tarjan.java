Dado un grafo dirigido halla las componentes fuertemente conexas (SCC).

static final int MAX = 100005; //Cantidad maxima de nodos
static ArrayList<Integer> g[] = new ArrayList[MAX]; //Lista de adyacencia
static boolean[] vis = new boolean[MAX]; //Marca los nodos ya visitados
static Stack<Integer> st = new Stack();   
static int[] low = new int[MAX];
static int[] num = new int[MAX];
static int compOf[] = new int[MAX]; //Almacena la componente a la que pertenece cada nodo
static int cantSCC; //Cantidad de componentes fuertemente conexas
static int N, M, cont; //Cantidad de nodos y aristas

static void tarjan(int u) {
    low[u] = num[u] = cont++;
    st.push(u);
    vis[u] = true;
    
    for (int v : g[u]) {
        if (num[v] == -1)
            tarjan(v);
        if (vis[v])
            low[u] = Math.min(low[u], low[v]);
    }
    
    if (low[u] == num[u]) {
        while (true) {
            int v = st.pop();
            vis[v] = false;
            compOf[v] = cantSCC;
            if (u == v) break;
        }
        cantSCC++;
    }
}

static void init() {
    cont = cantSCC = 0;
    for (int i = 0; i <= N; i++) {
        g[i].clear();
        num[i] = -1;
    }
}
