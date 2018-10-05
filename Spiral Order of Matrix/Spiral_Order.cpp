#include<bits/stdc++.h>
using namespace std;

int main()
{
    vector < vector <int> > a;
    int r,c,temp;
    vector <int> temp1;
    scanf("%d %d", &r, &c);
    for(int i=0; i<r; i++)
    {
        for(int j=0; j<c; j++)
        {
            scanf("%d ", &temp);
            temp1.push_back(temp); 
        }
        a.push_back(temp1);
        temp1.clear();
    }
    
    int row = a.size();
    int col = a[0].size();
    int c_l = 0, c_r = col - 1;
    int r_u = 0, r_d = row - 1;
    int total_elements = row * col;

    int count = 0;

    vector <int> res;

    while (!(count == total_elements))
    {
        for(int i = c_l; i<=c_r; i++)
        {
            res.push_back(a[r_u][i]); count++;
        }    
        
        ++r_u;
        for(int i=r_u; i<=r_d; i++)
        {
            res.push_back(a[i][c_r]); count++;
        }    
        --c_r;
        for(int i = c_r; i>=c_l; i--)
        {
            res.push_back(a[r_d][i]); count++;
        }    
        --r_d;
        for(int i = r_d; i>=r_u; i--)
        {
            res.push_back(a[i][c_l]); count++;
        }    
        ++c_l;
    }
    printf("\n");

    for(int i=0; i<res.size(); i++)
        printf("%d ",res[i]);

    printf("\n");

    return 0;
}