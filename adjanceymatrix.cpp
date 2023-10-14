#include <vector>

using namespace std;

class Graph {
public:
  Graph(int n) : num_vertices(n) {
    adjacency_matrix.resize(n, vector<int>(n, 0));
  }

  void AddEdge(int u, int v) {
    adjacency_matrix[u][v] = 1;
  }

  bool IsAdjacent(int u, int v) {
    return adjacency_matrix[u][v] == 1;
  }

private:
  int num_vertices;
  vector<vector<int>> adjacency_matrix;
};
