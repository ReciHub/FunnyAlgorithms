/* You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Constraints:
1 <= n <= 45
Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
*/

class Solution {
public:
    int v[47];
    int climbStairs(int n) {
        v[0]=1;
        v[1]=1;
        for(int i=2;i<=n;i++){
            v[i]= v[i-1]+v[i-2];
            if(i==n){
                return v[i];
            }
        }
        return 1;
    }
};

