#include <iostream>

using namespace std;

void selectionSort(int array[], int size) { 
    int i = 0; 
    int j;
    int min;

    while(i < size-1) { 
        min = i; 
        j = i+1;

        while (j < size){
            if (array[j] < array[min]){
                min = j;
            }
            j += 1; 
        }

        int temp = array[min]; 
        array[min] = array[i]; 
        array[i] = temp;

        i += 1; 
    } 
} 

int main(){
	int size;   
    int array[size];
    while(cin >> size){//recebendo tamanho do array
        int cont = 0;
        while(cont < size){
            cin >> array[cont];//colocando no array os dados
            cont += 1;
        }

        selectionSort(array,size);//ordenando

        int valor;
        cin >> valor; //valor pedido

        int respost;//resp temporaria
        int indexAux = size - 1;//ultima posicao do arrayay ja ordenado

        for(cont = 0; cont < indexAux; cont += 1){//comparando com a primeira posicao
            for(indexAux = size - 1; indexAux > cont; indexAux -= 1){//comparando com a ultima posicao
                if (array[cont] + array[indexAux] == valor){ //se a soma das posicoes for igual ao meu valor
                    respost = array[cont]; //pego valor menor da primeira posicao
                    indexAux -= 1;//garantindo se ha menor valor que satisfaca a condicao
                    break;
                } else if (array[cont] + array[indexAux] < valor){//se a soma for menor, paro e volto
                    break;
                }
            }
        }

        int giveRespost = abs(valor - respost);
            cout << "Peter should buy books whose prices are ";
            cout << respost;
            cout << " and ";
            cout << giveRespost;
            cout << ".\n" << endl;
    }   
return 0;
}