
import java.util.Scanner;

public class LinkedList {

    private class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public Node head;
    public Node tail;
    int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void addFirst(int data) {
        Node node = new Node(data, this.head);
        if (this.size() == 0) {
            this.head = node;
            this.tail = node;
        } else {
            this.head = node;
        }
        this.size++;
    }

    public void addLast(int data) {
        Node node = new Node(data, null);
        if (this.size() == 0) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    private Node getNodeAt(int index) throws Exception {
        if (index < 0 || index > this.size()) {
            throw new Exception("Invalid Index");
        }

        int count = 0;
        Node temp = this.head;
        while (count < index) {
            temp = temp.next;
            count++;
        }
        return temp;

    }

    public void addAt(int index, int data) throws Exception {
        if (index < 0 || index > this.size()) {
            throw new Exception("Invalid Index");
        }
        if (index == 0) {
            this.addFirst(data);
        } else if (index == this.size()) {
            this.addLast(data);
        } else {
            Node temp = getNodeAt(index - 1);
            Node node = new Node(data, temp.next);
            temp.next = node;
        }

    }

    public int getFirst() throws Exception {
        if (this.size() == 0) {
            throw new Exception("List Empty");
        }

        return this.head.data;
    }

    public int getLast() throws Exception {
        if (this.size() == 0) {
            throw new Exception("List Empty");
        }

        return this.tail.data;
    }

    public void removeFirst() throws Exception {
        if (this.size() == 0) {
            throw new Exception("List Empty");
        }
        if (this.size() == 1) {
            this.head = null;
            this.tail = null;
        } else {

            this.head = this.head.next;

        }
        this.size--;
    }

    public void removeLast() throws Exception {

        if (this.size() == 0) {
            throw new Exception("List Empty");
        }
        if (this.size() == 1) {
            this.head = null;
            this.tail = null;
        } else {

            Node temp = getNodeAt(this.size() - 2);
            this.tail = temp;
            temp.next = null;
            this.size--;
        }
    }

    public void display() {
        Node node = this.head;
        while (node != null) {
            System.out.print(node.data + "=>");
            node = node.next;
        }
        System.out.println("End");
    }

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
        LinkedList list = new LinkedList();
        System.out.println("Enter the number of elements");
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the " + (i + 1) + " element");

            list.addAt(i, s.nextInt());
        }
        list.oddeven();
        list.display();

    }

    public void oddeven() {
        int i = 0;
        while (i < this.size()) {
            Node node = this.head;
            while (node != null) {
                if (node.data % 2 == 0) {
                    if (node.next != null) {
                        Node node1 = node.next;
                        if (node1.data % 2 != 0) {
                            int temp = node.data;
                            node.data = node1.data;
                            node1.data = temp;
                        }
                    }
                }
                node = node.next;
            }
            i++;
        }

    }

}
