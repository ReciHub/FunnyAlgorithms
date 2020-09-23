#include<bits/stdc++.h>
using namespace std;

void printBFS (int **edges , int n , int sv){
    queue<int> pendingVertices;
    bool *visited = new bool [n];
    for(int i =0; i < n ; i++){
        visited[i] = false;
    }
    pendingVertices.push(sv);
    visited[sv] = true;
    while(pendingVertices.empty() == false){
        int currentVertex = pendingVertices.front();
        pendingVertices.pop();
        cout << currentVertex <<" ";
        for(int i = 0; i < n ; i++){
            if(edges[currentVertex][i] == 1 && visited[i] == false){
                pendingVertices.push(i);
                visited[i] = true;
            }
        }

    }
    delete [] visited;
}

int main()
{
    int n,e;
    cin>>n>>e;
    int **edges = new int *[n];
    for(int i = 0; i < n ; i++){
        edges[i] = new int [n];
        for(int j = 0; j < n ; j++){
            edges[i][j] = 0;
        }
    }
   
    for(int i = 0; i < e ; i++){
        int f,s;
        cin>>f>>s;
        edges[f][s] = edges[s][f] = 1;
    }
    printBFS(edges , n , 0);
    for(int i =0; i < n ; i++){
        for (int j = 0; j < n; j++){
            delete [] edges[j];
        }
        delete [] edges;
    }
}
