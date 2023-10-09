#include <bits/stdc++.h>
using namespace std;
#define sz(arr) ((int) arr.size())
#define len(str) ((int) str.length())
typedef vector<int> vi;

// A substring is a contiguous sequence of characters within a string
// A prefix of a string is a substring that starts at the beginning of the string

// Z Algorithm implementation
// Computes the Z values for a given string 's'
// Z values represent the length of the longest substring starting from position i that matches the prefix of the string
// Time complexity: O(t + p), where t is the length of the concatenated string and p is the length of the pattern
vi z_algorithm(string s){
  int n=len(s),l=0,r=0;
  vi z(n);
  // Iterate through the string to compute Z values
  for(int i=1;i<n;i++){
    z[i]=max(0,min(z[i-l],r-i+1));
    // Extend the Z-box as much as possible
    while(i+z[i]<n && s[z[i]]==s[i+z[i]]){
      l=i;r=i+z[i];++z[i];
    }
  }
  return z;
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  // Example strings
  string t="abababab",p="aba";
  // Concatenate pattern and text with a special character '$'
  vi z=z_algorithm(p+"$"+t);
  // Print positions where the pattern is found in the text
  cout<<"Z Algorithm:\n";
  for(int i=0;i<sz(z);i++){
    if(z[i]==len(p))cout<< i-len(p)-1<<" ";
  }
  cout<<"\n";
  return 0;
}
