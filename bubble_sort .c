#include <stdio.h>

int main() {
	//code
	int n;
	scanf("%d",&n);
	int a[n];
	for(int i=0;i<n;i++){
	    scanf("%d",&a[i]);
	}
	for(int i=0;i<n-1;i++){
	    for(int j=0;j<n-1-i;j++){
	        if(a[j+1]<a[j]){
	            int temp=a[j+1];
	            a[j+1]=a[j];
	            a[j]=temp;
	        }
	    }
	}
	for(int i=0;i<n;i++){
	    printf("%d ",a[i]);
	}
	return 0;
}
