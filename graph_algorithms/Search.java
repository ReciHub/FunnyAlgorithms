

import java.util.Stack;

public class Search {
	private final Graph g;
	private final int s;
	private boolean marked[];
	private int edgeTo[];
	/*
	This takes a graph object and the source object . 
	Option 0 will give you dfs and option 1 gives bfs
	*/
	Search(Graph g,int s,int option){
		 this.g=g;
		 this.s=s;
		 marked=new boolean[g.getV()];
		 edgeTo=new int[g.getV()];
		 if(option==0) dfs(s);
		 else bfs(s);
	 }
	 private void dfs(int v) {
		 marked[v]=true;
		 for(int w:g.adj(v)) {
			 edgeTo[w]=v;
			 if(!marked[w])dfs(w);
		 }
	 }
	 private void bfs(int s){
		marked[s]=true;
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(s);
		while(queue.size()!=0){
		 int v=queue.pop();
		 for(int w:g.adj(v)){
		 if(!marked[w]){
		 	edgeTo[w]=v;
		 	marked[w]=true;
		 	queue.add(w);	
		 
		 }
		
		}
	 }
	 private boolean isConnected(int v) {
		 return marked[v];
	 }
	 private String showPath(int v) {
		 if(!isConnected(v)) return "This vertex is not conncted to the source";
		 String str="";
		 for(int x=v;x!=s;x=edgeTo[x]) {
			 str=x+" "+str;
		 }
		 return str;
	 }
	 
	 
}

