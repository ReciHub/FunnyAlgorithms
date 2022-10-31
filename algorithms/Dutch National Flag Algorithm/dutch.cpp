//sort array of 0,1,2
#include<iostream>
using namespace std;
void sort(int arr[],int n){
    int lo=0;
    int hi-n-1;
    int mid=0;
    while(mid<=hi){
     switch(arr[mid]){
        case 0:swap(arr[0],arr[mid]);
        lo++;
        mid++;
        break;
        case 1:mid++;
        break;
        case 2:swap(arr[mid],arr[high]);
        hi--;
        break;
     }
    }
}