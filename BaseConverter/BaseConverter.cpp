#include <iostream>
#include <cmath>
#include <string>
using namespace std;

string convert(string, int, int);
int toDecimal(string, int);
string toBase(int, int);
char maxCheck(int);

int main(){

    cout << "Enter the number you're converting: ";
    string inpNum;
    cin >> inpNum;
    int base = 0;
    do{
        cout << "What base is this number in?\nEnter a number (2-35) here: ";
        cin >> base;
    }while(base < 2 || base > 35);
    int newBase = 0;
    do{
    cout << "What base is this number being converted to?\nEnter a number here: ";
    cin >> newBase;
    }while(base < 2 || base > 35);
    cout << convert(inpNum, base, newBase) << endl;
    return 0;
}

string convert(string num, int oldbase, int newbase){
    int deci = toDecimal(num, oldbase);
    return toBase(deci, newbase);
}
int toDecimal(string num, int oldbase){
    if(oldbase == 10)
        return stoi(num);
    int deci = 0;
    for(int x = num.size()-1; x >= 0; x--){
        int power = num.size()-1-x;
        deci+=((num[x]-'0')*pow(oldbase, power));
    }
    return deci;
}
string toBase(int deci, int newbase){
    if(newbase == 10)
        return to_string(deci);
    string toRet = "";
    int div = deci, mod = 0;
    while(div != 0){
        mod = div%newbase;
        div = div/newbase;
        toRet=maxCheck(mod)+toRet;
    }
    return toRet;
}
char maxCheck(int num){
    if(num > 9)
	return('7'+num);
    return '0'+num;
}
