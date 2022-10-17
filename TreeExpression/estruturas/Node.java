package estruturas;

public class Node <T> {
	
	private T info;
	private Node<T> proximo;
	
	public Node(T info){
		this.info = info;

	}
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public Node<T> getProximo() {
		return proximo;
	}
	public void setProximo(Node<T> proximo) {
		this.proximo = proximo;
	}
	
	
}
