#include <iostream>
#include <math.h>

using namespace std;

//the copy function copies the source elements from the
//index l to the index r, setting all in the destiny, from the k index;
void copy(int destiny[],int k,int source[],int l, int r){
    for(int i=l;i<=r;i++)
        destiny[k++] = source[i];
}

//merge the b and c arrays and put on the a array based from the smallers of both b and c arrays
void merge(int b[],int c[],int a[],int p, int q){
    int i,j,k;
    i=j=k=0;
    while(i<p && j<q){
        if(b[i] <= c[j]){
            a[k] = b[i];
            i++;
        }
        else{
            a[k] = c[j];
            j++;
        }
        k++;
    }
    if(i==p) copy(a,k,c,j,q-1);
    else copy(a,k,b,i,p-1);
}

//keep calling the function recursively until get just 1 element
//copy 2 halves of the a array, and merge both using the mege function
void mergesort(int a[], int n){
    if(n > 1){
        int b[n/2],c[n/2+1];
        copy(b,0,a, 0, n/2-1);
        copy(c,0,a, n/2, n-1);
        mergesort(b,n/2);
        mergesort(c,ceil(n/2.0));
        merge(b,c,a,n/2,ceil(n/2.0));
    }
}

//testing
int main() {
    int vet[9]={5,7,1,4,3,6,9,8,2};
    mergesort(vet,9);
    for(int i=0;i<9;i++) cout << vet[i] << " ";
}
