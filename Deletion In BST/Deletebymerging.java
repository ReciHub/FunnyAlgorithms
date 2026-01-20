/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deletionbymerging;

class Node {

    int info;
    Node left, right;

    Node(int x) {
        info = x;
        left = right = null;
    }
}

class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void insert(int x) {
        if (root == null) {
            root = new Node(x);
            return;
        }
        Node f = null, p = root;
        while (p != null) {
            if (p.info == x) {
                System.out.println(" The key " + x + " already exists, no insertion.");
                return;
            }
            if (x < p.info) {
                f = p;
                p = p.left;
            } else {
                f = p;
                p = p.right;
            }
        }
        if (x < f.info) {
            f.left = new Node(x);
        } else {
            f.right = new Node(x);
        }
    }

    //return a node which has key = given key in the tree p
    public Node search(Node p, int key) {
        if (p == null) {
            return null;
        }
        if (p.info == key) {
            return p;
        } else if (p.info > key) {
            return search(p.left, key);
        } else {
            return search(p.right, key);
        }
    }

    public void deleteByMerging(int x) {
        Node p = search(root, x);
        if (p == null) {
            System.out.println("Key " + x + " does not exists, deletion failed");
            return;
        }
        //find f is father of p
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.info > p.info) {
                q = q.left;
            } else {
                q = q.right;
            }
        }
        //1- p has no child
        if (p.left == null && p.right == null) {
            if (f == null) {
                root = null;
            } else if (f.left == p) {
                f.left = null;
            } else {
                f.right = null;
            }
        } //2- p has the left child only
        else if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        } //3- p has the right child only
        else if (p.left == null && p.right != null) {
            if (f == null) {
                root = p.right;
            } else if (f.left == p) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        } //4- p has both left and right children
        else if (p.left != null && p.right != null) {
            //find q is the largest node on the left child of p (q is the right 
            //child with the largest key of the left child of p)
            q = p.left;
            Node t = null;
            while (q.right != null) {
                t = q;
                q = q.right;
            }
            //merge the right child of p into q
            Node rp = p.right;
            q.right = rp;
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        }
    }

    void visit(Node p) {
        if (p == null) {
            return;
        }
        System.out.print("  " + p.info);
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    void addArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            insert(a[i]);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        BSTree t = new BSTree();
        System.out.println(" BST after insertion (3 5 1 5 9 8 2):");
        int[] a = {3, 5, 1, 5, 9, 8, 2};
        t.addArray(a);

        /*         3                    1
                  / \                    \
                 1   5                    2
                  \   \                    \
                   2   9                    5
                      /                      \
                     8                        9
        - Pre-order :   3 1 2 5 9 8          /      - Pre-order :   1 2 5 9 8
        - In-order  :   1 2 3 5 8 9         8       - In-order  :   1 2 5 8 9
        - Post-order:   2 1 8 9 5 3                 - Post-order:   8 9 5 2 1 
         */
        System.out.print(" - Pre-order traverse:");
        t.preOrder(t.root);
        System.out.print("\n - In-order traverse:");
        t.inOrder(t.root);
        System.out.print("\n - Post-order traverse: ");
        t.postOrder(t.root);
        System.out.print("\n Ater deleting 3:");
        t.deleteByMerging(3);
        System.out.print("\n - Pre-order traverse:");
        t.preOrder(t.root);
        System.out.print("\n - In-order traverse:");
        t.inOrder(t.root);
        System.out.print("\n - Post-order traverse: ");
        t.postOrder(t.root);
        System.out.println();
    }
}
