#include <algorithm>
#include <iostream>
#include <list>
#include <string.h>

using namespace std;

class Graph {
  int V; // vertices
  list < int > * adj; // A dynamic array of adjacency lists

  public:

    Graph(int V) {
      this -> V = V;
      adj = new list < int > [V];
    }~Graph() {
      delete[] adj;
    }

  void addEdge(int u, int v) {
    adj[u].push_back(v);
    adj[v].push_back(u);
  }

  void printEulerTour() {
    // Find a vertex with odd degree
    int u = 0;
    for (int i = 0; i < V; i++)
      if (adj[i].size() & 1) {
        u = i;
        break;
      }

    // Print tour starting from oddv
    printEulerUtil(u);
    cout << endl;
  }

  void printEulerUtil(int u) {
    // Recur for all the vertices adjacent to this vertex
    list < int > ::iterator i;
    for (i = adj[u].begin(); i != adj[u].end(); ++i) {
      int v = * i;

      // If edge u-v is not removed and it's a a valid
      // next edge
      if (v != -1 && isValidNextEdge(u, v)) {
        cout << u << "-" << v << "  ";
        rmvEdge(u, v);
        printEulerUtil(v);
      }
    }
  }

  bool isValidNextEdge(int u, int v) {
    // The edge u-v is valid in one of the following two
    // cases:

    // 1) If v is the only adjacent vertex of u
    int count = 0; // To store count of adjacent vertices
    list < int > ::iterator i;
    for (i = adj[u].begin(); i != adj[u].end(); ++i)
      if ( * i != -1)
        count++;
    if (count == 1)
      return true;

    // 2) If there are multiple adjacents, then u-v is not a
    // bridge Do following steps to check if u-v is a bridge

    // 2.a) count of vertices reachable from u
    bool visited[V];
    memset(visited, false, V);
    int count1 = DFSCount(u, visited);

    // 2.b) Remove edge (u, v) and after removing the edge,
    // count vertices reachable from u
    rmvEdge(u, v);
    memset(visited, false, V);
    int count2 = DFSCount(u, visited);

    // 2.c) Add the edge back to the graph
    addEdge(u, v);

    // 2.d) If count1 is greater, then edge (u, v) is a
    // bridge
    return (count1 > count2) ? false : true;
  }

  void rmvEdge(int u, int v) {
    // Find v in adjacency list of u and replace it with -1
    list < int > ::iterator iv = find(adj[u].begin(), adj[u].end(), v);
    * iv = -1;

    // Find u in adjacency list of v and replace it with -1
    list < int > ::iterator iu = find(adj[v].begin(), adj[v].end(), u);
    * iu = -1;
  }

  // A DFS based function to count reachable vertices from v
  int DFSCount(int v, bool visited[]) {
    // Mark the current node as visited
    visited[v] = true;
    int count = 1;

    // Recur for all adjacent vertices
    list < int > ::iterator i;
    for (i = adj[v].begin(); i != adj[v].end(); ++i)
      if ( * i != -1 && !visited[ * i])
        count += DFSCount( * i, visited);

    return count;
  }
};

int main() {

  Graph g3(5);
  g3.addEdge(1, 0);
  g3.addEdge(0, 2);
  g3.addEdge(2, 1);
  g3.addEdge(0, 3);
  g3.addEdge(3, 4);
  g3.addEdge(3, 2);
  g3.addEdge(3, 1);
  g3.addEdge(2, 4);
  g3.printEulerTour();

  return 0;

}
