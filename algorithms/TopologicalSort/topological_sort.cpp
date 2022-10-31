#include <bits/stdc++.h>
using namespace std;

//Complexity O(V+E)

void dfs(int node,vector<int>adj[],int visit[],stack<int>&s1){
	cout<<node<<endl;
	visit[node]=1;
	for(int i=0;i<adj[node].size();i++){
		if(visit[adj[node][i]]==0)
			dfs(adj[node][i],adj,visit,s1);
			
			
	}
	s1.push(node);
	
}

int main(){
	int v,e;
	cin>>v>>e;
	vector<int> adj[v];
	for(int i=0;i<e;i++){
		int source;
		int destination;
		cin>>source>>destination;
		adj[source].push_back(destination);
		
	}

	int visit[v]={0};
	int arr[v];
	stack<int>s1;
	for(int i=0;i<v;i++){
		if(visit[i]==0){
			dfs(i,adj,visit,s1);
			
		}
		
	}
	for(int i=0;i<v;i++){
       int k=s1.top();
       s1.pop();
       arr[i]=k;
       cout<<arr[i]<<endl;
   }

}