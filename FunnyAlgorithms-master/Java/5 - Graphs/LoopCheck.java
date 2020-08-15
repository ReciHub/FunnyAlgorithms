Determina si un Grafo DIRIGIDO tiene o no ciclos.
SE DEBEN LIMPIAR LAS ESTRUCTURAS DE DATOS ANTES DE UTILIZARSE

static final int MAX = 10010; //Cantidad maxima de nodos
static int v; //Cantidad de Nodos del grafo
static ArrayList<Integer> ady[] = new ArrayList[MAX]; //Estructura para almacenar el grafo
static int dfs_num[] = new int[MAX]; 
static boolean loops; //Bandera de ciclos en el grafo

/* DFS_NUM STATES
	2 - Explored
	3 - Visited
 	-1 - Unvisited
*/

/*
Este metodo debe ser llamado desde un nodo inicial u.
Cortara su ejecucion en el momento que encuentre algun ciclo en el grafo.
*/
static void graphCheck( int u ){
	int j, next;
	
	if( loops ) return;
	
	dfs_num[u] = 2;
	
	for(j = 0; j < ady[u].size(); j++ ){
		next = ady[u].get(j);
		
		if( dfs_num[next] == -1 )	graphCheck( next );
		else if( dfs_num[next] == 2 ){
			loops = true;
			break;
		}
	}
	
	dfs_num[u] = 3;
}


public static void main(String args[]){
	for( int s = 1; s <= v && !loops; s++ ){ //Por si el grafo es NO conexo
		if( dfs_num[s] == -1 ) graphCheck(s);
	}
}