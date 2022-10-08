//Reverse Array In-place

#include <bits/stdc++.h>
using namespace std;

void arrReverse(vector<int>& v)
{
    int n=v.size(),tmp;
    for(int i=0;i<=(n/2)-1;i++)
    {
        //Store v[n-1-i] in temporary variable
        //to swap both values at indices i and n-1-i.
        tmp=v[n-1-i];
        v[n-1-i]=v[i];
        v[i]=tmp;
    }
    return ;
}

int main() 
{
    int n;
    cout<<"Enter array size:"<<endl;
    cin>>n;
    vector<int> v(n);
    cout<<"Enter "<<n<<" array values:"<<endl;
    for(int i=0;i<n;i++)
    {
       cin>>v[i];
    }
    arrReverse(v);
    cout<<"Reversed array: ";
    for(int i=0;i<n;i++)
    {
       cout<<v[i]<<" ";
    }
    cout<<endl;
    return 0;
}

