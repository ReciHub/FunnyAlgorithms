#include <iostream>

using namespace std;

void Print(int arr[], int n){
	for(int i=0; i<n; i++) cout<<arr[i] <<", ";
}

void Quick_Sort(int arr[], int s, int e){

	if(e-s > 1){
		int key = e-1;
		int pivot = s-1;
		int temp;

		for(int i=s; i<(e-1); i++){
			if(arr[i] < arr[key]){
				pivot++;
				temp = arr[pivot];
				arr[pivot] = arr[i];
				arr[i] = temp;
			}
		}

		pivot++;
		temp = arr[pivot];
		arr[pivot] = arr[key];
		arr[key] = temp;

		Quick_Sort(arr, s, pivot);
		Quick_Sort(arr, pivot+1, e);
	}
}

int main(){

	int arr[] = {7, 32, -66, 60, -93, 25, -66, -34, 79, -21, -24, -97, -34, 38, -73, -74, 5, 11, 64, 49}, n = 20;

	cout<<"\nOrignal array = ";
	Print(arr, n);

	Quick_Sort(arr, 0, n);

	cout<<"\n Sorted array = ";
	Print(arr, n);

	cout<<endl;

	return 0;
}
