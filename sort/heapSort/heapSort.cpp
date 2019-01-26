#include <iostream>

using namespace std;

#define Child(i, pos)  2*i+pos

void Max_Heapify(int Heap[], int i, int Len){

	int Left_Child = Child(i, 1);		//1 to indicate Left Child
	int Right_Child = Child(i, 2);		//2 to indicate Right Child
	int temp, Largest = i;

	//Find the largest element among the Root, Left child and Right child
	if(Left_Child < Len and Heap[Left_Child] > Heap[i]) Largest = Left_Child;
	if(Right_Child < Len and Heap[Right_Child] > Heap[Largest]) Largest = Right_Child;

	//if root is not the largest, Swap root with largest and Heapify again
	if(Largest != i){
		temp = Heap[Largest];
		Heap[Largest] = Heap[i];
		Heap[i] = temp;
		Max_Heapify(Heap, Largest, Len);
	}

}

void Build_Max_Heap(int Heap[], int N){

	for(int i=(N/2)-1; i>=0; i--)
		Max_Heapify(Heap, i, N);

}

void Print(int Heap[], int N){
	for(int i=0; i<N; i++) cout<<Heap[i] <<", ";
}

void Heap_Sort(int Heap[], int N){

	int temp;

	Build_Max_Heap(Heap, N);		//Build Heap
	for(int i=0; i<N; i++){
		temp = Heap[0];		//Swap Root Of Heap with the last element
		Heap[0] = Heap[N-i-1];
		Heap[N-i-1] = temp;
		Max_Heapify(Heap, 0, N-i-1);  //Heapify again from root, reduce length to ignore the last (sorted) elements in array
	}
}

int main(){

	int Heap[] = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7}, N=16;
	cout<<"Orignal array = ";
	Print(Heap, N);		//Print Orignal Array
	Heap_Sort(Heap, N);		//Heap Sort
	cout<<"\n Sorted array = ";
	Print(Heap, N);		//Print Sorted Array
	cout<<endl;
}
