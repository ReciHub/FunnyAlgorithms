#include <stdio.h>
#include <stdlib.h>

#define items 20

int item_vals[items];
int item_weights[items];

int max(int a, int b){
    return (a>b)? a:b;
}

int getKnap(int n, int capacity){
    int arr[n+1][capacity+1];

    for(int i = 0; i<=n; i++)
        arr[i][0] = 0;
    for(int j = 0; j<=capacity; j++)
        arr[0][j] = 0;
    
    for(int i = 1; i<=n; i++){
        for(int j = 0; j<=capacity; j++){
            if(item_weights[i]>j){
                arr[i][j] = arr[i-1][j];
            }
            else{
                arr[i][j] = max(arr[i-1][j], arr[i-1][j-item_weights[i]] + item_vals[i]);
            }
        }
    }

    return arr[n][capacity];
}

int main(){
    int n, capacity;

    printf("Enter number of items: \n");
    scanf("%d", &n);

    printf("Enter values of items: \n");
    for(int i = 0; i<n; i++)
        scanf("%d", &item_vals[i]);
    
    printf("Enter weights of items: \n");
    for(int i = 0; i<n; i++)
        scanf("%d", &item_weights[i]);
    
    printf("Enter Capacity:\n");
    scanf("%d", &capacity);

    printf("Max Knapsack Value: %d\n", getKnap(n, capacity));
    exit(0);
}