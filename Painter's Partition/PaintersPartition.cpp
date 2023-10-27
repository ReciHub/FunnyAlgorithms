#include<bits/stdc++.h>
using namespace std;

int findFeasible(int boards[], int n, int limit){
    int sum=0, painters=1;
    for(int i=0; i<n; i++){
        sum+=boards[i];
        if(sum>limit){
            sum=boards[i];
            //we get a new painter and allocate to him
            painters++; 
        }
    }
    return painters;
}

int paintersPartition(int boards[], int n, int m){
    int totalLength=0, k=0;
    for(int i=0; i<n; i++){
        k=max(k, boards[i]);
        totalLength+=boards[i];
    }

    int low=k , high=totalLength;
    //here just we don't have to store the value in ans. the answer is already in low.
    while(low<high){
        int mid=(low+high)/2;
        int painters=findFeasible(boards, n, mid);
        if(painters<=m){
            high=mid;
        }
        else{
            low=mid+1;
        }
    }
    return low;
}

int main(){
    int arr[]={10, 20, 30, 40};
    int n=4;//number of boards
    int m=2;//number of painters
    cout<<"The minimum time to paint all boards is: "<<paintersPartition(arr, n, m);
    return 0;
}
