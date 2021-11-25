class Graph {
	private int V;
	private LinkedList<Integer> adj[]; // linked list 
	
	// constructor
	Graph (int v) {
		V = v;
		adj = new LinkedList[v];
		// v LinkedList declear
		for (int i = 0; i < v; ++i) {
			adj[i] = new LinkedList(); 
		}
	}
	void addEdge (int v, int w) { // v LinkedList  w insert
		adj[v].add(w); 
	}
	// DFS function
	void DFS(int v) { // v is start node
		boolean visited[] = new boolean[V]; 
		DFSUtil(v, visited);
	}
	// DFS invoke function
	void DFSUtil(int v, boolean visited[])  {
		visited[v] = true;
		System.out.println(v + " ");
		
		Iterator<Integer> it = adj[v].listIterator();
		while (it.hasNext()) {
			int n = it.next();
			if (!visited[n])
				DFSUtil(n, visited); 
		}
	}
}