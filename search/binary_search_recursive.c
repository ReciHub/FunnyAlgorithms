#include<stdio.h>
#include<time.h>
int bin(int*,int,int,int);
int main(){
    int arr[50],i,key,lim,pos;
    printf("Lim: ");
    scanf("%d",&lim);
    printf("\nEnter elements one by one: \n");
    for(i=0;i<lim;i++)
        scanf("%d",&arr[i]);
    printf("Key: ");
    scanf("%d",&key);
    clock_t begin = clock();
    pos = bin(arr,key,0,lim);
    clock_t end = clock();
    if(pos!=-1)
        printf("%d is found at %dth position\n",key,pos+1);
    else
        printf("%d is not found!\n",key);
    double time_spent = (double)(end-begin)/CLOCKS_PER_SEC;
    printf("Time taken: %lf\n",time_spent);
    return 0;
}
int bin(int arr[],int key,int lim1,int lim2){
    int m;
    if(lim1<=lim2){
        m = (lim1+lim2)/2;
        if(key==arr[m])
            return m;                //Recursive Method
        else if(arr[m]<key)
            return bin(arr,key,m+1,lim2);
        else
            return bin(arr,key,lim1,m);
    }
    return -1;
}

// int bin(int arr[],int key,int lim1,int lim2){
//     int m;
//     while(lim1<=lim2){
//         m = (lim1+lim2)/2;
//         if(arr[m]==key)
//             return m;                   //Non-recursive Method
//         else if(arr[m]<key)
//             lim1 = m+1;
//         else
//             lim2 = m;
//     }
//     return -1;
// }
