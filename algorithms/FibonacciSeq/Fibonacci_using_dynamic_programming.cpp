#include<bits/stdc++.h>
using namespace std;
#define ll long long
// Fibonacci sequence is 0 1 1 2 3 ..
// where nth fibonacci number is sum of (n-1)th and (n-2)th number
ll int fibonacci (ll int n , ll int *fib){
    if (n <= 1){
        // Minimum condition
        fib[n] = n;
        return n;
    }else{
        // Call for fibonacci function only if result is not present in fib array 
        if(fib[n-2] == -1){
            fib[n-2] = fibonacci(n-2 , fib);
        }
        if(fib[n-1] == -1){
            fib[n-1] = fibonacci(n-1 , fib);
        }
        // else return the result from fib array
        fib[n] = fib[n-1] + fib[n-2];
        return fib[n];
    }
}
int main(){
    // Note : Fibonacci number starts from 0 here
    
    ll int n;
    // Take input from user
    cout<<"Enter number : ";
    cin>>n;
    
    // Creating an auxiliary array for tabulation 
    ll int * fib = new ll int [n];
    for (int i = 0; i < n; i++)
    {
        fib [i] = -1;
    }

    // Store the result 
    ll int result = fibonacci(n,fib);
    
    // Print the result
    cout<<"Fibonacci number is : " << result;
    
    // releasing the dynamic memory allocated
    delete [] fib;
    return 0;
}
