class Graph():
    def __init__(self, vertices,graph):
        self.V = vertices
        self.graph = graph
    def printSolution(self, dist):
        print("Vertex \t Distance from Source")
        for i in range(self.V):
            print(i, "\t\t", dist[i])
    def minDistance(self, dist, sptSet):
        global min_index
        min=1e7
        for v in range(self.V):
            if dist[v] < min and sptSet[v] == False:
                min = dist[v]
                min_index = v
        return min_index
    def dijikstra(self):
        dist = [1e7] * self.V
        dist[0] = 0
        sptSet = [False] * self.V
        for i in range(self.V):
            u = self.minDistance(dist, sptSet)
            sptSet[u] = True
            for v in range(self.V):
                if (self.graph[u][v] > 0 and dist[v] > dist[u] + self.graph[u][v]):
                    dist[v] = dist[u] + self.graph[u][v]
        self.printSolution(dist)


graph =[[0,10,3,0,0],
[0,0,1,2,0],
[0,4,0,8,2],
[0,0,0,0,7],
[0,0,0,9,0]]
g = Graph(5,graph)
g.dijikstra()
