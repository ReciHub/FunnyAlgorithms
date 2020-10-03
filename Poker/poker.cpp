/*Made by Shivam Solanki*/
#include<bits/stdc++.h>
#pragma GCC optimize ("Ofast")
using namespace std;
#define DEBUG(x) cout << '>' << #x << ':' << x << endl;
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

int ans=0;
vi value(14),suit(5);

vi preprocess(vector<string>&x){
    vi val;
    rep(i,0,14){
        value[i]=0;
    }
    rep(i,0,4){
        suit[i]=0;
    }
    rep(i,0,5){
        bool f=0;
        string a=x[i];
        //Value of numbers
        if(a[0]=='T'){
            value[9]++;
        }
        if(a[0]=='J'){
            value[10]++;
        }
        else if(a[0]=='Q'){
            value[11]++;
        }
        else if(a[0]=='K'){
            value[12]++;
        }
        else if(a[0]=='A'){
            value[13]++;
        }        
        else{
            value[a[0]-'1']++;
        }
        //Heart Spades Club Diamond
        if(a[1]=='H'){
            suit[0]++;
        }
        if(a[1]=='S'){
            suit[1]++;
        }
        if(a[1]=='C'){
            suit[2]++;
        }
        if(a[1]=='D'){
            suit[3]++;
        }
    }
    val=value;
    // rep(i,0,14){
    //     cout<<value[i]<<' ';
    // }
    // cout<<'\n';
    return val;
}

int onepair(){
    rep(i,0,14){
        if(value[i]>=2)
            return 1;
    }
    return 0;
}

int twopair(){
    int ctr=0;
    rep(i,0,14){
        if(value[i]>=2){
            ctr++;
        }
    }
    return(ctr>=2?2:0);
}

int threeofakind(){
    rep(i,0,14){
        if(value[i]>=3){
            return 3;
        }
    }
    return 0;
}

int straight(){
    rep(i,0,9){
        int ctr=0;
        if(value[i]!=0){
            rep(j,i,i+5){
                if(value[j]!=0)
                    ctr++;
            }
            if(ctr==5){
                return 4;
            }
        }
    }
    return 0;
}

int flush(){
    rep(i,0,4){
        if(suit[i]==5)
            return 5;
    }
    return 0;
}

int fullhouse(){
    return ((onepair() and threeofakind())?6:0);
}

int fourofakind(){
    rep(i,0,14){
        if(value[i]>=4){
            return 6;
        }
    }
    return 0;
}

int straightflush(){
    rep(i,0,9){
        int ctr=0;
        if(value[i]!=0){
            rep(j,i,i+5){
                if(value[j]!=0 and suit[j]==suit[i])
                    ctr++;
            }
            if(ctr==5){
                return 7;
            }
        }
    }
    return 0;
}

int royalflush(){
    if(value[10]>=1 and value[11]>=1 and value[12]>=1 and value[13]>=1 and (suit[0]==5 or suit[1]==5 or suit[2]==5 or suit[3]==5)){
        return 8;
    }
    return 0;
}

int pr(vector<string>&x){
    preprocess(x);
    return max({onepair(),twopair(),threeofakind(),straight(),flush(),fullhouse(),fourofakind(),straightflush(),royalflush()});
}

void solve(){
    vector<string>p1(5),p2(5);
    rep(i,0,5){
        cin>>p1[i];
    }
    rep(i,0,5){
        cin>>p2[i];
    }
    vi v1,v2;
    v1=preprocess(p1);
    v2=preprocess(p2);
    int a=pr(p1),b=pr(p2);
    // swap(a,b);
    // swap(v1,v2);
    // rep(i,0,14){
    //     cout<<v1[i]<<' ';
    // }
    // cout<<'\n';
    // rep(i,0,14){
    //     cout<<v2[i]<<' ';
    // }
    // cout<<'\n';
    // cout<<a<<' '<<b<<'\n';
    if(a>b){
        ans++;
    }
    if(a==b){
        if(a==1 or a==2){
            repr(i,0,13){
                if(v1[i]>=2 and v1[i]>v2[i]){
                    ans++;
                    return;
                }
                else if(v2[i]>=2 and v1[i]<v2[i]){
                    return;
                }
            }
        }
        else if(a==3){
            repr(i,0,13){
                if(v1[i]>=3 and v1[i]>v2[i]){
                    ans++;
                    return;
                }
                else if(v2[i]>=3 and v1[i]<v2[i]){
                    return;
                }
            }
            repr(i,0,13){
                if(v1[i]>=2 and v1[i]>v2[i]){
                    ans++;
                    return;
                }
                else if(v2[i]>=2 and v1[i]<v2[i]){
                    return;
                }
            }
        }
        else if(a==6){
            rep(i,0,13){
                if(v1[i]>v2[i] and v1[i]>=4){
                    ans++;
                    return;
                }
                else if(v2[i]>v1[i] and v2[i]>=4){
                    return;
                }
            }
        }
        else{
            repr(i,0,13){
                // cout<<v1[i]<<' '<<v2[i]<<'\n';
                if(v1[i]>v2[i]){
                    ans++;
                    return;
                }
                else if(v2[i]>v1[i]){
                    return;
                }
            }
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
    cin>>t;
    while(t--)
        solve();
    return 0;
}
