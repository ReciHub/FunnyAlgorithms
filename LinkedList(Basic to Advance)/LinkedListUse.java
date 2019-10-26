import java.util.Scanner;

public class LinkedListUse {
	
	public static Node<Integer> takeInput(){
		Node<Integer> head = null, tail = null;
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		
		while(data != -1) {
			Node<Integer> newNode = new Node<>(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			} else {
//				Node<Integer> temp = head;
//				while(temp.next != null) {
//					temp = temp.next;
//				}
//				temp.next = newNode;
				tail.next = newNode;
				tail = newNode;	// tail = tail.next
			}
			data = s.nextInt();
		}
		return head;
	}
	
	public static void print(Node<Integer> head) {

		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static Node<Integer> insert(Node<Integer> head, int data, int pos) {
		
		Node<Integer> newNode = new Node<>(data);
		int i = 0;
		if(pos == 0) {
			newNode.next = head;
			head = newNode;
			return newNode;
		}
		Node<Integer> temp = head;
		
		while(i < pos - 1) {
			temp = temp.next;
			i++;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		return head;
	}
	
	public static Node<Integer> deleteIthNode(Node<Integer> head, int i){
		Node<Integer> temp = head;
		if(i == 0) {
			head = head.next;
			return head;
		}
		int x = 0;
		while(x < i - 1) {
			temp = temp.next;
			x++;
		}
		if(temp == null) {
			return head;
		}
		if(temp.next != null) {
			temp.next = temp.next.next;
		}
		return head;
	}
	
	public static Node<Integer> append(Node<Integer> root, int n) {
        if(n <= 0) {
        	return root;
        }
        Node<Integer> temp = root;
        int length = 0;
        while(temp != null) {
        	temp = temp.next;
        	length++;
        }
        int count = length - n;
        int i = 1;
        Node<Integer> curr = root;
        Node<Integer> head2;
        while(i < count) {
        	curr = curr.next;
        	i++;
        }
        head2 = curr.next;
        Node<Integer> temp2 = head2;
        curr.next = null;
        while(temp2.next != null) {
        	temp2 = temp2.next;
        }
        temp2.next = root;
        return head2;
    }
	
	public static Node<Integer> removeDuplicates(Node<Integer> head){
		if(head == null || head.next == null) {
			return head;
		}
		Node<Integer> temp1 = head, temp2 = head.next;
		while(temp2 != null) {
			if(temp1.data.equals(temp2.data)) {
				temp2 = temp2.next;
			}else {
				temp1.next = temp2;
				temp1 = temp2;
				temp2 = temp2.next;
			}
		}
		temp1.next = temp2;
		return head;
	}
	
	public static void printReverseRecursive(Node<Integer> root) {
		if(root == null) {
			return;
		}
		printReverseRecursive(root.next);
		System.out.print(root.data + " ");
		return;
		
	}
	
	public static Node<Integer> reverseLL(Node<Integer> head){
		Node<Integer> prev = null; 
		Node<Integer> current = head; 
		Node<Integer> next = null; 
        while (current != null) { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        } 
        head = prev; 
        return head;
	}
	
	public static boolean isPalindrome_2(Node<Integer> head) {
		if(head == null || head.next == null) {
			return true;
		}
		int len = 0;
		Node<Integer> t1 = head, t2 = head, head2 = null;
		while(t1 != null) {
			t1 = t1.next;
			len++;
		}
		int mid = len / 2;
		int x = 1;
		while(x <= mid - 1) {
			t2 = t2.next;
			x++;
		}
		head2 = t2.next;
		t2.next = null;
		System.out.println("Head2 = " + head2.data);
		head2 = reverseLL(head2);
		
		while(head != null && head2 != null) {
			if(head.data.equals(head2.data)) {
				head = head.next;
				head2 = head2.next;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static int printMiddel(Node<Integer> head) {
		if(head == null) {
			return -1;
		}
		if(head.next == null) {
			return head.data;
		}
		Node<Integer> slow = head, fast = head;
		while(fast.next != null) {
			fast = fast.next.next;
			if(fast == null) {
				return slow.data;
			}
			slow = slow.next;
		}
		return slow.data;
	}
	
	public static Node<Integer> mergeTwoList(Node<Integer> head1, Node<Integer> head2) {
		if(head1 == null) {
			return head2;
		}
		if(head2 == null) {
			return head1;
		}
		Node<Integer> t1 = head1, t2 = head2, h3 = null, t3 = null;
		if(t1.data < t2.data) {
			System.out.print("A ");
			h3 = t1;
			t3 = t1;
			t1 = t1.next;
		} else {
			System.out.print("B ");
			h3 = t2;
			t3 = t2;
			t2 = t2.next;
		}
		while(t1 != null && t2 != null) {
			if(t1.data < t2.data) {
				System.out.print("C ");
				t3.next = t1;
				t3 = t1;
				t1 = t1.next;
			} else {
				System.out.print("D ");
				t3.next = t2;
				t3 = t2;
				t2 = t2.next;
			}
		}
		while(t1 != null) {
			System.out.print("E ");
			t3.next = t1;
			t3 = t1;
			t1 = t1.next;
		}
		t3.next = t2;
		while(t2 != null) {
			t3.next = t2;
			System.out.print("F ");
			t3 = t2;
			t2 = t2.next;
		}
		System.out.println();
		t3.next = null;
		return h3;
	}

	
	public static void main(String[] args) {
		
//		Node<Integer> head = takeInput();
		Node<Integer> head1 = takeInput();
		Node<Integer> head2 = takeInput();
		Node<Integer> head3;
//		System.out.println(printMiddel(head));
		head3 = mergeTwoList(head1, head2);
		print(head3);
//		head = insert(head, 80, 0);
//		head = deleteIthNode(head, 3);
//		head = append(head, 6);
//		head = removeDuplicates(head);
//		printReverseRecursive(head);
//		System.out.println(isPalindrome_2(head));
//		print(head);
//		Node<Integer> node1 = new Node<>(10);
//		Node<Integer> node2 = new Node<>(20);
//		Node<Integer> node3 = new Node<>(30);
//		node1.next = node2;
//		node2.next = node3;
//		Node<Integer> head = node1;
//		print(head);
//		print(head);
		
	}
	
}
