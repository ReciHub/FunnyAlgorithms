#include<bits/stdc++.h>
using namespace std;
int LIS (int *arr , int n)
{
    int *t = new int [n];
    int omax = INT_MIN;
    for(int i =0; i < n; i++)
    {   
        int max = 0;
        for(int j =0; j < i; j++)
        {
            if(arr[j] < arr[i])
            {
                if(t[j] > max)
                    max = t[j];
            }
        }
        t[i] = 1 + max;
        if(omax < t[i])
            omax = t[i];

    }
    delete [] t;
    return omax;
}

int main()
{
    int n;
    cout << "Enter the size of Array : ";
    cin >> n;
    int *arr = new int [n];
    cout << "Enter the elements of Array : ";
    for(int i =0; i < n; i++)
        cin >> arr[i];
    
    cout << "Longest Increasing Sequence length : " << LIS(arr , n);
    delete [] arr;
    return 0;

}
