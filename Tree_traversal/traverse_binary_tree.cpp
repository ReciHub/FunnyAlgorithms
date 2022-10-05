// Author: jason71319jason

#include <iostream>
#include <stack>

using std::cout;
using std::endl;
using std::stack;

typedef struct Node {
    int val;
    struct Node *right;
    struct Node *left;
} node;

// recursive method
void recur_preorder(node* n) {

    if(!n) return;
    
    cout << n->val << " ";
    recur_preorder(n->left);
    recur_preorder(n->right);
}
void recur_inorder(node* n) {

    if(!n) return;
    
    recur_inorder(n->left);
    cout << n->val << " ";
    recur_inorder(n->right);
}
void recur_postorder(node* n) {
    
    if(!n) return;

    recur_postorder(n->left);
    recur_postorder(n->right);
    cout << n->val << " ";
}

// iterative method
void iter_preorder(node* root) {

    stack<node*> stk;
    
    while(root || !stk.empty()) {
        while(root) {
            cout << root->val << " ";
            stk.push(root);
            root = root->left;
        }
        root = stk.top();
        stk.pop();
        root = root->right; 
    }
}

void iter_preorder2(node* root) {

    stack<node*> stk;
    
    if(root) stk.push(root);

    while(!stk.empty()) {
        
        root = stk.top();
        cout << root->val << " ";
        stk.pop();
        if(root->right) stk.push(root->right);
        if(root->left) stk.push(root->left);
    }

}

void iter_inorder(node* root) {

    stack<node*> stk;

    while(root || !stk.empty()) {
        while(root) {
            stk.push(root);
            root = root->left;
        }
        root = stk.top();
        cout << root->val << " ";
        stk.pop();
        root = root->right;
    }
}

// 2-stack version
void iter_postorder(node* root) {

    stack<node*> stk, stk2;

    while(root || !stk.empty()) {

        while(root) {
            stk2.push(root);
            stk.push(root);
            root = root->right;
        }

        root = stk.top();
        stk.pop();
        root = root->left;
    }

    while(!stk2.empty()) {
        cout << stk2.top()->val << " ";
        stk2.pop();
    }
}

node* create(int v, node *l, node *r) {
    node* n = new node;
    n->val = v;
    n->left = l;
    n->right = r;
    return n;
}
int main() {
    node* root = create(1,
                    create(2,
                        create(4, NULL, NULL),
                        create(5, NULL, NULL)),
                    create(3,
                        create(6, NULL, NULL),
                        create(7, NULL, NULL)));

    cout << "Recursive Preorder:" << endl;
    recur_preorder(root);
    cout << endl << "Iteratvie Preorder:" << endl;
    iter_preorder(root);
    cout << endl << "Iteratvie Preorder2:" << endl;
    iter_preorder2(root);
    cout << endl << "Recursive Inorder:" << endl;
    recur_inorder(root);
    cout << endl << "Iteratvie Inorder:" << endl;
    iter_inorder(root);
    cout << endl << "Recursive Postorder:" << endl;
    recur_postorder(root);
    cout << endl << "Iteratvie Postorder:" << endl;
    iter_postorder(root);
    cout << endl;

    return 0;
}
