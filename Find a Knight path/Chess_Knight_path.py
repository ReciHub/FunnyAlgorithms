"""Restore path for a chess knoght from the start to the end points, using
original chess rules regarding its movements
"""

from collections import deque

def make_path_graph():
    """Init a graph with all possible edges from one point to another"""

    letters = 'abcdefgh'
    numbers = '12345678'

    path_graph = dict()

    for letter in letters:
        for number in numbers:
            path_graph[letter + number] = set()

    add_all_neighbours(path_graph, letters, numbers)

    return path_graph


def add_all_neighbours(path_graph, letters, numbers):

    """Check if a cell is available for a knight movement, and add it
    to the graph
    """

    for i in range(8):
        for j in range(8):
            vertex1 = letters[i] + numbers[j]

            if 0 <= i + 2 < 8 and 0 <= j + 1 < 8:
                vertex2 = letters[i+2] + numbers[j+1]
                add_edge(path_graph, vertex1, vertex2)

            if 0 <= i - 2 < 8 and 0 <= j + 1 < 8:
                vertex2 = letters[i-2] + numbers[j+1]
                add_edge(path_graph, vertex1, vertex2)

            if 0 <= i + 2 < 8 and 0 <= j - 1 < 8:
                vertex2 = letters[i+2] + numbers[j-1]
                add_edge(path_graph, vertex1, vertex2)

            if 0 <= i - 2 < 8 and 0 <= j - 1 < 8:
                vertex2 = letters[i-2] + numbers[j-1]
                add_edge(path_graph, vertex1, vertex2)

            if 0 <= i + 1 < 8 and 0 <= j + 2 < 8:
                vertex2 = letters[i+1] + numbers[j+2]
                add_edge(path_graph, vertex1, vertex2)

            if 0 <= i - 1 < 8 and 0 <= j + 2 < 8:
                vertex2 = letters[i-1] + numbers[j+2]
                add_edge(path_graph, vertex1, vertex2)

            if 0 <= i + 1 < 8 and 0 <= j - 2 < 8:
                vertex2 = letters[i+1] + numbers[j-2]
                add_edge(path_graph, vertex1, vertex2)

            if 0 <= i - 1 < 8 and 0 <= j - 2 < 8:
                vertex2 = letters[i-1] + numbers[j-2]
                add_edge(path_graph, vertex1, vertex2)

    return path_graph


def add_edge(path_graph, vertex1, vertex2):
    """Adding vertexes to the graph for edge vertex1 - vertex2
    """

    path_graph[vertex1].add(vertex2)
    path_graph[vertex2].add(vertex1)

def find_path(start, finish):
    """Finding minimum length from start point to everyone else
    and restore the path
    """

    path_graph = make_path_graph()

    queue = deque()
    queue.append(start)

    parents = {vertex: None for vertex in path_graph}
    distances = {vertex: None for vertex in path_graph}
    distances[start] = 0

    while queue:
        current = queue.pop()

        for neighbour in path_graph[current]:
            if distances[neighbour] is None:
                queue.append(neighbour)
                distances[neighbour] = distances[current] + 1
                parents[neighbour] = current

    path = [finish]

    parent = parents[finish]
    while not parent is None:
        path.append(parent)
        parent = parents[parent]

    return path[::-1]


"""
========================
Check how does it work
========================
"""

print(find_path('c5', 'h8'))
