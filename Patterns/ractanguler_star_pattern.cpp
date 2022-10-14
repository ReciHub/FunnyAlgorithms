#include<iostream>
#include<iomanip>
using namespace std;
// ****************ractanguler star pattern*******************
int main(){
    int row, col;
    cout<<"enter the numbers of rows"<<endl;
    cin>>row;
    cout<<"enter the numbers of colums"<<endl;
    cin>>col;
     for (int i = 1; i <=row; i++)
     {     
        for (int j = 1; j <=col; j++){
           cout<<"*";
        }
        cout<<endl;
     }
    return 0;
}