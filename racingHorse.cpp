#include<iostream>
#include<algorithm>
using namespace std;
#define BUF 4096
char ibuf[BUF];
int ipt = BUF;
 
int nextint() {
	while (ipt < BUF && ibuf[ipt] < '0') ipt++;
	if (ipt == BUF) {
		fread(ibuf, 1, BUF, stdin);
		ipt = 0;
		while (ipt < BUF && ibuf[ipt] < '0') ipt++;
	}
	int n = 0;
	while (ipt < BUF && ibuf[ipt] >= '0') n = (n*10)+(ibuf[ipt++]-'0');
 
   if (ipt == BUF) {
		fread(ibuf, 1, BUF, stdin);
		ipt = 0;
		while (ipt < BUF && ibuf[ipt] >= '0') n = (n*10)+(ibuf[ipt++]-'0');
	}
	
 
	return n;
}
int main()
{
    int t,n;
    t=nextint();
    while(t--)
    {
        n=nextint();
        int S[n];
        for(int i=0;i<n;i++)
        S[i]=nextint();
        sort(S,S+n);
        int min=S[1]-S[0];
        for(int i=1;i<n-1;i++)
        if(S[i+1]-S[i]<min)
        min=S[i+1]-S[i];
        printf("%d\n", min);
    }    

return 0;    
}
