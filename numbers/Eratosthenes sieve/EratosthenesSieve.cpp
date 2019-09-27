
// https://github.com/shivam-51
// Sieve of eratosthenes in C++


#include<iostream>
#include<stdio.h>
#include<vector>
using namespace std;

// vector to store all the prime numbers
vector<int > prime_numbers;

void sieve(){
        vector<int> store(1000000,1);
        for(int i=2;i*i<=1000000;i++){
                if(store[i]==1)
                // making all multiples 0
                        for(int j=i*i;j<=1000000;j+=i)
                                store[j]=0;
        }

        for(int i=2;i<1000000;i++)
                if(store[i])
                        prime_numbers.push_back(i);
}

int main(){
        printf("All prime Numbers less than 1000000 are:- \n");
        sieve();
        for(int i=0;i<prime_numbers.size();i++)
                cout<<prime_numbers[i]<<" ";
}
