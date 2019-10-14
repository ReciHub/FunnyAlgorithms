package practiceofassignment;

	

/* This algorithm tells us if a loop is present in a linked list or not
 * If no loop is present , the function returns false but if one exists, the algorithm removes the loop
 * and returns true.
 * 
 * The algorithm works on Floyd's Algorithm or to put it simply if two entities are moving in a loop at varying 
 * speeds, a moment will come when they intersect each other.
 * 
 * Since the algorithm takes no extra space so space complexity is O(1) and the time complexity is O(n).
 * 
*/
public class Linked_List {
	
	private class Node {
		int data;
		Node next;
		
		public Node(int item) {
			this.data = item;

		}

		public Node() {
			this.data = 0;
		}
		
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

	public boolean detectRemoveLoop() {

		Node slow = this.head;
		Node fast = this.head;
		//detecting the loop

		while (fast != null && fast.next != null) {
			
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				break;
			}

		}

		if (slow == fast) {

			// removing  the cycle
			Node start = this.head;
			Node loop = slow;

			while (start.next != loop.next && loop.next != head) {

				start = start.next;
				loop = loop.next;

			}

			loop.next = null;

			return true;
		} else {
			return false;
		}

	}

	public void dummyList() {
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n3;
		
		this.head = n1;

	}
	public static void main(String[] args) throws Exception {
		Linked_List list = new Linked_List();

		list.dummyList();
		System.out.println(list.detectRemoveLoop());
	

	}

}