 
#include <iostream>
#include <vector>
using namespace std;

int nodes, edges, u, v;
vector<int> arr[100001];   
vector<int> vis(100001, 0); 
void dfs(int v)
{

    vis[v] = 1;
    for (auto child : arr[v])
        if (vis[child] == 0)
        {
            dfs(child);
        }
}

int main()
{
    cout << "Enter nodes and number of edges: ";
    cin >> nodes >> edges;
    cout << "Enter the edges:- \n";
    for (int i = 1; i <= edges; i++)
    {
        cin >> u >> v;
        arr[u].push_back(v);
        arr[v].push_back(u);
    }

    int cc_cnt = 0; 
    for (int i = 1; i <= nodes; i++)
    {
        if (vis[i] == 0)
        {
            dfs(i);
            cc_cnt++;
        }
    }
    if (cc_cnt == 1)
    {
        cout << "This graph is a tree\n";
    }
    else
    {
        cout << "This graph is a tree\n";
    }
    return 0;
}