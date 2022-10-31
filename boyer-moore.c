//Algorithm to find majority element. Given an integer array containing duplicates, return the majority element if present. A majority element appears more than n/2 times, where n is the array size.

#include <stdio.h>
 
// Function to find the majority element present in a given array
int findMajorityElement(int nums[], int n)
{
    // `m` stores the majority element (if present)
    int m;
 
    // initialize counter `i` with 0
    int i = 0;
 
    // do for each element `nums[j]` in the array
    for (int j = 0; j < n; j++)
    {
        // If counter `i` becomes 0, set the current candidate
        // to `nums[j]` and reset the counter to 1
        if (i == 0) {
            m = nums[j], i = 1;
        }
 
        // If the counter is non-zero, increment or decrement it
        // according to whether `nums[j]` is a current candidate
        else {
            (m == nums[j]) ? i++ : i--;
        }
    }
 
    return m;
}
 
int main(void)
{
    // assumption: valid input (majority element is present)
    int nums[] = { 1, 8, 7, 4, 1, 2, 2, 2, 2, 2, 2 };
    int n = sizeof(nums)/sizeof(nums[0]);
 
    printf("The majority element is %d", findMajorityElement(nums, n));
 
    return 0;
}
