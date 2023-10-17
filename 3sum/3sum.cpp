#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
using namespace std;

vector<vector<int>> threeSum(vector<int> &nums){
    int n = nums.size();
    sort(nums.begin(), nums.end());
    set<vector<int>> set;
    vector<vector<int>> result;

    for (int i = 0; i < n; i++){
        int j = i + 1;
        int k = n - 1;

        while (j < k){
            int sum = nums[i] + nums[j] + nums[k];

            if (sum == 0){
                set.insert({nums[i], nums[j], nums[k]});
                j++;
                k--;
            }
            else if (sum <= 0){
                j++;
            }
            else if (sum >= 0){
                k--;
            }
        }
    }

    for (auto i : set){
        result.push_back(i);
    }

    return result;
}

int main(){
    vector<int> nums{-1,0,1,2,-1,-4};
    vector<vector<int>> result = threeSum(nums);
    
    
    for(int i=0; i<result.size(); i++){
        for(int j=0; j<result[i].size(); j++)
            cout<<result[i][j]<<", ";
        cout<<endl;
    }
    return 0;
}


/*

Given an integer array nums, The code returns all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set does not contain duplicate triplets.

*/