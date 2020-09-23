#include<bits/stdc++.h>
using namespace std;
int minCount_dp (int n){
	int *ans = new int [n+1];		
	//base cases
	ans[0] = 0; ans[1] = 1; ans[2] = 2; ans[3] = 3;
	
	for(int i =4; i <= n ; i++){
		// Every no. initially is represented as sum of squares of 1
		ans[i] = i;
		for(int j = 1; j <= ceil(sqrt(i)); j++){
			int temp = j*j;
			if(temp > n){
				break;
			}else{
				ans[i] = min(ans[i] , 1 + ans[i-temp]);
			}		
		}
	}
	int res = ans[n];
	delete [] ans;
	return res;
}
int main(){
	int n;
	cin>>n;
	cout<<minCount_dp(n)<<endl;
	return 0;
}
