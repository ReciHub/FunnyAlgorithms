#include<iostream>
using namespace std;


int main()
{
    int n;
    cin>>n;
    int *arr=(int *)malloc(n*sizeof(int));
    int maxnum=100001;
    int dict[maxnum];
    for(int j=0;j<maxnum;j++)
        dict[j]=0;
    for(int i=0;i<n;i++)
    {
        cin>>arr[i];
        dict[arr[i]]+=1;
        
    }
    int count=0;
    int ele=0;
    for(int j=0;j<maxnum;j++)
    {
        count=dict[j] ;
        ele=j;
        for(int i=0;i<count;i++)
            cout<<ele<<' ';
    }
    //free(dict);
    free(arr);
    return 0;
}
