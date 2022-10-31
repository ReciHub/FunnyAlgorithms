class Solution {
public:
    void sortColors(vector<int>& nums) {
        int light = 0, moderate = 0, dark = nums.size()-1;
        while(moderate <= dark){
            if(nums[moderate] == 0){
                swap(nums[moderate],nums[light]);
                light++;
                moderate++;
            }
            else if(nums[moderate] == 1)
                moderate++;
            else{
                swap(nums[moderate],nums[dark]);
                dark--;
            }
        }
    }
};
