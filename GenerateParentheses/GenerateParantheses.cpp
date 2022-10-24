#include<bits/stdc++.h>
using namespace std;
void solve(int open, int unbal, int n, string s, vector<string> &ans) {
        if (open == n) {
            while (unbal > 0) {
                s += ")";
                unbal--;
            }

            ans.push_back(s);
            return;
        }

        solve(open + 1, unbal + 1, n, s + "(", ans);

        if (unbal > 0) {
            solve(open, unbal - 1, n, s + ")", ans);
        }
    }
vector<string> generateParenthesis(int n) {
       
        vector<string> ans;
        solve(0, 0, n, "", ans);

        return ans;
}
int main(){

    int n;
    cin>>n;

    for(auto i : generateParenthesis(n)){
        for(auto j : i)cout<<j<<" ";
        cout<<endl;
    }

    return 0;

}