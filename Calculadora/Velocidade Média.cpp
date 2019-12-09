#include<bits/stdc++.h>

using namespace std;

void resultado1();

int main(){
    double dUm, dDois, tempoUm, tempoDois, resultado;

    cout << "Posição Inicial: ";
    cin >> dUm;

    cout << "Posição Final: ";
    cin >> dDois;

    cout << "Tempo Inicial: ";
    cin >> tempoUm;

    cout << "Tempo FInal: ";
    cin >> tempoDois;

    resultado1();
}

void resultado1(){
    double resultado, dDois, dUm, tempoUm, tempoDois;
    resultado = (dDois - dUm) / (tempoDois - tempoUm);

    cout << resultado;
};
