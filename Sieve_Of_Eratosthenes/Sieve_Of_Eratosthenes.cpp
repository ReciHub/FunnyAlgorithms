#include<bits/stdc++.h>
#define maxn 100  /// The number right side of that interval [0,maxn] that you want to get the primes
using namespace std;
int is_prime[maxn+5];
vector<int> primes;
void sieve(){
    is_prime[0]=0;
    is_prime[1]=0;
    for(int i = 2;i <= maxn; i++){
        if(is_prime[i]){
            primes.push_back(i);
            for(int j= i * 2;j <= maxn;j+=i){
                is_prime[j]=0;
            }
        }
    }
}
int main(){
    for(int i=0;i<=maxn;i++)is_prime[i] = 1; ///setting that all number is prime
    sieve();
    for(auto e : primes)cout<<e<<" ";
    cout<<endl;
    return 0;
}   