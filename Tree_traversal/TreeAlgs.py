class TreeNode:
    def __init__(self, val = 0, left = None, right = None) -> None:
        self.val = val
        self.left = left
        self.right = right


# There are 3 main ways to traverse a tree:
# Preorder: root -> left -> right
# Inorder: left -> root -> right
# Postorder: left -> root -> right

# Preorder traversal
def preorder(root):
    print(root.val)
    if root.left: preorder(root.left)
    if root.right:preorder(root.right)

# Inorder traversal
def inorder(root):
    if root.left: inorder(root.left)
    print(root.val)
    if root.right: inorder(root.right)

# Postorder traversal
def postorder(root):
    if root.left: postorder(root.left)
    if root.right: postorder(root.right)    
    print(root.val)

from collections import deque
# Inverting A Binary Tree
def TreeInvertion(root):
    if not root: return None
    q = deque([root])
    while q:
        for i in range(len(q)):
            node = q.popleft()

            # swap the subtree
            node.right, node.left = node.left, node.right
            if node.left: q.append(node.left)
            if node.right: q.append(node.right)
    return root

# These are very cool algorithms that i learned from doing leetcode: 
# basically reconstructing a binary tree if were given pre-order, and inorder.
# Or reconstrucing a binary tree if given inorder and postorder.

def TreeReconstructing(preorder = None, inorder = None, postorder = None):

    # If given preorder and inorder

    # if not preorder or not inorder:
    #         return None
    # root = TreeNode(preorder[0])
    # mid = inorder.index(preorder[0])
    # root.left = TreeReconstructing(preorder[1:mid+1], inorder[:mid])
    # root.right = TreeReconstructing(preorder[mid+1:], inorder[mid+1:])


    # If given inorder and postorder
    if not inorder or not postorder: return None
    root = TreeNode(postorder[len(postorder)-1])
    mid = inorder.index(postorder[-1])
    print(mid, inorder, postorder)
    root.left = TreeReconstructing(inorder[:mid], postorder[:mid])
    root.right = TreeReconstructing(inorder[mid+1:], postorder[mid:len(postorder)-1])
    return root





    