#include<iostream>
using namespace std;
  int celebrity(vector<vector<int> >& M, int n) 
    {
        
        stack<int>s;
        for(int i=0;i<n;i++){s.push(i);}
        while(s.size()>1){
            int a=s.top();
            s.pop();
            int b=s.top();
            s.pop();
            if(M[a][b]==1){s.push(b);}
            else{s.push(a);}
        }
        int candidate=s.top();
        int rows=0;
        int col=0;
        for(int i=0;i<n;i++){
            if(M[candidate][i]==0){rows++;}
            if(M[i][candidate]==1){col++;}
        }
        if(rows==n&&col==n-1){return candidate;}
        return -1;
        
    }