#include<bits/stdc++.h>


/* ------------------------------------------------------------------------- */

typedef long long ll;
#define pb push_back
#define vecpair vector< pair< ll, ll > >
#define vec vector< ll >
#define boolean vector< bool >
#define mp make_pair
#define rep(i,a,b) for( ll i = a; i < b; i++ )
#define INF 1000000000000000000

/* ------------------------------------------------------------------------- */

using namespace std;

/* ------------------------------------------------------------------------- */

void dijkstras( vecpair *adj, vec &distance, ll s )
{
	priority_queue< pair<ll, ll>, vecpair,  greater< pair<ll, ll> > > min_heap;
	min_heap.push( mp(0,s) );
	distance[s] = 0;
	while( !min_heap.empty() )
	{
		ll u = min_heap.top().second;
		min_heap.pop();
		vecpair :: iterator i;

		for( i = adj[u].begin(); i != adj[u].end(); i++ )
		{
			ll v = (*i).first;
			ll w = (*i).second;

			if( distance[v] > distance[u] + w )
			{
				distance[v] = distance[u] + w;
				min_heap.push( mp( distance[v], v ) );
			}
		}

	}

}



/* ------------------------------------------------------------------------- */

int main()
{

	/* ------------------------------------------------------------------------- */

	ll n, m, u, v, w, s;

	/* ------------------------------------------------------------------------- */

	cin>>n>>m;

	/* ------------------------------------------------------------------------- */

	vecpair *adj = new vecpair[n];
	vec distance(n, INF);

	/* ------------------------------------------------------------------------- */

	rep(i,0,m)
	{
		cin>>u>>v>>w;
		u--;
		v--;
		adj[u].pb( mp( v, w ) );
		adj[v].pb( mp( u, w ) );
	}
	cin>>s;
	dijkstras( adj, distance, s-1 );

	/* ------------------------------------------------------------------------- */

	rep(i, 0, n)
	{
		cout<<distance[i]<<" ";
	}

}
