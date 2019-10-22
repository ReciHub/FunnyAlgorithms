# include <bits/stdc++.h>
#define flash ios_base::sync_with_stdio(false),cin.tie(NULL),cout.tie(NULL)
#define endl '\n'
#define ll long long int
#include <tr1/unordered_map>
#define ld long double
#define pb push_back
#define mp make_pair
#define MOD 1000000007
#define f(i,a,b)  for(long long i=a;i<b;i++)
#define all(c) (c).begin(),(c).end()
#include <map>
using namespace std;


int main()
{

#ifndef ONLINE_JUDGE
	  freopen("C:\\Users\\user\\Desktop\\coding problems\\in.txt","r",stdin);
	  freopen("C:\\Users\\user\\Desktop\\coding problems\\output.txt","w",stdout);
	#endif


     flash;
     ///////////////////////////////////////////////////////////////////////////////////////

string p,t,pr,tr;
cin>>p>>t;
ll n=p.size();
ll aux[n];
aux[0]=0;
ll j=0,i=1;
while(i<n)
{
	
		if(p[i]==p[j])
		{
			aux[i]=j+1;
			j++;
			i++;
		}
		else while(j>=0)
		{
			if(j==0)
			{
				aux[i]=0;
				i++;
				j=0;
				break;
			}
			else
			{
				j=aux[j-1];
				if(p[i]==p[j])
				{
					aux[i]=j+1;
					i++;
					j++;
					break;
				}
			}
		}
}
i=0;
j=0;
ll count=0;

while(i<t.size())
{
	
		if(t[i]!=p[j])
		{
				i=i;
				if(j>0)
				{
					j=aux[j-1];
				}
				else if(j==0)
				{
					j=0;
				}
				if(t[i]!=p[j])
				{
					i++;
				}
		}
		else if(t[i]==p[j])
		{
				i++;
				j++;
				if(j==p.size())
				{
					count++;
					j=aux[j-1];
		

				}

	     }
	

}
cout<<count<<endl;


    ///////////////////////////////////////////////////////////////////////////////////////

     return 0;

}
