/**********************************************************
	Following is the Binary Tree Node class structure

	template <typename T>
	class BinaryTreeNode {
    	public : 
    	T data;
    	BinaryTreeNode<T> *left;
    	BinaryTreeNode<T> *right;

    	BinaryTreeNode(T data) {
        	this -> data = data;
        	left = NULL;
        	right = NULL;
    	}
	};

***********************************************************/

int getLCA(BinaryTreeNode <int>* root , int a, int b) {
   if(root==NULL)
         return -1;
    
    if(root -> data == a || root -> data == b)
        return root -> data;
    
    int lo = getLCA(root -> left, a, b);
    int ro = getLCA(root -> right, a, b);
    
    if(lo == -1 && ro == -1)
        return -1;	//-1
    
    if(lo == -1 && ro != -1)
        return ro;
    
    if(lo != -1 && ro == -1)
        return lo;
    
    if(lo != -1 && ro != -1)// here we have taken -1 in place of NULL 
        return root->data;
        
        
    // Write your code here
}

  
    

   
