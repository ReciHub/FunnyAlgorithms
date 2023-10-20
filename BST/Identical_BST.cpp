#include<bits/stdc++.h>
using namespace std;

struct node{
    int data;
    node* left;
    node* right;
    node(int d){
        data=d;
        left=NULL;
        right=NULL;
    }
};

bool identical(node* root1,node* root2){
    if(root1==NULL && root2==NULL)
    return true;
    else if(root1==NULL||root2==NULL)
    return false;
    else{
        bool cur=false;
        if(root1->data==root2->data)
        cur=true;
        bool left=identical(root1->left,root2->left);
        bool right=identical(root1->right,root2->right);
        if (cur && left && right)
        return true;
        else
        return false;
    }
}

int main(){
    node* root=new node(4);
    root->left=new node(2);
    root->right=new node(5);
    root->left->left=new node(1);
    root->left->right=new node(3);
    root->right->right=new node(6);

    cout<<identical(root,root);

    node* root2=new node(4);
    root2->left=new node(2);
    root2->right=new node(5);
    root2->left->left=new node(1);
    root2->left->right=new node(3);
    root2->right->right=new node(7);

    cout<<identical(root,root2);
}