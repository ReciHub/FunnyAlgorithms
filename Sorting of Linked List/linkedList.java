
//the algorithm sorts the elements of a linked list
//since we use merge sort to implement the algorithm so time complexity becomes O(nLogn)
//we make a temporary linked list everytime so the maximum space complexity can be O(1)

public class linkedList {
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

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach with the existing linked list
		if (!isEmpty())
			this.tail.next = nn;

		// data members
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

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		nn.next = this.head;

		// data members
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

			
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			Node nm1 = getNodeAt(idx - 1);
			Node np1 = nm1.next;
			nm1.next = nn;
			nn.next = np1;

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
			sm2.next = null;
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
	private Node midNode() {

		Node slow = this.head;
		Node fast = this.head;

		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;
			fast = fast.next.next;

		}

		return slow;
	}
	private linkedList mergeTwoSortedLL(linkedList other) {

		linkedList merged = new linkedList();

		Node ttemp = this.head;
		Node otemp = other.head;

		while (ttemp != null && otemp != null) {

			if (ttemp.data < otemp.data) {
				merged.addLast(ttemp.data);
				ttemp = ttemp.next;
			} else {
				merged.addLast(otemp.data);
				otemp = otemp.next;
			}

		}

		if (ttemp == null) {
			while (otemp != null) {
				merged.addLast(otemp.data);
				otemp = otemp.next;
			}
		}

		if (otemp == null) {
			while (ttemp != null) {
				merged.addLast(ttemp.data);
				ttemp = ttemp.next;
			}
		}

		return merged;

	}

	public void mergeSort() {

		if (this.size == 1) {
			return;
		}

		Node mid = midNode();
		Node midn = mid.next;

		linkedList fh = new linkedList();

		fh.head = this.head;
		fh.tail = mid;
		fh.tail.next = null;
		fh.size = (this.size + 1) / 2;

		linkedList sh = new linkedList();

		sh.head = midn;
		sh.tail = this.tail;
		sh.tail.next = null;
		sh.size = this.size / 2; 

		fh.mergeSort();
		sh.mergeSort();

		linkedList sorted = fh.mergeTwoSortedLL(sh);

		this.head = sorted.head;
		this.tail = sorted.tail;

	}

	public static void main(String[] args) throws Exception {
		linkedList list = new linkedList();

		list.addLast(5);
		list.addLast(7);
		list.addLast(3);
		list.addLast(9);
		list.addLast(8);
		list.addLast(4);
		list.addLast(2);
		list.display();
		list.mergeSort();
		list.display();
		
	}
}
