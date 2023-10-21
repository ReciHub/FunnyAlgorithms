class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        if(!root)
        {
            return ans;
        }
        queue<TreeNode*> q;
        q.push(root);
        int count=0;
        while(!q.empty())
        {
int n=q.size();
            vector<int> v;
            for(int i=0;i<n;i++)
            {
                
TreeNode*temp=q.front();
                q.pop();
                    if(temp->left)
                    {
                        q.push(temp->left);
                    }
                    if(temp->right)
                    {
                        q.push(temp->right);
                    }
                    
    

                    v.push_back(temp->val);
            }
            if(count++%2)
            {
                reverse(v.begin(),v.end());
            }
            ans.push_back(v);
            
                
            
        }
        return ans;
    }
};