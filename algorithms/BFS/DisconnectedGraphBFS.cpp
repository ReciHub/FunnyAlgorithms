#include<iostream>
#include<queue>
using namespace std;

void printBFS(int **edges , int n , int sv , bool *visited){
    queue <int> pendingVertices;
    pendingVertices.push(sv);
    visited[sv] = true;
    while(pendingVertices.empty() == false){
        int currVertex = pendingVertices.front();
        pendingVertices.pop();
        cout << currVertex << " ";
        for(int i =0 ; i < n ; i++){
            if(edges[currVertex][i] == 1 && visited[i] == false){
                pendingVertices.push(i);
                visited[i] = true;
            }
                
        }
    }
}

void BFS(int **edges , int n){
    bool *visited = new bool [n];
    for(int i =0; i < n ; i++)
        visited[i] = false;
    
    for(int i =0; i < n ; i++){
        if(visited[i] == false){
            printBFS(edges,n,i,visited);
        }
    }
    delete [] visited;
}

int main()
{
    int n,e;
    cin>>n>>e;
    int **edges = new int *[n];
    for(int i =0; i < n ; i++){
        edges[i] = new int [n];
        for(int j =0; j < n ; j++){
            edges[i][j] = 0;
        }
    }

    for(int i = 0; i < e ; i++){
        int f,s;
        cin >> f >> s;
        edges[f][s] = edges[s][f] = 1;
    }
    BFS(edges , n);
    for(int i =0; i < n ;i++)
        delete [] edges[i];
    
    delete [] edges;
    return 0;
}