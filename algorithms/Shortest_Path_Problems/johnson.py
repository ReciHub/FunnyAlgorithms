import collections
MAX_INT = float('Inf') 
 
def minDistance(dist, visited): 

    (minimum, minVertex) = (MAX_INT, 0) 
    for vertex in range(len(dist)): 
        if minimum > dist[vertex] and visited[vertex] == False:
            (minimum, minVertex) = (dist[vertex], vertex) 

    return minVertex 


def Dijkstra(graph, modifiedGraph, src): 

    num_vertices = len(graph) 

    sptSet = collections.defaultdict(lambda : False) 
    dist = [MAX_INT] * num_vertices 
    dist[src] = 0

    for count in range(num_vertices): 

        curVertex = minDistance(dist, sptSet) 
        sptSet[curVertex] = True

        for vertex in range(num_vertices): 
            if ((sptSet[vertex] == False) and
                (dist[vertex] > (dist[curVertex] +
                modifiedGraph[curVertex][vertex])) and
                (graph[curVertex][vertex] != 0)): 
                
                dist[vertex] = (dist[curVertex] +
                                modifiedGraph[curVertex][vertex]); 

    for vertex in range(num_vertices): 
        print ('Vertex ' + str(vertex) + ': ' + str(dist[vertex])) 

def BellmanFord(edges, graph, num_vertices): 

    dist = [MAX_INT] * (num_vertices + 1) 
    dist[num_vertices] = 0

    for i in range(num_vertices): 
        edges.append([num_vertices, i, 0]) 

    for i in range(num_vertices): 
        for (src, des, weight) in edges: 
            if((dist[src] != MAX_INT) and
                    (dist[src] + weight < dist[des])): 
                dist[des] = dist[src] + weight 

    return dist[0:num_vertices] 

def JohnsonAlgorithm(graph): 

    edges = [] 

    for i in range(len(graph)): 
        for j in range(len(graph[i])): 

            if graph[i][j] != 0: 
                edges.append([i, j, graph[i][j]]) 

    modifyWeights = BellmanFord(edges, graph, len(graph)) 

    modifiedGraph = [[0 for x in range(len(graph))] for y in
                    range(len(graph))] 

    for i in range(len(graph)): 
        for j in range(len(graph[i])): 

            if graph[i][j] != 0: 
                modifiedGraph[i][j] = (graph[i][j] +
                        modifyWeights[i] - modifyWeights[j]); 

    print ('Modified Graph: ' + str(modifiedGraph)) 

    for src in range(len(graph)): 
        print ('\nShortest Distance with vertex ' +
                        str(src) + ' as the source:\n') 
        Dijkstra(graph, modifiedGraph, src) 

graph = [[0, -8, 2, 4], 
        [0, 0, 2, 6], 
        [0, 0, 0, 2], 
        [0, 0, 0, 0]] 

JohnsonAlgorithm(graph) 
