#include <iostream>

using namespace std;

bool isValidTriangle(int a,int b,int c){
    if( ((a+b) > c) && ((a+c) > b) && ((b+c) > a)){
        return true;
    }else{
        return false;
    }
}
//Tests
int main(){
    cout << isValidTriangle(3, 3, 3) << endl;
    //true
    cout << isValidTriangle(3, 4, 5) << endl;
    //true
    cout << isValidTriangle(2, 10, 12) << endl;
    //flase
return 0;
}