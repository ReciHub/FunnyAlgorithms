# Python Program to check whether 
# a graph is tree or not

from collections import defaultdict

class Graph():

	def __init__(self, V):
		self.V = V
		self.graph = defaultdict(list)

	def addEdge(self, v, w):
		# Add w to v ist.
		self.graph[v].append(w) 
		# Add v to w list.
		self.graph[w].append(v) 

	# A recursive function that uses visited[] 
	# and parent to detect cycle in subgraph 
	# reachable from vertex v.
	def isCyclicUtil(self, v, visited, parent):

		# Mark current node as visited
		visited[v] = True

		# Recur for all the vertices adjacent 
		# for this vertex
		for i in self.graph[v]:
			# If an adjacent is not visited, 
			# then recur for that adjacent
			if visited[i] == False:
				if self.isCyclicUtil(i, visited, v) == True:
					return True

			# If an adjacent is visited and not 
			# parent of current vertex, then there 
			# is a cycle.
			elif i != parent:
				return True

		return False

	# Returns true if the graph is a tree, 
	# else false.
	def isTree(self):
		# Mark all the vertices as not visited 
		# and not part of recursion stack
		visited = [False] * self.V

		# The call to isCyclicUtil serves multiple 
		# purposes. It returns true if graph reachable 
		# from vertex 0 is cyclic. It also marks 
		# all vertices reachable from 0.
		if self.isCyclicUtil(0, visited, -1) == True:
			return False

		# If we find a vertex which is not reachable
		# from 0 (not marked by isCyclicUtil(), 
		# then we return false
		for i in range(self.V):
			if visited[i] == False:
				return False

		return True

# Driver program to test above functions
g1 = Graph(5)
g1.addEdge(1, 0)
g1.addEdge(0, 2)
g1.addEdge(0, 3)
g1.addEdge(3, 4)
print ("Graph is a Tree" if g1.isTree() == True \
						else "Graph is a not a Tree")

g2 = Graph(5)
g2.addEdge(1, 0)
g2.addEdge(0, 2)
g2.addEdge(2, 1)
g2.addEdge(0, 3)
g2.addEdge(3, 4)
print ("Graph is a Tree" if g2.isTree() == True \
						else "Graph is a not a Tree")
						
 
