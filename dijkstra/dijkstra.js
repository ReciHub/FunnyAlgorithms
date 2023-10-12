class Graph {
    constructor() {
        this.nodes = new Set();
        this.edges = {};
    }

    addNode(node) {
        this.nodes.add(node);
        this.edges[node] = [];
    }

    addEdge(node1, node2, weight) {
        this.edges[node1].push({ node: node2, weight });
        this.edges[node2].push({ node: node1, weight });
    }
}

function dijkstra(graph, startNode) {
    const visited = new Set();
    const distances = {};
    const previous = {};
    const queue = [];

    // Initialize distances and queue
    for (const node of graph.nodes) {
        distances[node] = node === startNode ? 0 : Infinity;
        previous[node] = null;
        queue.push({ node, distance: distances[node] });
    }

    while (queue.length > 0) {
        queue.sort((a, b) => a.distance - b.distance);
        const { node, distance } = queue.shift();

        if (distance === Infinity) break;

        for (const neighbor of graph.edges[node]) {
            if (!visited.has(neighbor.node)) {
                const tentativeDistance = distances[node] + neighbor.weight;
                if (tentativeDistance < distances[neighbor.node]) {
                    distances[neighbor.node] = tentativeDistance;
                    previous[neighbor.node] = node;
                }
            }
        }

        visited.add(node);
    }

    return { distances, previous };
}

function reconstructPath(previous, startNode, endNode) {
    const path = [];
    let currentNode = endNode;
    while (currentNode !== null) {
        path.unshift(currentNode);
        currentNode = previous[currentNode];
    }
    return path;
}

const graph = new Graph();
graph.addNode("A");
graph.addNode("B");
graph.addNode("C");
graph.addNode("D");
graph.addNode("E");

graph.addEdge("A", "B", 4);
graph.addEdge("A", "C", 2);
graph.addEdge("B", "C", 5);
graph.addEdge("B", "D", 10);
graph.addEdge("C", "D", 3);
graph.addEdge("C", "E", 2);
graph.addEdge("E", "D", 7);

const { distances, previous } = dijkstra(graph, "A");
const endNode = "D";
const path = reconstructPath(previous, "A", endNode);

console.log("Shortest distance to node", endNode, "is", distances[endNode]);
console.log("Shortest path to node", endNode, "is", path.join(" -> "));
