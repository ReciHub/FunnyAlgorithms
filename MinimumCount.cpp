#include<bits/stdc++.h>
using namespace std;
int minCount (unsigned int n){
	if(sqrt(n) - floor(sqrt(n)) == 0){
		return 1;
	}
	if(n <=3 ){
		return n;
	}
	int res = n;
	for(int i =1 ; i<=n ; i++){
		int temp = i*i;
		if(temp > n){
			break;
		}else{
			res = min(res ,minCount(n-temp)+1);	
		}
	}
	return res;
}
int main(){
	int n;
	cin>>n;
	cout<<minCount(n)<<endl;
	return 0;
}
