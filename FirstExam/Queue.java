

public class Queue<T>{
	int front;
	int rear;  
	T[] queue;

	@SuppressWarnings( "unchecked" )
	public Queue(int initialCapacity){
		if( initialCapacity < 1 ){
			throw new IllegalArgumentException( "initialCapacity must be >= 1" );
		}
      		queue = (T[]) new Object[initialCapacity+1];
      		front = rear = 0;
   	}

   	public Queue(){
		this( 10 );
	}

	public boolean isEmpty(){
		return rear==front;
	}

	public T getFrontElement(){
		if(isEmpty()){
			return null;
		}
		return queue[(front+1)%queue.length];
	}
	
	public T getRearElement(){
		if(isEmpty()){
			return null;
		}
		return queue[rear];
	}

	@SuppressWarnings( "unchecked" )
	public void put(T element){
		if((rear+1)%queue.length==front){
			T[] newQueue= (T[]) new Object[2*queue.length];
			int start = (front + 1) % queue.length;
         		if( start < 2 ){
            	            System.arraycopy( queue, start, newQueue, 0, queue.length - 1 );
			}else{
			        System.arraycopy( queue, start, newQueue, 0, queue.length - start );
            			System.arraycopy( queue, 0, newQueue, queue.length - start, rear + 1 );
         		}
			front = newQueue.length - 1;
         		rear = queue.length - 2;
		        queue = newQueue;
		}
		rear = ( rear + 1 ) % queue.length;
    		queue[ rear ] = element;		
	}
   
	public T remove(){
		if(isEmpty()){
			return null;
		}
		front=(front+1)%queue.length;
		T ret= queue[front];
		queue[front]=null;
		return ret;
	}
}
