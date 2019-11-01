#include <bits/stdc++.h>
#define MAX 100001

int ar[MAX];

using namespace std;


void merge(int left, int mid, int right){
	
	int p = 0;
	int i = left;
	int j = mid + 1;
	int aux[right - left + 1];
	
	while(i <= mid && j <= right){
		if(ar[i] <= ar[j]){
			aux[p] = ar[i];
			i += 1;
		}
		else{
			aux[p] = ar[j];
			j += 1;
		}
		p += 1;
	}
	
	while(i <= mid){
		aux[p] = ar[i];
		i += 1;
		p += 1;
	}
	while(j <= right){
		aux[p] = ar[j];
		j += 1;
		p += 1;
	}
	
	for(int k = left; k <= right; k++){
		ar[k] = aux[k - left];
	}
}

void mergesort(int left, int right){
	if(left < right){
		int mid = (left + right)/2;
		mergesort(left, mid);
		mergesort(mid + 1, right);
		merge(left, mid, right);
	}
}

int main(){
	
	int len;
	cin >> len;

	for(int i = 0; i < len; i++){
		cin >> ar[i];
		cout << len << endl;
		cout << i << endl;
	}
	
	mergesort(0, len-1);
	
	for(int i = 0; i < len; i++){
		cout << ar[i] << " ";
	}
}

