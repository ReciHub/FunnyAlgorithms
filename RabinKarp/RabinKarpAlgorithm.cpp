//Program to implement Rabin-Karp Algorithm for string matching
#include<bits/stdc++.h>
using namespace std;

int main()
{
	//Input
	int m, n;
   string text, search;
	cout<<"Enter the input string:"<<endl;
	cin>>text;
	cout<<"Enter the search string:"<<endl;
	cin>>search;
	m = search.length();
	n = text.length();

	//Set up the necessary hashing paramters
	unsigned int p = 256;
	unsigned long long q = 1e9 + 7;
	unsigned long long h = pow(p, m - 1);

	//Obtain the polynomial rolling hashes of the search text and the first window
	long int t = 0;
	long int s = 0;
	for(int i = 0; i < m; i++)
	{
		t = ((p * t) + text[i]) % q;
		s = ((p * s) + search[i]) % q;
	}

	//Implement Rabin-Karp Algorithm
	int flag = 0;
	for(int i = 0; i <= n - m; i++)
	{
		//Check if the window's hash matches that of the search string
		if(t == s)
		{
			//Compare the search string and the window lexicographically
			flag = 0;
			for(int j = 0; j < m; j++)
				if(text[i + j] != search[j])
					flag = 1;

			if(!flag)
				cout<<"\""<<search<<"\""<<" was found at position "<<i + 1<<endl;
		}

		//Slide the window ahead provided it doesn't exceed the text string
		if(i < n - m)
		    t = ((p * (t - (text[i] * h))) + text[i + m]) % q;

		//Correct the window hash if it ends up negative
		if(t < 0)
		    t += q;
	}

	return 0;
}
