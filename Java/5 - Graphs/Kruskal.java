Dado un grafo con pesos halla su árbol cobertor mínimo.
IMPORTANTE: Debe agregarse Disjoint Set.

static class edge implements Comparable<edge> {    
    int u, v, w;        
    edge(int _u, int _v, int _w) {
        u = _u;
        v = _v;
        w = _w;
    }

    @Override
    public int compareTo(edge o) {
        if(w > o.w)return 1;
        else return -1;
    }
}

static class par{
    int F, S;

    par(int f, int s){
        F = f;
        S = s;
    }

}

static final int MAX = 100005; //Cantidad maxima de nodos
static ArrayList<par> g[] = new ArrayList[MAX]; //Lista de adyacencia
static ArrayList<edge> e = new ArrayList<>(); //Lista de aristas
static int N, M; //Cantidad de nodos y aristas

static void kruskall() {
    Collections.sort(e);
    dsu ds = new dsu(N);
    int sz = 0;
    for (edge ed: e) {
    if (ds.find(ed.u) != ds.find(ed.v)) {
            ds.unite(ed.u, ed.v);
            g[ed.u].add(new par(ed.v, ed.w));
            g[ed.v].add(new par(ed.u, ed.w));
            if (++sz == N - 1) {
                break;
            }
        }
    }
}

static void init() {
    e.clear();
    for (int i = 0; i <= N; i++) {
        g[i] = new ArrayList<>();
    }
}
