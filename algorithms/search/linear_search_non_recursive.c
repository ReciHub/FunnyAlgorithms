#include<stdio.h>
#include<time.h>
int lin(int*,int,int);
int main(){
    int arr[50],i,key,lim,pos;
    printf("Enter lim: ");
    scanf("%d",&lim);
    printf("Enter elements one by one\n");
    for(i=0;i<lim;i++)
        scanf("%d",&arr[i]);
    printf("Key: ");
    scanf("%d",&key);
    clock_t begin = clock();
    pos = lin(arr,key,lim);
    clock_t end = clock();
    if(pos!=-1)
        printf("%d is found at %d position\n",key,pos+1);
    else
        printf("%d is not found!\n",i);
    double time_spent = (double)(end-begin)/CLOCKS_PER_SEC;
    printf("Time taken: %lf\n",time_spent);
    return 0;
}
// int lin(int arr[],int key,int lim){
//     int i;
//     for(i=0;i<lim;i++)       //Non-Recursive method
//         if(key==arr[i])
//             return i;
//     return -1;
// }
