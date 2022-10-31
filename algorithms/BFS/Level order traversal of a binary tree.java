// A class to store a binary tree node
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
 
class Main
{
    // Function to print all nodes of a given level from left to right
    public static boolean printLevel(Node root, int level)
    {
        // base case
        if (root == null) {
            return false;
        }
 
        if (level == 1)
        {
            System.out.print(root.key + " ");
 
            // return true if at least one node is present at a given level
            return true;
        }
 
        boolean left = printLevel(root.left, level - 1);
        boolean right = printLevel(root.right, level - 1);
 
        return left || right;
    }
 
    // Function to print level order traversal of a given binary tree
    public static void levelOrderTraversal(Node root)
    {
        // start from level 1 — till the height of the tree
        int level = 1;
 
        // run till printLevel() returns false
        while (printLevel(root, level)) {
            level++;
        }
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
 
        levelOrderTraversal(root);
    }
}
