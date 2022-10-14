#include<bits/stdc++.h>
using namespace std;
// **************number pyramid pattern******************
int main()
{
    int n, count;
    cout<<"enter the number of rows"<<endl;
    cin>>n;
    for(int i=0; i<=n; i++)
    {
        count=i;
        for (int j = 1; j<=n*2-1; j++)
        {
           if (j<=n-i||j>=n+i)
           {
               cout<<" ";
           }
           else
           {
             cout<<count;
             if (j<n)
             {
              count--;
             }
             else
             {
              count++;
             }
           }
        }
        cout<<endl;
    }
    return 0;
}