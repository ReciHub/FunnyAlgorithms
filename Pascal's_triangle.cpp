class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> res;
        for(int i=1;i<=numRows;i++){
            vector<int> v = vector<int> (i, 1);
            if(i > 2)
                for(int j=1;j<=v.size()-2;j++){
                    v[j] = res[res.size()-1][j-1] + res[res.size()-1][j];
                }
            res.push_back(v);
        }
        return res;
    }
};
