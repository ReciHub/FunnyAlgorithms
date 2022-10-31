#include <iostream>

using namespace std;

void Bubble_Sort(int arr[], int n){
	//variable names must be lowercased by convention
	int temp;
	bool swapFlag;
	for(int i=0; i<n; i++){

		swapFlag = false;

		for(int j=0; j<(n-i-1); j++){

			if(arr[j] > arr[j+1]){
				temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
				swapFlag = true;		//if swapping takes place, set swap to true
			}
		}
		if(not swapFlag) break;		//If swapping was not performed, the array is sorted, break from the loop
	}
}

void Print(int arr[], int n){
	for(int i=0; i<n; i++) cout<<arr[i] <<", ";
}

int main(){
	cout<<"Enter size of array ->";
	int n;
	cin>>n;
	int arr[n];
	cout<<"Enter "<<n<<" elements of array -> ";
	for(int i=0;i<n;i++) 
		cin>>arr[i];
	cout<<"Orignal Array = ";
	Print(arr, n);
	Bubble_Sort(arr, n);
	cout<<"\n Sorted Array = ";
	Print(arr, n);
	cout<<endl;
	return 0;
}
