

import java.util.Stack;

public class Search {
	private final Graph g;
	private final int s;
	private boolean marked[];
	private int edgeTo[];
	 Search(Graph g,int s){
		 this.g=g;
		 this.s=s;
		 marked=new boolean[g.getV()];
		 edgeTo=new int[g.getV()];
		 dfs(s);
	 }
	 private void dfs(int v) {
		 marked[v]=true;
		 for(int w:g.adj(v)) {
			 edgeTo[w]=v;
			 if(!marked[w])dfs(w);
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

