/*
	Algoritmo para encontrar a menor distância entre dois pontos num grafo
*/
#include <bits/stdc++.h>
using namespace std;

#define NODES 10
#define INF 1e8

typedef pair<int, int> ii;

// pair<distância, vértice>
vector<ii> graph[NODES];
int D[NODES], visit[NODES];

// implementação de uma min_heap
priority_queue<ii, vector<ii>, greater<ii> > min_heap;

void dijkstra(int v){
	D[v] = 0; // d(v, v) = 0
	min_heap.push(ii(0, v));
	
	while(!min_heap.empty()){
		ii now = min_heap.top();
		min_heap.pop();
		
		// nó visitado
		visit[now.second] = 1;
		
		// olha todos os nós adjacentes
		for(int i = 0; i < graph[now.second].size(); i++){
			ii next = graph[now.second][i];

			if(visit[next.second] == 0){ // caso o nó ainda não tenha sido visitado
				// olha se a distância partindo de now.second é menor do que a distância anterior do array D[]
				if(D[next.second] > D[now.second] + next.first){
					D[next.second] = D[now.second] + next.first;
				
					min_heap.push(ii(D[next.second], next.second)); // coloca o nó na min_heap
				}
			}
		}
	}
}


int main(){
  for(int i = 0; i < SizeNodes; i++) // atribui infinito para todas as distâncias
  	D[i] = INF;
	
  // chama dijkstra com o nó de saída e encontra a menor distância para qualquer nó do array D[]
  // dijkstra(initialNode);
  // cout << D[arrivalNode] << endl;

return 0;
}