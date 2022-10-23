#include <bits/stdc++.h>
using namespace std;

class Ponto{
    public:
    double x;
    double y;
    int moeda;
    Ponto(){
        x = 0;
        y = 0;
        moeda = 0; 
    }
};

void bellmanFordPorFavorPega(vector <pair <int, double>> G[], int s, int N){
    int distancia[N][N];
    int percusores[N];
    int caminho[N];
    for (int i = 0; i < N; i++){
        percusores[i] = -1;
    }
    for (int i = 0; i < N; i++){
        if (i==1) break;
        for (int j = 0; j < N; j++){
            if (j==0){
                distancia[i][j] = 0;
                continue;
            }
            distancia[i][j] = INT_MAX;
        }
    }
    for (int k = 1; k < N; k++){
        for (int i = 0; i < N; i++){
            distancia[k][i] = distancia[k-1][i];
        }        
        for (int u = 0; u < N; u++){
            for (int e = 0; e < G[u].size(); e++){
                int v = G[u][e].first;
                double w = G[u][e].second;
                if ((distancia[k-1][u] + w) < distancia[k][v]){
                    distancia[k][v] = (distancia[k-1][u] + w);
                    percusores[v] = u;
                }
            }
        }
    }    
    for (int k = N-1; k < N; k++){
        for (int i = 0; i < N; i++){
            distancia[k][i] = distancia[k-1][i];
        }        
        for (int u = 0; u < N; u++){
            for (int e = 0; e < G[u].size(); e++){
                int v = G[u][e].first;
                double w = G[u][e].second;
                if ((distancia[k-1][u] + w) < distancia[k][v]){
                    cout << "LOOP" << endl;
                    return;
                }
            }
        }
    }  
    int count = 0;
    for (int i = N-1; i > 0;){
        caminho[count] = i;
        i = percusores[i];
        count++;
    }
    cout << distancia[N-1][N-1] << " ";
    for (int i = count; i >= 0; i--){
        if (i==count){
            cout << "0 ";
            continue;
        }
        if (i==0){
            cout << caminho[i];
            break;
        }
        cout << caminho[i] << " "; 
    }
    cout << endl;
}

double calcularEnergia(Ponto i, Ponto f){
    double e;
    e = pow((i.x-f.x), 2) + pow((i.y-f.y), 2);
    return e;
}

void printTemp(Ponto temp[], int N){
    for (int i = 0; i < N; i++){
        cout << "VERTICE " << i << " -> ";
            cout << temp[i].x << " " << temp[i].y
            << " " << temp[i].moeda;
        cout << endl;
    }
}

void printG(vector <pair <int, double>> G[], int N){
    for (int i = 0; i < N; i++){
        cout << "VERTICE " << i << " -> ";
        for (int j = 0; j < G[i].size(); j++){
            cout << G[i][j].first << " " << G[i][j].second
            << " ";
        }
        cout << endl;
    }
}
int main(){
    int teste;
    cin >> teste;
    while (teste--){
        int N;
        cin >> N;
        Ponto temp[N];
        for (int i = 0; i < N; i++){
            cin >> temp[i].x >> temp[i].y;

        }
        vector <pair <int, double>>  G[N];
        int qtd_moedas;
        cin >> qtd_moedas;
        int aux;
        for (int i = 0; i < qtd_moedas; i++){
            cin >> aux;
            temp[aux].moeda = true;
        }
        
        int qtd_e;
        for (int i = 0; i < N; i++){
            cin >> qtd_e;
            for (int j = 0; j < qtd_e; j++){
                int aresta;
                cin >> aresta;
                if (temp[aresta].moeda){
                    double negativo = calcularEnergia(temp[i], temp[aresta]);
                    negativo *= -1;
                    G[i].push_back({aresta, negativo});
                }
                else{
                    G[i].push_back({aresta, calcularEnergia(temp[i], temp[aresta])});
                }
            }
        }
        bellmanFordPorFavorPega(G, 0, N);
    }
}