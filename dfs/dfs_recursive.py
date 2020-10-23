# code for dfs of a tree using a recursive approach
def dfs(root):

    if visited[root]:
        return
    visited[root] = 1                       
    #to check the validity of your code you print the root here
    if root in adj.keys():
        for i in adj[root]:
            dfs(i)

# create the tree
adj = {0:[1,2],1:[3,4],2:[5,6,7],3:[8,9]}
# change the length of v as required to the length of the tree
visited = [0]*10
root = 0
dfs(root)
