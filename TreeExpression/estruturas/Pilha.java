package estruturas;

public class Pilha<T> implements TADPilha<T> {
	private Node<T> topo;
	private int quantidade;

	@Override
	public void push(T info) {
		Node<T> novaInfo = new Node<T>(info);
		novaInfo.setProximo(topo);
		topo = novaInfo;
		quantidade++;
	}

	@Override
	public T pop() {
		T info = null;

		if(topo!=null){
			info = topo.getInfo();
			topo = topo.getProximo();
			quantidade--;
		}
		return info;
	}

	@Override
	public T top() {
		T info = null;
		if(topo!=null){
			info = topo.getInfo();					
		}
		return info;
	}

	public int size() {
		return quantidade;
	}


	public boolean isEmpty() {
		if(size()==0){
			return true;
		}
		return false;
	}

}
