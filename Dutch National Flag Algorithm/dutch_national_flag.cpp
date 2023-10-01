// C++ program to sort an array
// with 0, 1 and 2 in a single pass
#include <bits/stdc++.h>
using namespace std;

// Function to sort the input array,
// the array is assumed
// to have values in {0, 1, 2}
void sort012(int a[], int arr_size)
{
	int lo = 0;
	int hi = arr_size - 1;
	int mid = 0;

	// Iterate till all the elements
	// are sorted
	while (mid <= hi) {
		switch (a[mid]) {

		// If the element is 0
		case 0:
			swap(a[lo++], a[mid++]);
			break;

		// If the element is 1 .
		case 1:
			mid++;
			break;

		// If the element is 2
		case 2:
			swap(a[mid], a[hi--]);
			break;
		}
	}
}

// Function to print array arr[]
void printArray(int arr[], int arr_size)
{
	// Iterate and print every element
	for (int i = 0; i < arr_size; i++)
		cout << arr[i] << " ";
}

// Driver Code
int main()
{
	int n;
	cout<<"Please enter size of array"<<endl;
	cin>>n;
	int arr[n];
	cout<<"Elements of array should be either 0, 1 or 2."<<endl;
	for(int i=0;i<n;i++){
		cout<<"Enter "<<i+1<<"th element of the array : "<<endl;
		cin>>arr[i];
	}

	sort012(arr, n);

	printArray(arr, n);

	return 0;
}

//This code is contibuted by Mugdha Kshirsagar
