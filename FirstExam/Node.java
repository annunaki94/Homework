

public class Node<T>{
	private T element;
	private Node<T> next;
	private boolean removeable;

	public void setRemoveable(boolean remove){
		this.removeable=remove;
	}

	public boolean isRemoveable(){
		return this.removeable;
	}

	public Node(T t){
		this.element= t;
	}

	public T getElement(){
		return this.element;
	}

	public void setNext(Node<T> next){
		this.next= next;
	}

	public Node<T> next(){
		return this.next;
	}
}
