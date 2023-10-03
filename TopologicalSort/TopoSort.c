#include <stdio.h>
#include <stdlib.h>

#define MAX_VERTICES 100

struct Node {
    int data;
    struct Node* next;
};

struct Graph {
    int numVertices;
    struct Node** adjLists;
    int* visited;
};

struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

struct Graph* createGraph(int vertices) {
    struct Graph* graph = (struct Graph*)malloc(sizeof(struct Graph));
    graph->numVertices = vertices;
    graph->adjLists = (struct Node**)malloc(vertices * sizeof(struct Node*));
    graph->visited = (int*)malloc(vertices * sizeof(int));

    for (int i = 0; i < vertices; ++i) {
        graph->adjLists[i] = NULL;
        graph->visited[i] = 0;
    }

    return graph;
}

void addEdge(struct Graph* graph, int src, int dest) {
    struct Node* newNode = createNode(dest);
    newNode->next = graph->adjLists[src];
    graph->adjLists[src] = newNode;
}

void topologicalSortHelper(int vertex, struct Graph* graph, struct Node** result, int* index) {
    graph->visited[vertex] = 1;
    struct Node* adjList = graph->adjLists[vertex];
    while (adjList != NULL) {
        int connectedVertex = adjList->data;
        if (!graph->visited[connectedVertex]) {
            topologicalSortHelper(connectedVertex, graph, result, index);
        }
        adjList = adjList->next;
    }
    (*result)[(*index)++] = vertex;
}

void topologicalSort(struct Graph* graph) {
    struct Node* result = (struct Node*)malloc(graph->numVertices * sizeof(struct Node));
    int index = 0;

    for (int i = 0; i < graph->numVertices; ++i) {
        if (!graph->visited[i]) {
            topologicalSortHelper(i, graph, &result, &index);
        }
    }

    // Print the topological order
    printf("Topological Order: ");
    for (int i = graph->numVertices - 1; i >= 0; --i) {
        printf("%d ", result[i]);
    }

    free(result);
}

int main() {
    int numVertices, numEdges;
    printf("Enter the number of vertices: ");
    scanf("%d", &numVertices);
    printf("Enter the number of edges: ");
    scanf("%d", &numEdges);

    struct Graph* graph = createGraph(numVertices);

    printf("Enter the edges (src dest):\n");
    for (int i = 0; i < numEdges; ++i) {
        int src, dest;
        scanf("%d %d", &src, &dest);
        addEdge(graph, src, dest);
    }

    printf("Topological Sort:\n");
    topologicalSort(graph);

    // Cleanup
    for (int i = 0; i < graph->numVertices; ++i) {
        struct Node* temp = graph->adjLists[i];
        while (temp != NULL) {
            struct Node* prev = temp;
            temp = temp->next;
            free(prev);
        }
    }
    free(graph->adjLists);
    free(graph->visited);
    free(graph);

    return 0;
}
