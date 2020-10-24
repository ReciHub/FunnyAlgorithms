#Checking if a graph is bipartite
#We can check if a graph is bipartite 
#if we can color all the nodes of the graph using only two colors
import collections

def isBipartite(graph):
    colored = {}
    for i in range(10):
        if (i not in colored and graph[i]):
            colored[i] = 1
            q = collections.deque([i])
            while q:
                cur = q.popleft()
                #checking the neighbors of current node
                for j in graph[cur]:
                    if j not in colored:
                        colored[j] = 1-colored[cur]
                        q.append(j)
                   #neighbor is the same color as the current node
                   elif colored[j]==colored[cur]:
                        return False
    return True

graph = collections.defaultdict()

#define the edges within a graph
edges = [[0,1],[0,2],[0,3],[1,2],[2,3]]

#building the graph
for i in range(10):
    graph[i] = []
for i,j in edges:
    graph[i].append(j)
    graph[j].append(i)
print(isBipartite(graph))
