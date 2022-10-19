import java.util.*;

class Graph
{
	private int v; // vertices
	private LinkedList<Integer> adj[]; //Adjacency List

	// Constructor
	Graph(int n)
	{
		v = n;
		adj = new LinkedList[v];
		for (int i=0; i<v; ++i) {
			adj[i] = new LinkedList();
		}
	}
	//Add an edge to graph
	void addEdge(int v,int w)
	{
		adj[v].add(w);
	}

	//BFS traversal
	void BFS(int s)
	{
		boolean vis[] = new boolean[v];

		// Create a queue for BFS
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		//Set the node as visited and enqueue
		vis[s]=true;
		q.add(s);

		while (q.size() != 0)
		{
			// Dequeue a vertex and print 
			s = q.poll();
			System.out.print(s+" ");

			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext())
			{
				int n = i.next();
				if (!vis[n])
				{
					vis[n] = true;
					q.add(n);
				}
			}
		}
	}
}

//Time Complexity: O(v+e)
//Auxiliary Space: O(v) 

//v = number of vertices and e = number of edges.

public class BFS {
	public static void main(String args[])
	{
		Graph graph = new Graph(4);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		System.out.println("BFS Traversal : ");
		graph.BFS(2);
	}
}

