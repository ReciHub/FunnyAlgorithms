package estruturas;

public interface TADPilha <T>{
	
	//public void print();
	public void push(T info);
	public T pop();
	public T top();
	public int size();
	public boolean isEmpty();
	
}
