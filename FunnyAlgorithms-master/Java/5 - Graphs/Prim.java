Dado un grafo halla el costo total de su arbol cobertor mínimo.

static final int MAX = 100005; //Cantidad maxima de nodos
static ArrayList<edge> g[] = new ArrayList[MAX]; //Lista de adyacencia
static boolean[] vis = new boolean[MAX]; //Marca los nodos ya visitados
static long ans; //Costo total del arbol cobertor minimo
static int N, M; //Cantidad de nodos y aristas

static class edge implements Comparable<edge>{
    int v;
    long w;
    
    edge(int _v, long _w){
        v = _v;
        w = _w;
    }

    @Override
    public int compareTo(edge o) {
        if(w > o.w)return 1;
        return -1;
    }   
}

static void prim() {
    PriorityQueue<edge> pq = new PriorityQueue<>();
    vis[0] = true;
    for (edge ed : g[0]) {
        int v = ed.v;
        if (!vis[v]) pq.add(new edge(v, ed.w));
    }
    
    while (!pq.isEmpty()) {
        edge ed = pq.poll(); 
        int u = ed.v;
        if (!vis[u]) {
            ans += ed.w;
            vis[u] = true;
            for (edge e : g[u]) {
                int v = e.v;
                if (!vis[v]) pq.add(new edge(v, e.w));
            }
        }
    }
}

static void init() {
    ans = 0;
    for(int i = 0; i <= N; i++) {
        g[i] = new ArrayList();
        vis[i] = false;
    }
}  
