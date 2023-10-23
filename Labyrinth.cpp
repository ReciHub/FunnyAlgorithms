// Road to specialist!
#include <bits/stdc++.h>
#include <iostream>
using namespace std;
#define lli long long int
#define ll long long
#define no cout << "NO" << endl
#define yes cout << "YES" << endl
#define pb push_back
#define fastread() (ios_base::sync_with_stdio(false), cin.tie(NULL));
#define all(a) (a).begin(), (a).end()
#define allde(a) (a).begin(), (a).end(), greater<int>()


lli n,m;
char ans[1000005];
lli vis[10005][10005];

    lli sx, sy, ex, ey;
bool isSafe(lli i, lli j,vector<string> &a)
{
    if (i >= 0 && j >= 0 && i <= n - 1 && j <=  m - 1 && a[i][j] != '#')
        return true;
    return false;
}

    
int main()
{
    
    vector<vector<lli>> dist(1005,vector<lli> (1005,0));
    cin >> n >> m;
    vector<string> a(n);
  
    
    
    for (int i = 0; i < n; i++)
    {
          cin >> a[i];
        for (int j = 0; j < m; j++)
        {
            
            
            if (a[i][j] == 'A')
            {
                sx = i;
                sy = j;
                
            }
             if (a[i][j] == 'B')
            {
                ex = i;
                ey = j;
                
            }
            
        }
    }
    
    

    lli neighborX[4] = {0, 0, 1, -1};
    lli neighborY[4] = {1, -1, 0, 0};

    

    queue<pair<lli, lli>> q;
    q.push({sx, sy});
    vis[sx][sy] = 1;

    
    char par[n][m];

    while (!q.empty())
    {
        pair<lli,lli> temp = q.front();

        q.pop();

        for (int i = 0; i < 4; i++)
        {
            lli newx = temp.first + neighborX[i];
            lli newy = temp.second + neighborY[i];
            if (isSafe(newx, newy,a) && !vis[newx][newy])
            {
                if (i == 0)
                {
                    par[newx][newy] = 'R';
                }
                else if (i == 1)
                {
                    par[newx][newy] = 'L';
                }
                else if (i == 2)
                {
                    par[newx][newy] = 'D';
                }
                else
                {
                    par[newx][newy] = 'U';
                }
                dist[newx][newy] = dist[temp.first][temp.second] + 1;
                vis[newx][newy] = 1;
                q.push({newx, newy});
            }
        }
    }
    
    pair<lli, lli> p = {ex, ey};
    if (!vis[ex][ey])
        no;

    else
    {
        yes;
        cout<<dist[ex][ey]<<endl;
        for (int i = dist[ex][ey]; i >= 1; i--)
        {
            ans[i] = par[p.first][p.second];
            if (ans[i] == 'D')
                p = {p.first - 1, p.second};
            else if (ans[i] == 'U')
                p = {p.first + 1, p.second};
            else if (ans[i] == 'R')
                p = {p.first, p.second - 1};
            else if (ans[i] == 'L')
                p = {p.first, p.second + 1};
        }
        for (int i = 1; i <= dist[ex][ey]; i++)
        {
            cout << ans[i];
        }

        cout << endl;
    }
    
    return 0;
}