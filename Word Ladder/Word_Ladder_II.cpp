// Word Ladder II 
// Problem statement:
/*
Given two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal lengths. Find all shortest transformation sequence(s) from startWord to targetWord. You can return them in any order possible.
Keep the following conditions in mind:

-> A word can only consist of lowercase characters.
-> Only one letter can be changed in each transformation.
-> Each transformed word must exist in the wordList including the targetWord.
-> startWord may or may not be part of the wordList.
-> Return an empty list if there is no such transformation sequence.
*/

// Test Case:
/*
Input:
startWord = "der", targetWord = "dfs",
wordList = {"des","der","dfr","dgt","dfs"}
Output:
der dfr dfs
der des dfs
Explanation:
The length of the smallest transformation is 3.
And the following are the only two ways to get
to targetWord:-
"der" -> "des" -> "dfs".
"der" -> "dfr" -> "dfs".
*/

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<string>> findSequences(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> st(wordList.begin(), wordList.end());
        queue<vector<string>> q;
        q.push({beginWord});
        // stores used words from wordList of previous level
        vector<string> usedOnLevel;
        usedOnLevel.push_back(beginWord);
        int level = 0;
        vector<vector<string>> ans;
        while(!q.empty())
        {
            // stores the current level word sequence
            vector<string> v = q.front();
            q.pop();
            
            // erase all the words that has been
            // used in the previous level to transform
            while(v.size() > level)
            {
                level++;
                for(auto it: usedOnLevel)
                    st.erase(it);
            }
            
            string word = v.back();
            if(word == endWord)
                ans.push_back(v);
            for(int i = 0; i < word.size(); i++)
            {
                char original = word[i];
                for(char ch = 'a'; ch <= 'z'; ch++){
                    word[i] = ch;
                    if(st.count(word))
                    {
                        // if transformed word exists in wordList
                        // add it to the sequence
                        v.push_back(word);
                        q.push(v);
                        
                        // mark the word as visited on that level
                        usedOnLevel.push_back(word);
                        // undo the changes made in word sequenece
                        // so that it can be changed to some other word
                        // on the same level
                        v.pop_back();
                    }
                }
                word[i] = original; // undo the character changes
            }
        }
        return ans;
    }
};
bool comp(vector<string> a, vector<string> b)
{
    string x = "", y = "";
    for(string i: a)
        x += i;
    for(string i: b)
        y += i;
    
    return x<y;
}
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<string>wordList(n);
		for(int i = 0; i < n; i++)cin >> wordList[i];
		string startWord, targetWord;
		cin >> startWord >> targetWord;
		Solution obj;
		vector<vector<string>> ans = obj.findSequences(startWord, targetWord, wordList);
		if(ans.size()==0)
		    cout<<-1<<endl;
		else
		{
		    sort(ans.begin(), ans.end(), comp);
            for(int i=0; i<ans.size(); i++)
            {
                for(int j=0; j<ans[i].size(); j++)
                {
                    cout<<ans[i][j]<<" ";
                }
                cout<<endl;
            }
		}
	}
	return 0;
}
