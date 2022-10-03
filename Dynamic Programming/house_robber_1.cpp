/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
*/
/*now acc. to ques. he have to alter rob the houses and maximize profit so for maximum profit he check 2nd house profit before first 
    like if we choose example [1,2,3,1]
    if he choose 1st for h1 then he check that the 3rd house (h2+num) which as  maximum profit 
    1. so we start from first house and store it into a temp so we not lose data when update
    2.now check max between h1 and h2+num and mark it new house(h1);
    3.now the old one is our h2.
    4.return the h1;
*/
class Solution {
public:
    int rob(vector<int>& nums) {
        int h1=0, h2=0; //intially the robber is at 0 houses
        for(int x:nums){
            int t=h1;
            h1=max(x+h2,h1);
            h2=t;
        }
        return h1;
    }
};
