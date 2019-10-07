//Java program for implementation of Ford Fulkerson algorithm
import java.util.LinkedList;
import java.util.Random;

public class MaxFlow {
	static int V; //Number of vertices in graph
    static int n;
    static int parent[];

    /* Returns true if there is a path from source 's' to sink
    't' in residual graph. Also fills parent[] to store the
    path */
    
    boolean bfs(int rGraph[][], int s, int t, int parent[])
    {
        // Create a visited array and mark all vertices as not
        // visited
        boolean visited[] = new boolean[V];
        for(int i=0; i<V; ++i)
            visited[i] = false;

        // Create a queue, enqueue source vertex and mark
        // source vertex as visited
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;

        // Standard BFS Loop
        while (queue.size()!=0)
        {
            int u = queue.poll();

            for (int v=0; v<V; v++)
            {
                if (visited[v]==false && rGraph[u][v] > 0)
                {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        // If we reached sink in BFS starting from source, then
        // return true, else false
        return (visited[t] == true);
    }

    // Returns the maximum flow from s to t in the given graph
    int fordFulkerson(int graph[][], int s, int t)
    {
        int u, v;

        // Create a residual graph and fill the residual graph
        // with given capacities in the original graph as
        // residual capacities in residual graph

        // Residual graph where rGraph[i][j] indicates
        // residual capacity of edge from i to j (if there
        // is an edge. If rGraph[i][j] is 0, then there is
        // not)
        int rGraph[][] = new int[V][V];

        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];

        // This array is filled by BFS and to store path
        parent = new int[V];

        int max_flow = 0; // There is no flow initially

        // Augment the flow while there is path from source
        // to sink
        while (bfs(rGraph, s, t, parent))
        {
            // Find minimum residual capacity of the edges
            // along the path filled by BFS. Or we can say
            // find the maximum flow through the path found.
            int path_flow = Integer.MAX_VALUE;
            for (v=t; v!=s; v=parent[v])
            {
                u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }

            // update residual capacities of the edges and
            // reverse edges along the path
            for (v=t; v != s; v=parent[v])
            {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }

            // Add path flow to overall flow

            System.out.print(" - "+path_flow);

            max_flow += path_flow;
        }

        // Return the overall flow
        System.out.println();
        return max_flow;
    }

    // Driver program to test above functions
    public static void main (String [] args)
    {
        MaxFlow m = new MaxFlow();

        Random r1 = new Random();
        int low = 4;
        int high = 10;
        n = r1.nextInt(high-low) + low;

        V=n;

        int[][] size = new int[n][n];
        int i;
        for(i=0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                size[i][i] = 0;
                size[j][0] = 0;
                size[i][j] = r1.nextInt(20-5)+5;
                size[n-1][n-1] = 0;

            }
        }
        System.out.println();
        System.out.println(" The 2d graph visualizing capacities on the edges ");
        System.out.println();

        for (int[] x : size)
        {
            for (int y : x)
            {
                System.out.printf("%4d",y);
            }
            System.out.println("");
        }



        System.out.println();

        System.out.println(" Number of nodes : "+n);
        System.out.print(" Flow in each node : ");

        System.out.println(" The maximum possible flow : " +
                m.fordFulkerson(size, 0, V-1));

    }
}
