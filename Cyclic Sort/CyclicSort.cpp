#include<iostream>
using namespace std;
void cyclicSort(int &arr[],int n){
    int i=0;
    while(i<n){
        int correct=arr[i]-1;
        if(arr[i]!=correct){
            swap(arr[i],arr[correct]);
        }
        else{i++;}
    }
}