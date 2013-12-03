

public class RBNode<T>{
	
	private T element;
	private boolean blackColor; //True: color=black. False: color=red
	private RBNode<T> leftChild;
	private RBNode<T> rightChild;
	private RBNode<T> parent;

	public RBNode(T element, RBNode<T> left, RBNode<T> right, RBNode<T> pa){
		this.element=element;
		this.leftChild=left;
		this.rightChild=right;
		this.parent=pa;
		this.blackColor=false;//Initial color= red
	}
	public RBNode(T element, RBNode<T>pa){
		this.element=element;		
		this.parent=pa;
		this.blackColor=false;//Initial color= red
	}


	public T getElement(){
		return this.element;
	}
	
	public void setElement(T element){
		this.element=element;
	}

	public boolean isBlack(){
		return blackColor;
	}

	public void setBlack(boolean b){
		this.blackColor=b;
	}

	public RBNode<T> getRightChild(){
		return this.rightChild;
	}

	public RBNode<T> getLeftChild(){
		return this.leftChild;
	}

	public RBNode<T> getParent(){
		return this.parent;
	}

	public void setRightChild(RBNode<T> right){
		this.rightChild=right;
	}

	public void setLeftChild(RBNode<T> left){
		this.leftChild=left;
	}

	public void setParent(RBNode<T> pa){
		this.parent=pa;
	}

	@Override
	public String toString(){
		return element.toString();
	}

}
