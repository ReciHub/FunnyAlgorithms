/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package deletionbycopying;
class Node {
    int info;
    Node left,right;
    Node(int x) {info=x;left=right=null;}  
}

class BSTree {
    Node root;
    BSTree() {root=null;}
    boolean isEmpty() {return(root==null);}
    
    void insert(int x) {
        if(root==null) {root = new Node(x); return;}
        Node f=null, p=root; 
        while(p!=null) {
            if(p.info==x) {
                System.out.println(" The key " + x 
                        + " already exists, no insertion.");
                return;
            }
            if(x<p.info) {f=p;p=p.left;}
            else {f=p;p=p.right;}
        }
        if(x<f.info)
            f.left=new Node(x);
        else
            f.right=new Node(x);
    }
    
    void copyDele(int x) {
        if(root==null) {
            System.out.println("The tree is empty, no deletion.");
            return;
        }
        //find f is father of p
        Node f=null, p=root;
        while(p!=null) {
            if(p.info==x) break;//found key x
            if(x<p.info) {f=p;p=p.left;}
            else {f=p;p=p.right;}
        }
        if(p==null) {//not found key x
            System.out.println("The key " + x + " does not exist, no deletion.");
            return;
        }
        //1- p has no child (p is a leaf node)
        if(p.left==null && p.right==null) { 
            if(f==null) // The tree is one node
                root=null; 
            else {
                if(f.left==p)
                    f.left=null;
                else
                    f.right=null;
            }
            return;
        }
        //2- p has the left child only
        if(p.left!=null && p.right==null) {
            if(f==null) // p is a root
                root=p.left; 
            else {
                if(f.left==p) // p is a left child
                    f.left=p.left;
                else 
                    f.right=p.left;
            }
            return;
        }
        //3- p has the right child only
        if(p.left==null && p.right!=null) {
            if(f==null) // p is a root
                root=p.right; 
            else {
                if(f.left==p) // p is a left child
                    f.left=p.right;
                else 
                    f.right=p.right;
            }
            return;
        }
        //4- p has both left and right children
        if(p.left!=null && p.right!=null) { 
            Node rp; // p's key will be replaced by rp's one
            f=null;
            rp = p.left;
            // Find the right most node on the left sub-tree
            while(rp.right!=null) {f=rp; rp = rp.right;}
            p.info = rp.info;
            if(f==null) // rp is just a left son of p 
                p.left=rp.left;
            else
                f.right=rp.left;
        }
    }
    
    void visit(Node p) {
        if(p==null) return;
        System.out.print("  " + p.info);
    }
    
    void preOrder(Node p) {
        if(p==null) return;
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }
    
    void inOrder(Node p) {
        if(p==null) return;
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }
    
    void postOrder(Node p) {
        if(p==null) return;
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }
    
    void addArray(int [] a) {
        for(int i=0; i<a.length; i++)
            insert(a[i]);
    }
}

public class Main {
    public static void main(String [] args) {
        BSTree t = new BSTree();
        System.out.println(" BST after insertion (3 5 1 5 9 8 2):");
        int [] a = {3,5,1,5,9,8,2};
        t.addArray(a);
        
        /*         3                    2
                  / \                  / \
                 1   5                1   5
                  \   \                    \
                   2   9                    9
                      /                    /  
                     8                    8   
        - Pre-order :   3 1 2 5 9 8             - Pre-order :   2 1 5 9 8
        - In-order  :   1 2 3 5 8 9             - In-order  :   1 2 5 8 9
        - Post-order:   2 1 8 9 5 3             - Post-order:   1 8 9 5 2               
        */
        
        System.out.print(" - Pre-order traverse:"); t.preOrder(t.root);
        System.out.print("\n - In-order traverse:"); t.inOrder(t.root);
        System.out.print("\n - Post-order traverse: "); t.postOrder(t.root); 
        System.out.print("\n Ater deleting 3:"); t.copyDele(3);
        System.out.print("\n - Pre-order traverse:"); t.preOrder(t.root);
        System.out.print("\n - In-order traverse:"); t.inOrder(t.root);
        System.out.print("\n - Post-order traverse: "); t.postOrder(t.root); 
        System.out.println();
    }
}
