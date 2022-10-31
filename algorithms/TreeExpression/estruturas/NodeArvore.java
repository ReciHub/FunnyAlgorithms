package estruturas;

public class NodeArvore <T> {
	
	private T info;
	private NodeArvore<T> esquerda, direita;
	
	public NodeArvore(T info){
		this.info = info;
	}
	
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public NodeArvore<T> getEsquerda() {
		return esquerda;
	}
	public void setEsquerda(NodeArvore<T> esquerda) {
		this.esquerda = esquerda;
	}
	public NodeArvore<T> getDireita() {
		return direita;
	}
	public void setDireita(NodeArvore<T> direita) {
		this.direita = direita;
	}
	
}
