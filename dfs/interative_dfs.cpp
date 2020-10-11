/*
    Algoritmo que realiza busca exaustiva num grafo, começando por um vértice inicial v e visitando
    o máximo possivel seu ramo até retroceder para visitar outro ramo até que todos os vértices tenham
    sido visitados
*/
#include <bits/stdc++.h>
using namespace std;

#define NODES 10

vector<int> adj[NODES];
int visit[NODES];

void dfs(int v){
	stack<int> pilha;
	pilha.push(v);

	while(!pilha.empty()){
		int now = pilha.top();
		pilha.pop();

		visit[now] = 1;

		for(int i = 0; i < adj[now].size(); i++){
			int next = adj[now][i];

			if(visit[next] == 0)
				pilha.push(next);
		}
	}
}

int main(){
	 dfs(initialNode);
}
