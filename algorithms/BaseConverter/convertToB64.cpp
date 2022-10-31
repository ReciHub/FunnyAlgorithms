#include <iostream>
#include <string>
using namespace std;

int takeInput();
string convertToB64(int inp);
char numToLet(int val);

int main(int argc, char *argv[]){
    if(argc > 1)
        cout << convertToB64(stoi(argv[1])) << endl;
    else
        cout << convertToB64(takeInput()) << endl;
    return 0;
}

int takeInput(){
    cin.exceptions(istream::failbit);
    int inpVal;
    bool fail;
    do{
        fail = true;
        try{
            cout << "Enter a decimal number: ";
            cin >> inpVal;
        }
        catch(const ios::failure &){
            fail = false;
        }
    }while(!fail);
    return inpVal;
}
string convertToB64(int inp){
    string toRet = "";
    int div = inp;
    while(div > 0){
        int mod = div%64;
        div = div/64;
        toRet=numToLet(mod)+toRet;
    }
    return toRet;
}

char numToLet(int val){
    int section =  val/26;
    if(!section)
        return (char)(65+val);
    else if(section == 1)
        return(char)(71+val); //97 + val - 26 = 71+val
    else if(val-52 > 9)
        return val==62 ? '+' : '/';
    else
        return (char)(val-4);//48 + val - 52 == val-4
}