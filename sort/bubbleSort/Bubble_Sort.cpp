#include <iostream>

using namespace std;

void Bubble_Sort(int arr[], int n){

	int temp;
	bool Swap;

	for(int i=0; i<n; i++){

		Swap = false;

		for(int j=0; j<(n-i-1); j++){

			if(arr[j] > arr[j+1]){
				temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
				Swap = true;		//if swapping takes place, set swap to true
			}
		}
		if(not Swap) break;		//If swapping was not performed, the array is sorted, break from the loop
	}
}

void Print(int arr[], int n){
	for(int i=0; i<n; i++) cout<<arr[i] <<", ";
}

int main(){

	int arr[] = {162, 21, -81, -97, 104, 28, 111, -139, -157, 177}, n=10;
	cout<<"Orignal Array = ";
	Print(arr, n);
	Bubble_Sort(arr, n);
	cout<<"\n Sorted Array = ";
	Print(arr, n);

	cout<<endl;
	return 0;
}
