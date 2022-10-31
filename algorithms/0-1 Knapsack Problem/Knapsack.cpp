/**
 * 0-1 Knapsack using DP
 * */
#include<iostream>
#include<algorithm>
using namespace std;

int knap(int N,int W,int wt[],int val[]);

int main(){
    int w[3]={10,20,30};
    int val[3]={60,100,120};
    cout<<knap(3,50,w,val);
}

int knap(int N,int W,int wt[],int val[]){
    int k[N+1][W+1];
    int i,j;

    for (i = 0; i <= N; i++)
    {
        for (j = 0; j <= W; j++)
        {
            if(i==0 || j==0)
                k[i][j]=0;
            
            else if(wt[i-1]<=j){
                k[i][j]= max(k[i-1][j],val[i-1]+k[i-1][j-wt[i-1]]);
            }
            else
            {
                k[i][j]=k[i-1][j];
            }
            
        }
        
    }

/****Print DP table
    for(i=0;i<=N;i++){
        for(j=0;j<=W;j++){
            cout<<k[i][j]<<" ";
        }
        cout<<"--"<<endl;
    }
****/
    return k[N][W];
}