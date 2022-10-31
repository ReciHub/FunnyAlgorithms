// Sieve of erastothenes is an algorithm to output all the prime numbers less than 10^6
// in nlog(log(n)) time;

// https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes




#include<iostream>
using namespace std;
#define MAX 1000000

void sieve(){
	bool prime[MAX];
	for(int i=2;i<=MAX;i++)
		prime[i]=true;

	for(int i=2;(i*i)<=MAX;i++)
		if(prime[i])
			for(int j=(i*i);j<=MAX;j+=i)
				prime[j]=false;

	cout<<"All the prime numbers between 1 and 1000000 are :-\n";
	for(int i=2;i<=MAX;i++)
		if(prime[i])
			cout<<i<<" ";
}

int main(){
	sieve();
	return 0;
}