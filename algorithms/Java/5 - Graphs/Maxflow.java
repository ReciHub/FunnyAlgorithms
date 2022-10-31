Dado un grafo, halla el máximo flujo entre una fuente s y un sumidero t.
SE DEBEN LIMPIAR LAS ESTRUCTURAS DE DATOS ANTES DE UTILIZARSE

static int n; //Cantidad de nodos del grafo
static ArrayList<Integer> ady[] = new ArrayList[105]; //lista de Adyacencia
static int capacity[][]  = new int[105][105]; //Capacidad de aristas de la red
static int flow[][] = new int[105][105]; //Flujo de cada arista
static int prev[] = new int[105];

static void connect(int i, int j, int cap){
    ady[i].add(j);
    ady[j].add(i);
    capacity[i][j] += cap;
    //Si el grafo es dirigido no hacer esta linea
    //capacity[j][i] += cap;
}

static int maxflow(int s, int t, int n){ //s=fuente, t=sumidero, n=numero de nodos
    int i, j, maxFlow, u, v, extra, start, end;
    for( i = 0; i <= n; i++ ){
        for( j = 0; j <= n; j++ ){
            flow[i][j] = 0;
        }
    }

    maxFlow = 0;

    while( true ){
        for( i = 0; i <= n; i++ ) prev[i] = -1;

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        prev[s] = -2;

        while( !q.isEmpty() ){
            u = q.poll();
            if( u == t ) break;
            for( j = 0; j < ady[u].size(); j++){
                v = ady[u].get(j);
                if( prev[v] == -1  && capacity[u][v] - flow[u][v] > 0 ){
                    q.add(v);
                    prev[v] = u;
                }
            }
        }
        if( prev[t] == -1 ) break;

        extra = Integer.MAX_VALUE;
        end = t;
        while( end != s ){
            start = prev[end];
            extra = Math.min( extra, capacity[start][end]-flow[start][end] );
            end = start;
        }

        end = t;
        while( end != s){
            start = prev[end];
            flow[start][end] += extra;
            flow[end][start] = -flow[start][end];
            end = start;
        }

        maxFlow += extra;
    }

    return maxFlow;
}

public static void main( String args[] ){
    //Para cada arista
    connect( s, d, f);  //origen, destino, flujo
}

