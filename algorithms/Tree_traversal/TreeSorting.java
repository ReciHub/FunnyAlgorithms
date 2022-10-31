public class BinarySearchTree {
 
	public Node node;
	
	public BinarySearchTree(int data) {
		this.node = new Node(data);
	}
 
	public Node insert(Node node,int data) {
		if(node == null) {
			return new Node(data);
		}
		
		if(data < node.data) {
			node.left = insert(node.left, data);
		}
		
		else if(data > node.data) {
			node.right = insert(node.right, data);
		}
		return node;
	}
 
	public void inOrder(Node node) {
		if(node != null) {
			inOrder(node.left);
			System.out.print(node.data+" ");
			inOrder(node.right);
		}
	}
	
	class Node{
	
		private int data;
		private Node left;
		private Node right;
		public Node(int data) {
			super();
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
}
