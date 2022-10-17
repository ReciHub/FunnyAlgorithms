#include <iostream>
#include<queue>
using namespace std;

bool hasPath(int **edge,int n,int s,int e){
    if(s==e)
        return true;
    bool *visited=new bool[n];
    for(int i=0;i<n;i++){
        visited[i]=false;
    }
    queue<int> q;
    q.push(s);
    visited[s]=true;
    while(q.size()){
        int a = q.front();
        q.pop();
        for(int i=0;i<n;i++){
            if(edge[a][i] && !visited[i]){
                if(i==e){
                delete [] visited;
                return true;
            }
                q.push(i);
                visited[i]=true;
            }
        }
    }
    delete [] visited;
    return false;
}

int main() {
    
   int v,e;
    cout<<"Enter no.of vertices and edges : ";
    cin>> v >> e;
    int **edges = new int *[v];
    for(int i =0; i < v; i++){
        edges[i] = new int [v];
        for(int j =0; j < v ; j++){
            edges [i][j] = 0;
        }
    }
    cout<<"Enter the edges : ";
    for(int i =0; i < e ; i++){
        int v1,v2;
        cin>>v1>>v2;
        edges[v1][v2] = edges[v2][v1] = 1;
    }  
    
    cout << "Enter the vertices for which you want to check path : ";
    int st,en;
    cin>>st>>en;
     
    if(hasPath(edges,v,st,en)==true){
        cout<<"Yes, Exists!!";
    }
    else{
        cout<<"No!!";
    }

    for(int i = 0; i < v; i++){
            delete [] edges[i];

        delete [] edges;
    }
}
