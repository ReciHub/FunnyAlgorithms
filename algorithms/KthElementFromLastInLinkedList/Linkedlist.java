

/* This algorithm is used to print the Kth from last element of a linked list
 * If we observe the code for the KthFromLast function , we notice that it has a linear
 * time complexity which is O(n) where n is the size of the linked list.
 * Also we reqire no extra space so the space complexity becomes O(1) ..(we are ignoring the O(n) space required for the linked list to exist)
 *
*/
public class Linkedlist {
	
	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int getFirst() throws Exception {

		if (isEmpty()) {
			throw new Exception("LL is Empty.");
		}

		return this.head.data;
	}

	public int getLast() throws Exception {

		if (isEmpty()) {
			throw new Exception("LL is Empty.");
		}

		return this.tail.data;
	}

	public int getAt(int idx) throws Exception {
		if (isEmpty()) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index.");
		}

		Node temp = this.head;

		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp.data;

	}

	private Node getNodeAt(int idx) throws Exception {

		if (isEmpty()) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index.");
		}

		Node temp = this.head;

		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp;

	}

	public void display() {

		System.out.println("-----------------");
		Node temp = this.head;

		while (temp != null) {
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}

		System.out.println(".");
		System.out.println("-----------------");
	}

	public void addLast(int item) {

	
		Node nn = new Node();
		nn.data = item;
		nn.next = null;


		if (!isEmpty())
			this.tail.next = nn;

	
		if (isEmpty()) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.tail = nn;
			this.size++;
		}

	}

	public void addFirst(int item) {

		
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		nn.next = this.head;

		if (isEmpty()) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.head = nn;
			this.size++;
		}

	}

	public void addAt(int idx, int item) throws Exception {

		if (idx < 0 || idx > this.size) {
			throw new Exception("Invalid Index.");
		}

		if (idx == 0) {
			addFirst(item);
		} else if (idx == this.size) {
			addLast(item);
		} else {

			// create a new node
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			// attach
			Node nm1 = getNodeAt(idx - 1);
			Node np1 = nm1.next;
			nm1.next = nn;
			nn.next = np1;

			// data members
			this.size++;

		}

	}

	public int removeFirst() throws Exception {

		if (this.isEmpty()) {
			throw new Exception("Ll is Empty.");
		}

		int rv = this.head.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			this.head = this.head.next;
			this.size--;
		}

		return rv;

	}

	public int removeLast() throws Exception {

		if (this.isEmpty()) {
			throw new Exception("Ll is Empty.");
		}

		int rv = this.tail.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {

			Node sm2 = getNodeAt(this.size - 2);
			this.tail = sm2;
			sm2.next = null;// tail kabhi null ni hoti tail ka next hota h
			this.size--;
		}

		return rv;

	}

	public int removeAt(int idx) throws Exception {

		if (this.isEmpty()) {
			throw new Exception("Ll is Empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index.");
		}

		if (idx == 0) {
			return removeFirst();
		} else if (idx == this.size - 1) {
			return removeLast();
		} else {

			Node nm1 = getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;

			this.size--;

			return n.data;

		}

	}

	public int kthFromLast(int k) {//implementation of the algorithm

		Node slow = this.head;
		Node fast = this.head;

		for (int i = 1; i <= k; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;

	}
	public static void main(String[] args) throws Exception {
		Linkedlist list = new Linkedlist();

		list.addLast(5);
		list.addLast(7);
		list.addLast(3);
		list.addLast(9);
		list.display();	
		System.out.println(list.kthFromLast(2));

	}

}
