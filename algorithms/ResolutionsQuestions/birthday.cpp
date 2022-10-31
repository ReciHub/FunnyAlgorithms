#include <iostream>

using namespace std;

int main(){
	int input; 
	cin >> input; 
    
    int size[input];
    int sizeInput;

    int cont = 0;
    while(cin >> sizeInput){
        size[cont] = sizeInput;
        cont+=1;
        if (cont == input) {
            break;
        }
    }

    int index = 1;
    int inOrder;
    int index2; 

    while ( index < input ) { 
        inOrder = size[index]; 
        index2 = index - 1; 

        while (index2 >= 0 && size[index2] > inOrder) { 
            size[index2 + 1] = size[index2]; 
            index2-=1; 
        } 

        size[index2 + 1] = inOrder;
        index+=1;
    }


	for(int i = 0; i < input; i +=2){
        cout << size[i] << " ";
    }

	int numberPair =((input % 2) == 0);
	if(numberPair){ 
        int removeHouseForCheck = input-1;
        int aux = (removeHouseForCheck);
        
        while( aux >= 0 ){
            cout << size[aux];
            cout << " ";
            aux-=2;
        }

    }else{ 
        int removeHouseForCheck2 = (input-2);
        int aux = (removeHouseForCheck2);
        
        while( aux > 0 ){
            cout << size[aux];
            cout << " ";
            aux-=2;
        }
    }
	return 0;
} 
