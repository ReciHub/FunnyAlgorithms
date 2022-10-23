#include <iostream>
using namespace std;

class TreeNode{
    public:
        int value;
        TreeNode* left;
        TreeNode* right;

    TreeNode(){
        value = 0;
        left = NULL;
        right = NULL;
    }
    TreeNode(int v){
        value = v;
        left = NULL;
        right = NULL;
    }
};

class BST{
    public:
        TreeNode* root;
    
    BST(){
        root = NULL;
    }

    TreeNode* insertNode(TreeNode* r, TreeNode* new_node){
        if(r == NULL){//caso base
            r = new_node;
            return r;
        }
        if(new_node->value < r->value){
            r->left = insertNode(r->left, new_node);
        }
        else if(new_node->value > r->value){
            r->right = insertNode(r->right, new_node);
        }
        else{
            return r;
        }
        return r;
    }
    TreeNode* newNode(int data){
        TreeNode* temp = new TreeNode();

        temp->value = data;
        temp->left = temp->right = NULL;

        return temp;
    }

    TreeNode* constructTreeUtil(int pre[], int* preIndex, int low, int high, int size){

        if (*preIndex >= size || low > high)
            return NULL;

        TreeNode* root = newNode(pre[*preIndex]);
        *preIndex = *preIndex + 1;

        if (low == high)
            return root;

        int i;
        for (i = low; i <= high; ++i)
            if (pre[i] > root->value)
                break;

        root->left = constructTreeUtil(pre, preIndex, *preIndex, i - 1, size);
        root->right = constructTreeUtil(pre, preIndex, i, high, size);

        return root;
    }

    TreeNode* constructTree(int pre[], int size){
        int preIndex = 0;
        return constructTreeUtil(pre, &preIndex, 0, size - 1, size);
    }

    TreeNode* Etapa1(TreeNode* r, int &L){
        if (r==NULL){
            return r;
        }
        if (r->right!=NULL){
            r = leftRotate(r);
            L++;
            r = Etapa1(r, L);
        }
        else{
            r->left = Etapa1(r->left, L);
        }
        return r;
    }

    TreeNode* Etapa2(TreeNode* r, int &L, int &R){
        if (r == NULL){
            return r;
        }
        int temp;
        cin >> temp;
        if (r->right==NULL){
            while (r->value!=temp){
                r = rightRotate(r);
                R = R + 1;
            }
        }
        else{
            while (r->value!=temp){
                r = leftRotate(r); 
                L = L + 1;
            }
        }
        r->left = Etapa2(r->left, L, R);
        r->right = Etapa2(r->right, L, R);
        return r;
    }

    TreeNode *leftRotate(TreeNode* x){
        TreeNode* y = x->right;
        TreeNode* temp = y->left;

        y->left = x;
        x->right = temp;

        return y;
    }

    TreeNode* rightRotate(TreeNode* y){
        TreeNode* x = y->left;
        TreeNode* temp = x->right;
    
        x->right = y;
        y->left = temp;
    
        return x;
    }

    TreeNode* skeewedTree(TreeNode* r, int &L){
        if(r==NULL)
            return r;
        if(r->right!=NULL){
            r = leftRotate(r);
            L = L+1;
            r = skeewedTree(r, L);
        }
        else{
            r->left = skeewedTree(r->left, L);
        }
        return r;
    }

    void PosOrdem(TreeNode* r, int n, int &k){//(Left, Right, Root)
        if (r == NULL)
            return;
        PosOrdem(r -> left, n, k);
        PosOrdem(r -> right, n, k);
        k++;
        if (k==n){
            cout << r -> value;
        }else{
            cout << r -> value << " ";
        }
    }

    int height(TreeNode* node) {
        if(node == NULL)
            return 0;
        return 1 + max(height(node->left), height(node->right));
    }
    bool AVL(TreeNode *root) {
       int lh;
       int rh;
       if(root == NULL)
          return 1;
       lh = height(root->left);
       rh = height(root->right);
       if(abs(lh-rh) <= 1 && AVL(root->left) && AVL(root->right)) return 1;
       return 0;
    }
};

int main(){
    int n, val, flag = 0;
    while (cin>>n){
        BST S, T;
        int L = 0, R = 0, k = 0;
        for (int i = 0; i < n; i++){
            TreeNode* new_node = new TreeNode();
                cin >> val;
                new_node->value = val;
            S.root = S.insertNode(S.root, new_node);
        }
        //AS DUAS ETAPAS
        S.root = S.skeewedTree(S.root, L);
        
        S.root = S.Etapa2(S.root, L, R);
        if (flag){
            cout << endl << L << " " << R << endl;
        } else{
            cout << L << " " << R << endl;
        }
        
        S.PosOrdem(S.root, n, k);
        cout << endl;

        if (S.AVL(S.root)){
            cout << "true" << endl; 
        } 
        else{ 
            cout << "false" << endl;
        }
        flag = 1;
    }
    cout << endl;
    return 0;
}