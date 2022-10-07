#include <bits/stdc++.h>
using namespace std;

void cyclicSort(vector<int>& arr)
{
    int n=arr.size();
    int i = 0;
    while(i < n)
    {
        int correct = arr[i] - 1 ;
	    if(arr[i] != arr[correct])
	    {
	        swap(arr[i], arr[correct]) ;
	    }
	    else{
	        i++ ;
	    }
    }
}

void printArray(vector<int> arr)
{
  int size=arr.size();
  for (int i = 0; i < size; i++)
  {
	 cout << arr[i] << " ";
  }
  cout<<endl;
}

int main()
{
   int n;
   cin>>n;//Size of array
   vector<int> v(n);
   for(int i=0;i<n;i++)
   {
       cin>>v[i];//Input Array elements
   }
   cyclicSort(v);//Cyclic sort function
   cout<<"Printing sorted array:"<<endl;
   printArray(v);//Printing Sorted array
   return 0;
}

