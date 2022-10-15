class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& str) {
        unordered_map<string, vector<string>> x; 
        vector<vector<string>> result;
        for(int i = 0;i < str.size();i++){
                string p = str[i]; 
                sort(p.begin(), p.end()); 
                x[p].push_back(str[i]);
        }
        for(auto it = x.begin();it != x.end();it++){
            result.push_back(it->second);
        }
        return result;
    }
};
