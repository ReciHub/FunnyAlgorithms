/*
 * Assignment- Kruskal in Java
 */

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

class graph {
	Scanner sc=new Scanner(System.in);
	int v,e;
	int matrix[][]=new int[40][40];
	static int[] parent = new int[20]; 
	 void createmat(int v,int e) 
	 { 
		 for(int i=0;i<40;i++) 
			{
			 for(int j=0;j<40;j++) 
				matrix[i][j]=0;
			 
			}
			for(int i=0;i<e;i++)
			{
				System.out.println(" "); 
				System.out.println("ENTER THE VERTICES FOR EDGES");
				System.out.println("ENTER (FROM)VERTICE FOR EDGE");
				int v1=sc.nextInt();
				System.out.println("ENTER (TO)EDGE FOR EDGE");
				int v2=sc.nextInt();
				System.out.println("ENTER THE COST ");
				int w =sc.nextInt();
				matrix[v1-1][v2-1]=w;
				matrix[v2-1][v1-1]=w;
			}
			displaymat(v,matrix);
	 }
	 
	 void displaymat(int v,int matrix[][]) 
	 {
		 System.out.print("  ");
			for(int i=0;i<v;i++)
				System.out.print((i+1)+" ");
			System.out.println(" ");
			System.out.println("_________________________");		
			for(int i=0;i<v;i++)
			{
				System.out.print((i+1)+"| ");
				for(int j=0;j<v;j++)
				{
					System.out.print(matrix[i][j]+" ");
				}
				System.out.println(" ");
			}	
			System.out.println(" ");
		   algo(matrix, v) ;
	 }
	 
	 static int find(int i) 
	 { 
	     while (parent[i] != i) 
	         i = parent[i]; 
	     return i; 
	 } 
	   
	 // Does union of i and j. It returns 
	 // false if i and j are already in same 
	 // set. 
	 static void union1(int i, int j) 
	 { 
	     int a = find(i); 
	     int b = find(j); 
	     parent[a] = b; 
	 } 
	   
	 // Finds MST using Kruskal's algorithm 
	 static void algo(int cost[][],int v) 
	 { 
		 for(int i=0;i<v;i++)
			{
				for(int j=0;j<v;j++)
				{
					if(cost[i][j]==0)
					{
						cost[i][j]=999;
					}
				}
					

			}
	     int mincost = 0; // Cost of min MST. 
	   
	   
		// Initialize sets of disjoint sets. 
	     for (int i = 0; i < v; i++) 
	         parent[i] = i; 
	   
	     // Include minimum weight edges one by one 
	     int edge_count = 0; 
	     while (edge_count < v - 1) 
	     { 
	         int min = 999, a = -1, b = -1; 
	         for (int i = 0; i < v; i++) 
	         { 
	             for (int j = 0; j < v; j++)  
	             { 
	                 if (find(i) != find(j) && cost[i][j] < min)  
	                 { 
	                     min = cost[i][j]; 
	                     a = i; 
	                     b = j; 
	                 } 
	             } 
	         } 
	   
	         union1(a, b); 
	         System.out.printf("EDGE %d:(%d, %d) COST:%d \n", 
	             edge_count++, a+1, b+1, min); 
	         mincost += min; 
	     } 
	     System.out.println(" ");
	     System.out.println("MINIMUM COST=  "+ mincost); 
	 }
}
public class kruskal {

	public static void main(String[] args) {
		Scanner s1=new Scanner(System.in);
		 System.out.println("ENTER NUMBER OF VERTICES(OFFICES)");
		 int v=s1.nextInt();
		System.out.println("ENTER NUMBER OF EDGES(ROUTES)");
		int e=s1.nextInt();
		graph g=new graph();
		g.createmat(v, e);
		

	}

}

/*
SAMPLE INPUT:

ENTER NUMBER OF VERTICES(OFFICES)
6
ENTER NUMBER OF EDGES(ROUTES)
9
 
ENTER THE VERTICES FOR EDGES
ENTER (FROM)VERTICE FOR EDGE
1
ENTER (TO)EDGE FOR EDGE
5
ENTER THE COST 
4
 
ENTER THE VERTICES FOR EDGES
ENTER (FROM)VERTICE FOR EDGE
1
ENTER (TO)EDGE FOR EDGE
4
ENTER THE COST 
1
 
ENTER THE VERTICES FOR EDGES
ENTER (FROM)VERTICE FOR EDGE
5
ENTER (TO)EDGE FOR EDGE
4
ENTER THE COST 
9
 
ENTER THE VERTICES FOR EDGES
ENTER (FROM)VERTICE FOR EDGE
4
ENTER (TO)EDGE FOR EDGE
3
ENTER THE COST 
5
 
ENTER THE VERTICES FOR EDGES
ENTER (FROM)VERTICE FOR EDGE
4
ENTER (TO)EDGE FOR EDGE
2
ENTER THE COST 
3
 
ENTER THE VERTICES FOR EDGES
ENTER (FROM)VERTICE FOR EDGE
2
ENTER (TO)EDGE FOR EDGE
3
ENTER THE COST 
3
 
ENTER THE VERTICES FOR EDGES
ENTER (FROM)VERTICE FOR EDGE
3
ENTER (TO)EDGE FOR EDGE
6
ENTER THE COST 
8
 
ENTER THE VERTICES FOR EDGES
ENTER (FROM)VERTICE FOR EDGE
6
ENTER (TO)EDGE FOR EDGE
2
ENTER THE COST 
7
 
ENTER THE VERTICES FOR EDGES
ENTER (FROM)VERTICE FOR EDGE
1
ENTER (TO)EDGE FOR EDGE
2
ENTER THE COST 
2
*/
