#include<bits/stdc++.h>
using namespace std;

struct node{
    int data;
    node *left,*right;
    node(int d){
        data=d;
        left=NULL;
        right=NULL;
    }
};

vector<node*> possible_bst(int start,int end){
    vector<node*> trees;

    if(start>end){
        trees.push_back(NULL);
        return trees;
    }
    for(int i=start;i<=end;i++){
        vector<node*> lefttree=possible_bst(start,i-1);
        vector<node*> righttree=possible_bst(i+1,end);
        for(int j=0;j<lefttree.size();j++){
            node* left=lefttree[j];
            for(int k=0;k<righttree.size();k++){
                node* right=righttree[k];
                node* root=new node(i);
                root->left=left;
                root->right=right;
                trees.push_back(root);
            }
        }
    }
    return trees;
}

void display(node* root){
    if(root==NULL)
    return;
    cout<<root->data<<" ";
    display(root->left);
    display(root->right);
}

int main(){
    vector<node*> totaltree=possible_bst(1,3);
    for(int i=0;i<totaltree.size();i++){
        display(totaltree[i]);
        cout<<endl;
    }
}