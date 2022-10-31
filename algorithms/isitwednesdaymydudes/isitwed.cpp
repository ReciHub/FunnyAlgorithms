#include <iostream>
using namespace std;

int main(){
     const string DAY[]={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
 
    time_t rawtime;
    tm * timeinfo;
    time(&rawtime);
    timeinfo = localtime(&rawtime);
    int wday = timeinfo -> tm_wday;
 
    if(DAY[wday] == "Wed") cout << "It's Wednesday ma dudes!" << endl;
    else cout << "It's not Wednesday ma dudes :(" << endl;
}       
