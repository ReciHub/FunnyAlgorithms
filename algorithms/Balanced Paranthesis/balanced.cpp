    #include<iostream>
    using namespace std;
    bool matching(char a,char b){
        return (((a=='(')&&(b==')'))||((a=='{')&&(b=='}'))||((a=='[')&&(b==']')));
        
    }
    bool ispar(string x)
    {
        // Your code here
        stack<int>s;
        for(int i=0;i<x.length();i++){
            if((x[i]=='(')||(x[i]=='{')||(x[i]=='[')){s.push(x[i]);}
            else{
                if(s.empty()){return false;}
                else if(matching(s.top(),x[i])==false){return false;}
                else{s.pop();}
                
            }
        }
        return (s.empty()==true);
    }