# SHORTEST PATH ALGORITHMS

This directory provides solution to Shortest Path problems. Therre are 4 algorithms for calculating shortest paths. These are:

##1.Belman-Ford Algorithm:

-computes shortest paths in a weighted graph (where some of the edge weights may be negative)
-this algorithm has already been implemented by someone and can be found in 'FunnyAlgorithms/BellmanFord' directory.

##2.Dijkstra's Algorithm:

-computes shortest paths in a graph with non-negative edge weights.
-this algorithm has already been implemented by someone and can be found in 'FunnyAlgorithms/GreedyAlgorithms/' directory.

##3.Floyd-Warshall Algorithm:

-solves the all pairs shortest path problem in a weighted, directed graph
-I have implemented this algorithm.

##4. Johnson's Algorithm:

-All pairs shortest path algorithm in sparse weighted directed graph.
-It allows some of the edge weights to be negative numbers, but no negative-weight cycles may exist. It works by using the Bellman–Ford algorithm to compute a transformation of the input graph that removes all negative weights, allowing Dijkstra's algorithm to be used on the transformed graph.
-I have implemented this algorithm.

