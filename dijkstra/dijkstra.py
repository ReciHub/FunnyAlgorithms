import math

# Problem description: https://www.thehuxley.com/problem/3060


def minDistance(vertex_size, dist, shortest_path_tree):
    min = math.inf
    min_index = -1
    for destination in range(vertex_size):
        if dist[destination] < min and shortest_path_tree[destination] == False:
            min = dist[destination]
            min_index = destination
    return min_index


def dijkstra(graph, vertex_size):
    dist = [math.inf] * vertex_size
    dist[0] = 0
    shortest_path_tree = [False] * vertex_size
    path = [False] * vertex_size

    for cout in range(vertex_size):
        visiting = minDistance(vertex_size, dist, shortest_path_tree)
        if visiting < 0:
            continue
        shortest_path_tree[visiting] = cout + 1
        for destination in range(vertex_size):
            if graph[visiting][destination] > 0 and shortest_path_tree[destination] == False and dist[destination] >= dist[visiting] + graph[visiting][destination]:
                dist[destination] = dist[visiting] + \
                    graph[visiting][destination]
                path[destination] = visiting

    return dist, path


vertex_size, edges_size = map(int, input().split())
graph = [[0 for column in range(vertex_size)] for row in range(vertex_size)]
for edge in range(edges_size):
    origin, destination, weigth = map(int, input().split())
    graph[origin-1][destination-1] = weigth
    graph[destination-1][origin-1] = weigth

dist, path = dijkstra(graph, vertex_size)
for vertex in range(vertex_size):
    if path[vertex] is False or path[vertex] == math.inf:
        path_text = "-"
    else:
        path_to_vertex = [path[vertex]]
        for max_path in range(vertex_size):
            if (path[path_to_vertex[0]] is False):
                break
            path_to_vertex.insert(0, path[path_to_vertex[0]])
        path_text = str(path_to_vertex[0]+1)
        for step in path_to_vertex[1:]:
            path_text += ", " + str(step + 1)
        path_text += " and distance {}".format(dist[vertex])
    print("Path to vertex {}: {}".format(vertex+1, path_text))
