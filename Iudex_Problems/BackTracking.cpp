#include <iostream>
using namespace std;

class Compra{
    public:
    int tam;
    int minimo_itens;
    int itens;
    int Q;
    int cont;
    int *preco;
    Compra(){
        cont = 0;
        itens = 0;
    };
    void backtracking(int posicao, int somatorio){
        if (tam==posicao){
            return;
        }
        if (somatorio+preco[posicao]<=Q){
            itens++;
            if (itens>=minimo_itens){
                cont++;
            }
            backtracking(posicao+1, somatorio+preco[posicao]);
            itens--;
        }
        backtracking(posicao+1, somatorio);
    }
};

int main(){
    int casos, iterador = 0;
    cin >> casos;
    while (casos){   
        Compra compra;
        int pos = 0, somatorio= 0, valor;
        cin >> compra.tam;
        compra.preco = new int[compra.tam];
        for (int i = 0; i < compra.tam; i++){
            cin >> valor;
            compra.preco[i] = valor;
        }
        cin >> compra.minimo_itens >> compra.Q;
        if (compra.minimo_itens==0){
            compra.cont = 1;
        }
        compra.backtracking(pos, somatorio);
        cout << "caso " << iterador << ": " << compra.cont;  
        casos--;
        iterador++;
        cout << endl;
    }
}