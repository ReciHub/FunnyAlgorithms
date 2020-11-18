/*Made by Shivam Solanki*/
#include<bits/stdc++.h>
#pragma GCC optimize ("Ofast")
using namespace std;
#define DEBUG(x) cerr << '>' << #x << ':' << x << endl;
#define ll long long int
#define endl '\n'
typedef vector<int> vi;
typedef vector<ll> vll;
typedef vector<vll> vvl;
typedef pair<int,int> pii;
typedef pair<ll,ll> pll;
typedef vector<vi> vvi;
typedef vector<bool> vb;
typedef vector<pii> vp;
typedef vector<pll> vpll;
typedef map<int,int> mii;
typedef map<ll,ll> mll;
typedef set<int> sii;
typedef set<ll> sll;
typedef queue<int> qii;
typedef priority_queue<int> pq;
typedef unordered_map<int,int> umii;
typedef unordered_map<ll,ll> umll;
#define all(x) x.begin(),x.end()
#define rep(i,k,n) for (int i = k; i < n; ++i) 
#define repr(i,k,n) for (int i = n; i>=k; --i)
#define repll(i,k,n) for (ll i = k; i < n; ++i) 
#define pb push_back
#define mp make_pair
#define gcd __gcd
#define F first
#define S second
#define fastio ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
const int INF = 1e9+5;
const int MOD = 1e9+7;
double pi = 2 * acos(0.0); 

//Question Link https://codeforces.com/problemset/problem/435/C

void solve(){
    int n;
    cin>>n;
    vi a(n);
    int sm=0;
    rep(i,0,n) cin>>a[i],sm+=a[i];
    vector<string>canvas;
    int mx=0,my=INF,ss=0;
    rep(i,0,n){
        if(i&1) ss-=a[i];
        else ss+=a[i];
        mx=max(ss,mx);
        my=min(ss,my);
        // cout<<mx<<' '<<my<<'\n';
    }
    int s=abs(mx)+abs(my);
    // cout<<s<<'\n';
    rep(i,0,2*s){
        string test="";
        rep(i,0,sm){
            test+=" ";
        }
        canvas.pb(test);
    }
    int x=mx,y=0;
    rep(i,0,n){
        if(i&1){
            rep(j,0,a[i]) canvas[++x][y++]=(char)(92);
        }
        else{
            rep(j,0,a[i]) canvas[x--][y++]=(char)(47);
        }
    }    
    rep(i,0,2*s){
        bool f=0;
        rep(j,0,sm){
            if(canvas[i][j]!=' '){
                f=1;
                break;
            }
        }
        if(f){
            cout<<canvas[i];
            cout<<'\n';
        }
    }    
}

int main(){ 
    // #ifndef ONLINE_JUDGE  
        // freopen("input.txt", "r", stdin); 
        // freopen("output.txt", "w", stdout); 
    // #endif 
    fastio;
    int t=1;
    // cin>>t;
    while(t--)
        solve();
    return 0;
}
