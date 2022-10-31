/*
	This question is of geeksforgeeks
	Link ::  https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays/0
*/

// This program merges two sorted array to a new sorted array without using extra space

#include<bits/stdc++.h>
using namespace std;

void merges(int *a,int *b,int size1,int size2)
{
    int i=0,j=0;
    while(i<size1 && j<size2)
    {
        if(a[i] <= b[j])
        cout<<a[i++]<<" ";

        if(b[j] < a[i])
        cout<<b[j++]<<" ";
    }

    while(i<size1)
        cout<<a[i++]<<" ";
    while(j<size2)
        cout<<b[j++]<<" ";

    return;
}

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n,m;
        cin>>n>>m;
        int a[n],b[m];

        for(int i=0;i<n;i++)
        {
           cin>>a[i];
        }

        for(int i=0;i<m;i++)
        {
            cin>>b[i];
        }

        merges(a,b,n,m);
        
        cout<<"\n";
    }
}
