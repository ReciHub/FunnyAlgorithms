#include <bits/stdc++.h>
using namespace std;
int findMax(int arr[], int n)
{
    int i,max=arr[0],cnt=0;
    for(i=1;i<n;i++)
    {
        if(arr[i]>max)
            max=arr[i];
    }
    while(max>0)
    {
        cnt++;
        max=max/10;
    }
   
    return cnt;
}

void bucketSort(int arr[],int *bucket[],int n)
{
    static int i,j[10],k,l,d=1;
    int c;
    c=findMax(arr,n);
  
    for(int m=0;m<c;m++)
    {
        for(i=0;i<10;i++)
            j[i]=0;
        for(i=0;i<n;i++)
        {
            k=(arr[i]/d)%10;
            bucket[k][j[k]]=arr[i];
            j[k]++;
        }
     
        l=0;
        for(i=0;i<10;i++)
        {
            for(k=0;k<j[i];k++)
            {
                arr[l]=bucket[i][k];
                l++;
            }
        }
        d*=10;
    }
}
int main()
{
    int n,*arr,i;
    int *bucket[10];
    cout<<"Enter no of element : ";
    cin>>n;
    arr=new int[n+1];
    for(i=0;i<10;i++)
        bucket[i]=new int[n];
    cout<<"Enter array element : ";
    for(i=0;i<n;i++)
        cin>>arr[i];
    bucketSort(arr,bucket,n);
   
    cout<<"Sorted array : ";
    for(i=0;i<n;i++)
        cout<<arr[i]<<" ";
    return 0;
}
