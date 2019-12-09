#include<iostream>
using namespace std;
bool isPalindrome(string s)
{
	for(int i=0;i<s.size()/2;i++)
	{
		if(s[i]!=s[s.size()-i-1])
		{
			return false;
		}
	}
	return true;
}

int main()
{
	string s;
	cin>>s;
	if(isPalindrome(s))
		cout<<"String \""<<s<<"\" is a palindrome";
	else
		cout<<"String \""<<s<<"\" is not a palindrome";
}