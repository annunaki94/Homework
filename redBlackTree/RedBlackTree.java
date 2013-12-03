

public class RedBlackTree<K extends Comparable<? super K>, E> implements Dictionary<K,E>{
	
	private RBNode<Data<K,E>> root;
	
	public RedBlackTree(){}
	
	public boolean isEmpty( ){
		return root==null;
	}

	public Data<K,E> root( ){
		return root.getElement();
	}
	public void makeTree(Data<K,E> root, RedBlackTree<K,E> left, RedBlackTree<K,E> right ){
		this.root= new RBNode<Data<K,E>>(root,left.root,right.root,null);
	}	
	
	///////////////METHODS FROM DICTIONARY/*
	@Override
	public E get(K key){
		RBNode<Data<K, E>> p = root;
		while( p != null ){
			if( key.compareTo( p.getElement().key ) < 0 ){
				p = p.getLeftChild();
			}else if( key.compareTo( p.getElement().key ) > 0 ){
				p = p.getRightChild();
			}else{
				return p.getElement().element;
			}
		}
		return null;
	}
	@Override
	public E put(K key, E element){
		RBNode<Data<K, E>> p = root, pp = null;
		while( p != null ){
			pp = p;
			if(key.compareTo(p.getElement().key) < 0 ){
				p= p.getLeftChild();
			}else if( key.compareTo( p.getElement().key ) > 0 ){
				p = p.getRightChild();
			}else{
				E elementToReturn = p.getElement().element;
				p.getElement().element = element;
				return elementToReturn;
			}
		}
		RBNode<Data<K,E>> r = new RBNode<Data<K,E>>(new Data<K, E>(key,element ), pp );
		if( root != null ){
			if( key.compareTo( pp.getElement().key )<0){
				pp.setLeftChild(r);
			}else{
				pp.setRightChild(r);
			}
		}else{
			root=r;
		}
		balance(r);
		return null;
	}
	@Override
	public E remove(K key){
		RBNode<Data<K, E>> p = root, pp = null;
		while( p != null && !p.getElement().key.equals( key ) ){
			pp = p;
			if( key.compareTo( p.getElement().key ) < 0 ){
				p=p.getLeftChild();
			}else{
				p=p.getRightChild();
			}
		}
		if( p == null ){
			return null;
		}
		E theElement = p.getElement().element;

		if( p.getLeftChild() != null && p.getRightChild() != null ){
			RBNode<Data<K, E>> s = p.getLeftChild();
			RBNode<Data<K, E>> ps = p;
			while( s.getRightChild() != null ){
				ps = s;
				s = s.getRightChild();
			}
			p.setElement(s.getElement());
			p = s;
			pp = ps;
		}
		
		RBNode<Data<K, E>> c;
		if( p.getLeftChild() == null ){
			c = p.getRightChild();
		}else{
			c = p.getLeftChild();
		}
		if( p == root ){
			root = c;
			if(c!=null){
				c.setParent(null);
			}
			return theElement;			
		}else{
			if(c!=null){
				c.setParent(pp);
				c.setBlack(true);
			}
			if( p == pp.getLeftChild() ){
				pp.setLeftChild(c);
			}else{
				pp.setRightChild(c);
			}
		}
		return theElement;
	}
	////////////////METHODS FROM DICTIONARY*/

	public void balance(RBNode<Data<K,E>> r){
		RBNode<Data<K,E>> pr= r.getParent(); 
		while ((r!=root) && !pr.isBlack() ) {			
			RBNode<Data<K,E>> gr= pr.getParent();
			if (pr==gr.getLeftChild()) {
				RBNode<Data<K,E>> uncle = gr.getRightChild();
				if (uncle!=null&&!uncle.isBlack()) {
					pr.setBlack(true);
					uncle.setBlack(true);
					gr.setBlack(false);
					r = gr;
					pr=r.getParent();
				}else {
               				if ( r == pr.getRightChild() ) {
						r = pr;
                   				lRotate(r);
						pr=r.getParent();
						gr=pr.getParent();
                   			}
					pr.setBlack(true);
					gr.setBlack(false);
					rRotate(gr);
				}
			}else{
				RBNode<Data<K,E>> uncle = gr.getLeftChild();
				if ( uncle!=null&&!uncle.isBlack()) {
					pr.setBlack(true);
					uncle.setBlack(true);
					gr.setBlack(false);
					r = gr;
					pr=r.getParent();
				}else {
               				if ( r == pr.getLeftChild() ) {
						r = pr;
                   				rRotate(r);
						pr=r.getParent();
						gr=pr.getParent();
                   			}
					pr.setBlack(true);
					gr.setBlack(false);
                                        lRotate(gr);
				}
			}
		}
		root.setBlack(true);		
	}

	private void lRotate(RBNode<Data<K,E>> r){
		RBNode<Data<K,E>> y=r.getRightChild();
		r.setRightChild(y.getLeftChild());
		if (y.getLeftChild() != null ){
			y.getLeftChild().setParent(r);
		}
		y.setParent(r.getParent());
		if (r.getParent()==null ){
			root=y;
		}else{
			if(r.getParent().getLeftChild()==r){
				r.getParent().setLeftChild(y);
			}else{
				r.getParent().setRightChild(y);
			}
		}
		y.setLeftChild(r);
		r.setParent(y);
	}

	private void rRotate(RBNode<Data<K,E>> r){
		RBNode<Data<K,E>> y=r.getLeftChild();
		r.setLeftChild(y.getRightChild());
		if (y.getRightChild() != null ){
			y.getRightChild().setParent(r);
		}
		y.setParent(r.getParent());
		if (r.getParent()==null ){
			root=y;
		}else{
			if(r.getParent().getLeftChild()==r){
				r.getParent().setLeftChild(y);
			}else{
				r.getParent().setRightChild(y);
			}
		}
		y.setRightChild(r);
		r.setParent(y);
	}

	@Override
	public String toString(){
		StringBuilder s = new StringBuilder("levelOrderTree[ ");		
		ArrayQueue<RBNode<Data<K,E>>> q = new ArrayQueue<RBNode<Data<K,E>>>( );
		RBNode<Data<K,E>> t = root;
		while( t != null ){
			s.append(", ").append(t);
			if( t.getLeftChild() != null ){
				q.put( t.getLeftChild() );
			}
			if( t.getRightChild() != null ){
				q.put( t.getRightChild() );
			}
			t = q.remove( );
		}
                return s.append("]").toString();
	}

	public static void main(String[] args){
		RedBlackTree<Integer,Character> tree= new RedBlackTree<Integer,Character>();
		tree.put(1,'a');
		System.out.println(tree);
		tree.put(2,'b');
		System.out.println(tree);
		tree.put(3,'c');
		System.out.println(tree);
		tree.put(4,'d');
		System.out.println(tree);
		tree.put(5,'e');
		System.out.println(tree);
		tree.put(6,'f');
		System.out.println(tree);
		tree.put(7,'g');
		System.out.println(tree);
		tree.put(8,'h');
		System.out.println(tree);
		tree.put(9,'i');
		System.out.println(tree);
		tree.put(10,'j');
		System.out.println(tree);
		tree.put(11,'k');
		System.out.println(tree);
		System.out.println("removed: "+tree.remove(6));
		System.out.println(tree);
	}
}

