#include<bits/stdc++.h>
#define maxn 100  /// The number right side of that interval [0,maxn] that you want to get the primes
using namespace std;
const int N = 100;
int lp[N+1];
vector<int> pr;
int main(){
for (int i=2; i<=N; ++i) {
    if (lp[i] == 0) {
        lp[i] = i;
        pr.push_back (i);
    }
    for (int j=0; j<(int)pr.size() && pr[j]<=lp[i] && i*pr[j]<=N; ++j)
        lp[i * pr[j]] = pr[j];
}
    for(auto e: pr){
        cout<<e<<" ";
    }
    return 0;
}   