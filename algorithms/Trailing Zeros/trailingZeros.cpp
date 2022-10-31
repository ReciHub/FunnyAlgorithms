//Trailing zeros in the factorial of a number
#include <iostream>

using namespace std;

int trailing_zeros(int n){
    int no = 0;
    for (int i = 5; n / i >= 1; i *= 5){
        no += n / i;
    }
    return no;
}

int main(){
    int n;
    cin >> n;
    int zeros = trailing_zeros(n);
    cout << zeros;
    return 0;
}