#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

// Define constants for infinity and the number of vertices
#define INF INT_MAX
#define V 4

// Function to print the solution matrix
void printSolution(int dist[V][V]) {
    printf("Shortest distances between vertices:\n");
    for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {
            if (dist[i][j] == INF) {
                printf("INF ");
            } else {
                printf("%d ", dist[i][j]);
            }
        }
        printf("\n");
    }
}

// Function to implement the Floyd-Warshall algorithm
void floydWarshall(int graph[V][V]) {
    int dist[V][V];
    int i, j, k;

    // Initialize the distance matrix with the given graph
    for (i = 0; i < V; i++) {
        for (j = 0; j < V; j++) {
            dist[i][j] = graph[i][j];
        }
    }

    // Update the distance matrix
    for (k = 0; k < V; k++) {
        for (i = 0; i < V; i++) {
            for (j = 0; j < V; j++) {
                if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }

    // Print the solution
    printSolution(dist);
}

int main() {
    // Example graph represented as an adjacency matrix
    int graph[V][V] = {
        {0, INF, INF, INF},
        {INF, 0, 3, INF},
        {INF, INF, 0, 1},
        {INF, INF, INF, 0}
    };

    floydWarshall(graph);

    return 0;
}

