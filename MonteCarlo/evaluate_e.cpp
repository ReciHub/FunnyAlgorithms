#include<bits/stdc++.h>

using namespace std;

int main()

{
    int Titer = 1000000; // Total iterations for simulation
    double sum,full_sum;
    int num;
    for (int iter = 0; iter < Titer; iter++)
    {
        srand(iter + time(NULL));
        sum = 0;
        num = 0;
        while(sum < 1)
        {
            sum += ((double) rand() / (RAND_MAX));
            num++;
        }
        full_sum += num;
    }
    cout<< "Value of e is : " << full_sum/Titer << endl;
    
}
