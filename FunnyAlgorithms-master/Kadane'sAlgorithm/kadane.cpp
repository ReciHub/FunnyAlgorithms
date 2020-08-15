#include <iostream>
#include<vector>
using namespace std;

int maxArrSum(vector<int>arr, int n)
{
	int currMax = arr[0];
	int maxSoFar = arr[0];

	for(int i=1;i<n;i++)
	{
		currMax = max(arr[i], currMax+arr[i]);
		maxSoFar = max(currMax, maxSoFar);
	}
	return maxSoFar;
}
int main() 
{
	int n;

	vector<int> arr(1000);
	cin>>n;
	for(int i=0;i<n;i++)
	{
		cin>>arr[i];
	}
	cout<<maxArrSum(arr, n);
}