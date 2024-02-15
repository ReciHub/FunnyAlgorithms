/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstree;

import java.util.LinkedList;

class Node {

    int info;
    Node left, right;

    Node(int x) {
        info = x;
        left = right = null;
    }
}

class MyQueue {

    LinkedList a;

    MyQueue() {
        a = new LinkedList();
    }

    boolean isEmpty() {
        return (a.isEmpty());
    }

    void enqueue(Object x) {
        a.add(x);
    }

    Object dequeue() {
        return (a.removeFirst());
    }
}

class BTree {

    Node root;

    BTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    Node search(Node p, int x) {
        if (p == null) {
            return (null);
        }
        if (p.info == x) {
            return (p);
        }
        if (x < p.info) {
            return (search(p.left, x));
        } else {
            return (search(p.right, x));
        }
    }

    void insert(int x) {
        Node q = new Node(x);
        if (isEmpty()) {
            root = q;
            return;
        }
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info == x) {
                System.out.println("The key " + x
                        + " already exists, no insertion");
                return;
            }
            f = p;
            if (x < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (x < f.info) {
            f.left = q;
        } else {
            f.right = q;
        }
    }

    void insertMany(int[] a) {
        for (int i = 0; i < a.length; i++) {
            insert(a[i]);
        }
    }

    void visit(Node p) {
        System.out.print(p.info + " ");
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

    void breadth() {
        if (root == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node p;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if (p.left != null) {
                q.enqueue(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
            }
            visit(p);
        }
    }

    Node deleteLeaves(Node root, int x) {
        if (root == null) {
            return null;
        }
        root.left = deleteLeaves(root.left, x);
        root.right = deleteLeaves(root.right, x);
        if (root.info == x && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}

public class Main {

    public static void main(String[] args) {
        BTree t = new BTree();
        int[] a = {11, 5, 9, 7, 13};
        t.insertMany(a);

        /*       11        - Pre-order traverse     11 5 9  7  13         
                /  \       - In-order traverse      5  7 9  11 13         
               5   13      - Post-order traverse    7  9 5  13 11    
                \          - Level-order traverse   11 5 13 9  7          
                 9           (Breadth-first)        
                /
               7               
         */
        System.out.print("BST after insertion (11 5 9 7 13):");
        System.out.print("\n - Pre-order traverse       ");
        t.preOrder(t.root);
        System.out.print("\n - In-order traverse        ");
        t.inOrder(t.root);
        System.out.print("\n - Post-order traverse      ");
        t.postOrder(t.root);
        System.out.print("\n - Breadth-first traverse   ");
        t.breadth();
        System.out.print("\nBST after deletion 7:");
        t.deleteLeaves(t.root, 7);
        System.out.print("\n - Pre-order traverse       ");
        t.preOrder(t.root);
        System.out.print("\n - In-order traverse        ");
        t.inOrder(t.root);
        System.out.print("\n - Post-order traverse      ");
        t.postOrder(t.root);
        System.out.print("\n - Breadth-first traverse   ");
        t.breadth();
        System.out.println();
    }
}
