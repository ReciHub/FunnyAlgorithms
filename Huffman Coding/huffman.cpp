#include <bits/stdc++.h>
using namespace std;
 
// A Huffman tree node
struct TreeNode {
 
    // One of the input characters
    char data;
    unsigned freq;
 
    TreeNode *left, *right;
 
    TreeNode(char data, unsigned freq)
    {
        left = right = NULL;
        this->data = data;
        this->freq = freq;
    }
};
 
// For comparison of freqs of two nodes
struct compare {
 
    bool operator()(TreeNode* l, TreeNode* r)
    {
        return (l->freq > r->freq);
    }
};
 
// Prints huffman codes from
// the root of Huffman Tree.
void printCodes(struct TreeNode* root, string str)
{
 
    if (!root)
        return;
 
    if (root->data != '$')
        cout << root->data << ": " << str << "\n";
 
    printCodes(root->left, str + "0");
    printCodes(root->right, str + "1");
}
 
// The main function that builds a Huffman Tree and
// print codes by traversing the built Huffman Tree
void HuffmanCodes(char data[], int freq[], int size)
{
    struct TreeNode *left, *right, *top;
 
    // Create a min heap & inserts all characters of data[]
    priority_queue<TreeNode*, vector<TreeNode*>, compare> minHeap;
 
    for (int i = 0; i < size; ++i)
        minHeap.push(new TreeNode(data[i], freq[i]));
 
    // Iterate while size of heap doesn't become 1
    while (minHeap.size() != 1) {
 
        // Extract the two minimum freq items from min heap
        left = minHeap.top();
        minHeap.pop();
 
        right = minHeap.top();
        minHeap.pop();
 
        top = new TreeNode('$', left->freq + right->freq);
 
        top->left = left;
        top->right = right;
 
        minHeap.push(top);
    }
 
 
    printCodes(minHeap.top(), "");
}
 

int main()
{
 
    char arr[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
    int freq[] = { 5, 9, 12, 13, 16, 45 };
 
    int size = sizeof(arr) / sizeof(arr[0]);
 
    HuffmanCodes(arr, freq, size);
 
    return 0;
}
