#include <iostream>
using namespace std;

void swap(int* a, int* b) 
{ 
    int t = *a; 
    *a = *b; 
    *b = t; 
} 
  
/* This function takes last element as pivot, places 
   the pivot element at its correct position in sorted 
    array, and places all smaller (smaller than pivot) 
   to left of pivot and all greater elements to right 
   of pivot */
int partition (int arr[], int low, int high) 
{ 
    int pivot = arr[high];    // pivot 
    int i = (low - 1);  // Index of smaller element 
  
    for (int j = low; j <= high- 1; j++) 
    { 
        // If current element is smaller than or 
        // equal to pivot 
        if (arr[j] <= pivot) 
        { 
            i++;    // increment index of smaller element 
            swap(&arr[i], &arr[j]); 
        } 
    } 
    swap(&arr[i + 1], &arr[high]); 
    return (i + 1); 
} 
  
/* The main function that implements QuickSort 
 arr[] --> Array to be sorted, 
  low  --> Starting index, 
  high  --> Ending index */
void quickSort(int arr[], int low, int high) 
{ 
    if (low < high) 
    { 
        /* pi is partitioning index, arr[p] is now 
           at right place */
        int pi = partition(arr, low, high); 
  
        // Separately sort elements before 
        // partition and after partition 
        quickSort(arr, low, pi - 1); 
        quickSort(arr, pi + 1, high); 
    } 
} 

/*
void merge (int array[], int left, int mid, int right){
    
    int i = 0;
    int j = 0; 
    int k;
    int indAux1 = mid - left + 1; 
    int indAux2 =  right - mid; 
  
    int arrayLeft[indAux1], arrayRight[indAux2]; 
  
    while ( i < indAux1 ){
        arrayLeft[i] = array[left + i];
        i += 1;
    } 
         
    while ( j < indAux2 ){
        arrayRight[j] = array[mid + 1 + j]; 
        j += 1;
    }
   
    i = 0; 
    j = 0; 
    k = left; 
    while ( i < indAux1 && j < indAux2 ) { 
        
        if (arrayLeft[i] <= arrayRight[j]){ 
            array[k] = arrayLeft[i]; 
            i++; 
        } else { 
            array[k] = arrayRight[j]; 
            j++; 
        } 
        k++;
    } 
  
    while (i < indAux1) { 
        array[k] = arrayLeft[i]; 
        i++; 
        k++; 
    } 
  
    while (j < indAux2) { 
        array[k] = arrayRight[j]; 
        j++; 
        k++; 
    } 
} 
void mergeSort(int array[], int left, int right) { 
    if ( left < right ){
        
        int mid = left + (right - left)/2;
        mergeSort(array,left,right);
        mergeSort(array,mid + 1,right);
        merge(array,left,mid,right);
    }
}
*/
int main(){
    int process;
    cin >> process;

    if(process==1){
            int inputFloors;
            cin >> inputFloors;

            int build[inputFloors];

            for(int i = 0; i < inputFloors; i += 1){
                cin >> build[i];
            }

            int indexAux = -1;

            if (inputFloors){

                quickSort(build,0,inputFloors-1);
                
                indexAux +=1;

                int i = 0;

                while( i < inputFloors - 1 ){

                    if(i && ((build[i] < 0 && build[i-1] < 0 || build[i] > 0 && build[i-1]>0))){
                        indexAux+=1;
                    }

                    i += 1;
                }

            } 
        
        cout << indexAux << endl;    
    }

    
    else{
            while(process -= 1){
            
            int inputFloors;
            cin >> inputFloors;

            int build[inputFloors];

            for(int i = 0; i < inputFloors; i += 1){
                cin >> build[i];
            }

            int indexAux = -1;

            if (inputFloors){

                quickSort(build,0,inputFloors-1);
                
                indexAux +=1;

                int i = 0;

                while( i < inputFloors - 1 ){

                    if(i && ((build[i] < 0 && build[i-1] < 0 || build[i] > 0 && build[i-1]>0))){
                        indexAux+=1;
                    }

                    i += 1;
                }

            } 
            
            cout << indexAux << endl;
            
        }
    }
    
    return 0;
}