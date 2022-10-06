/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:

  bool checkBST(TreeNode *root, long long leftmax, long long rightmax){
        if(!root)
            return true;
        return root -> val > leftmax and root -> val < rightmax && checkBST(root -> left, leftmax, root -> val) && checkBST(root -> right, root -> val, rightmax);
    }
    bool isValidBST(TreeNode* root) {
        long long left = -2147483649;
        long long right = 2147483648;
        return checkBST(root, left, right);
       
        
    }
};

//
 /*bool checkBST(TreeNode *root, long long leftmax, long long rightmax){
        if(!root)
            return true;
        return root -> val > leftmax and root -> val < rightmax && checkBST(root -> left, leftmax, root -> val) && checkBST(root -> right, root -> val, rightmax);
    }
    bool isValidBST(TreeNode* root) {
        long long left = -2147483649;
        long long right = 2147483648;
        return checkBST(root, left, right);*/
