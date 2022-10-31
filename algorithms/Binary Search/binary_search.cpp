#include <iostream> 
using namespace std;

int binarySearch(int a[], int l, int r, int x);

int main()
{
    int n;
    cin >> n;
    int a[n];
    for(int i = 0; i < n; i++)
        cin >> a[i];
    int x;
    cin >> x;
    int result = binarySearch(a, 0, n - 1, x);
    if(result == -1)
        cout << "Not found";
    else
        cout << "Found";
    return 0;
}
int binarySearch(int a[], int l, int r, int x) 
{ 
    if (r >= l) { 
        int mid = l + (r - l) / 2; 
  
        
        if (a[mid] == x) 
            return mid; 
  
        
        if (a[mid] > x) 
            return binarySearch(a, l, mid - 1, x); 
   
        return binarySearch(a, mid + 1, r, x); 
    }   
    return -1; 
} 