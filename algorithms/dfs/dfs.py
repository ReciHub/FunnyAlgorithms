# code for dfs of a tree
def dfs(root):
    # initilize a stack
    stack = []
    stack.append(root)
    while stack:
        current = stack.pop()
        visited[current] = 1
        # checks if the current node is a leaf node
        if current not in adj.keys():
            continue
        for i in adj[current]:
            if not visited[i]:
                stack.append(i)

# create the tree
adj = {0:[1,2],1:[3,4],2:[5,6,7],3:[8,9]}
# change the length of v as required to the length of the tree
visited = [0]*10
root = 0
dfs(root)

