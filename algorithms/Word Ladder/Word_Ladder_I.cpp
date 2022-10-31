// Word Ladder I
// Problem statement:
/*
    Given two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal lengths. Find the length of the shortest transformation sequence from startWord to targetWord.
    Keep the following conditions in mind:

    -> A word can only consist of lowercase characters.
    -> Only one letter can be changed in each transformation.
    -> Each transformed word must exist in the wordList including the targetWord.
    -> startWord may or may not be part of the wordList.

    If no possible way to transform sequence from startWord to targetWord return 0.
*/
// Test Case:

/*
Input:
wordList = {"des","der","dfr","dgt","dfs"}
startWord = "der", targetWord= "dfs",
Output:
3
Explanation:
The length of the smallest transformation
sequence from "der" to "dfs" is 3
i,e "der" -> "dfr" -> "dfs".
*/

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    // TC -> O(N) [wordList length] * O(word length) * O(26) * O(logN) [set]
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        queue<pair<string, int>> q;
        // converting vector of wordList to set of wordList 
        // because it is easier to search as word in set then in a vector
        unordered_set<string> s(wordList.begin(), wordList.end());
        
        q.push({beginWord, 1}); // holds the beginning word and initial step as 1
        
        // we are deleting the already traversed word because forming the same word again
        // has no point, we want to form the new words and not loop witing the same set of words
        s.erase(beginWord);
        
        while(!q.empty()){
            string word = q.front().first;
            int steps = q.front().second;
            q.pop();
            if(word == endWord) return steps;
            
            // traverse through all the characters of the word
            for(int i = 0; i < word.size(); i++){
                
                string original = word;
                
                // change each character to some different letters from a-z
                for(char ch = 'a'; ch <= 'z'; ch++)
                {
                    word[i] = ch;
                    
                    // if any of the word exist in wordList we will take that word
                    if(s.count(word)){
                        s.erase(word);
                        q.push({word, steps+1});
                    }
                }
                word = original; // undo the changes made.
            }
        }
        return 0;
    }
};
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
		int ans = obj.ladderLength(startWord, targetWord, wordList);
		cout << ans << "\n";
	}
	return 0;
}