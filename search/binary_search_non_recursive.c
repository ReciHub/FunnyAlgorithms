#include<stdio.h>
int binarySearch(int arr[],int min,int max,int x){
    while(max>=min){
        int mid=min+(max-min)/2;
        if(x==arr[mid])
            return mid;
        else if(arr[mid]<x)
            min=mid+1;
        else
            max=mid-1;
    }
    return -1;
}
int main(){
    int arr[100],i,n,x;
    printf("Lim: ");
    scanf("%d",&n);
    for(i=0;i<n;i++){
        printf("Element: ");
        scanf("%d",&arr[i]);
    }
    printf("Searching num: ");
    scanf("%d",&x);
    int res=binarySearch(arr,0,n,x);
    if(res==-1)
        printf("Searched number is not found !\n");
    else
        printf("Searched number is found at index %d\n",res);

    return 0;
}
