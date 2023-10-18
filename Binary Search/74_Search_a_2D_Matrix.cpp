class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        // https://leetcode.com/problems/search-a-2d-matrix/description/
        // search a sorted 2D matrix
        int n=matrix.size(),m=matrix[0].size();
        for(int i=0;i<n;i++){
            if(matrix[i][0]<=target && matrix[i][m-1]>=target){
                int low=0,high=m-1;
                while(low<=high){
                    int mid=(low+high)/2;
                    if(matrix[i][mid]==target) return true;
                    if(matrix[i][mid]<=target) low=mid+1;
                    else high=mid-1;
                }
                return false;
            }
        }
        return false;
    }
};
