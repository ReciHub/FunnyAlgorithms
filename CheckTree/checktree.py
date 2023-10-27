def dfs(v, vis, arr):
    vis[v] = 1
    for child in arr[v]:
        if vis[child] == 0:
            dfs(child, vis, arr)

nodes, edges = map(int, input("Enter nodes and number of edges: ").split())
arr = [[] for _ in range(100001)]
vis = [0] * 100001

print("Enter the edges:")
for _ in range(edges):
    u, v = map(int, input().split())
    arr[u].append(v)
    arr[v].append(u)

cc_cnt = 0
for i in range(1, nodes + 1):
    if vis[i] == 0:
        dfs(i, vis, arr)
        cc_cnt += 1

if cc_cnt == 1:
    print("This graph is a tree")
else:
    print("This graph is not a tree")
