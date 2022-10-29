#include<bits/stdc++.h>

using namespace std;

int gcd(int x, int y)
{
    if (y == 0)
    {
        return x;
    }
    else
    {
        return gcd(y, x % y);
    }
}


int main()
{
    int x, y;
    cout << "Please enter two integers : " ;
    cin  >> x , y ;
    cout << gcd(x,y) << endl;
}
