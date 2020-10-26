#include <bits/stdc++.h>
using namespace std;

int partitionArr(int *a,int s,int e){

    int pivot = a[e];

    int i=s-1;

    for(int j = s;j<e;j++){
        if(a[j]<pivot){
            i++;
            swap(a[j],a[i]);
        }
    }
    swap(a[e],a[i+1]);

    return i+1;
}



void quickSort(int a[],int s,int e){

    if(s>=e){
        return;
    }

    int c = partitionArr(a,s,e);

    quickSort(a,s,c-1);
    quickSort(a,c+1,e);

}



int main(){

    int n;
    cin>>n;

    int a[n];

    for(int i=0;i<n;i++){
        cin>>a[i];
    }

    quickSort(a,0,n-1);

    for(int i=0;i<n;i++){
        cout<<a[i]<<" ";
    }



    return 0;
}
