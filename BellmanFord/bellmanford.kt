class Edge(val source: Int, val destination: Int, val weight: Int)

class Graph(val vertices: Int, val edges: List<Edge>) {
    fun bellmanFord(startVertex: Int) {
        val distance = IntArray(vertices) { Int.MAX_VALUE }
        distance[startVertex] = 0

        for (i in 1 until vertices) {
            for (edge in edges) {
                if (distance[edge.source] != Int.MAX_VALUE && distance[edge.source] + edge.weight < distance[edge.destination]) {
                    distance[edge.destination] = distance[edge.source] + edge.weight
                }
            }
        }

        for (edge in edges) {
            if (distance[edge.source] != Int.MAX_VALUE && distance[edge.source] + edge.weight < distance[edge.destination]) {
                println("Graph contains a negative-weight cycle.")
                return
            }
        }

        for (i in 0 until vertices) {
            println("Shortest distance from vertex $startVertex to vertex $i is ${distance[i]}")
        }
    }
}

fun main() {
    val vertices = 5
    val edges = listOf(
        Edge(0, 1, -1),
        Edge(0, 2, 4),
        Edge(1, 2, 3),
        Edge(1, 3, 2),
        Edge(1, 4, 2),
        Edge(3, 2, 5),
        Edge(3, 1, 1),
        Edge(4, 3, -3)
    )

    val graph = Graph(vertices, edges)

    val startVertex = 0
    graph.bellmanFord(startVertex)
}
