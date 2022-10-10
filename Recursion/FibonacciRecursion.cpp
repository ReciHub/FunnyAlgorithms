#include <iostream>
using namespace std;


int fibonacci(int n){
  
    if(n==1)
      return 0;
    
    if(n==2)return 1;
    
    return fibonacci(n-1)+fibonacci(n-2);
}

int main(){
    int n, n1 = 0, n2 = 1, n3 = 0;

    cout << "Enter number: ";
    cin >> n;

    cout << "Fibonacci sequence: "<<n1<<" "<<n2;

    for(int i=3;i<=n;++i)

    cout<<" "<<fibonacci(i);
    
    return 0;
}
