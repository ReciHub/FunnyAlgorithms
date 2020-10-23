#include<bits/stdc++.h>
using namespace std;

int main(){
    long long int n,temp,temp2,c=0;
    cin>>n;
    vector<pair<int,int>> v;
    for(int i=0;i<n;i++){
        cin>>temp>>temp2;
        v.push_back(make_pair(temp2,temp));         //.first is b[i] and .second is a[i]
    }
    sort(v.begin(),v.end());
    // for(int i=0;i<n;i++)
    //     cout<<v[i].second<<" "<<v[i].first<<endl;
    vector<int> points;
    points.push_back(v[0].first);
    int i=1,j=0;
    while(i<n){
        if(points[j]<v[i].second){
            points.push_back(v[i].first);
            j++;
        }
        i++;
    }
    cout<<points.size()<<endl;
    for(auto k:points)
        cout<<k<<" ";
    return 0;
}
