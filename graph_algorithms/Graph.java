

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Graph {
	private int V;
	private int E;
	private ArrayList<Integer> a1[];
	Graph(int V){
		this.V=V;
		this.E=0;
		a1=new ArrayList[V];
		for(int i=0;i<V;i++)a1[i]=new ArrayList<Integer>();
		
	}
	public int getV() {
		return V;
	}
	public void setV(int v) {
		V = v;
	}
	public int getE() {
		return E;
	}
	public void setE(int e) {
		E = e;
	}
	Graph (InputStream in) throws IOException{
		this(in.read());
		int E=in.read();
		for(int i=0;i<E;i++) {
			int u=in.read();
			int v=in.read();
			addEdge(u,v);
		}
	}
	private void addEdge(int u, int v) {
		a1[u].add(v);
		a1[v].add(u);
		this.E++;
	}
	public Iterable<Integer> adj(int v){
		return a1[v];
	}
	@Override
	public String toString() {
		String str=new String();
		for(int i=0;i<this.V;i++) {
			str=str+":"+i+"-->";
			for(int w:adj(i)) 
				str=" "+w;
			str+="\n";
		}
		return str;
	}
}

