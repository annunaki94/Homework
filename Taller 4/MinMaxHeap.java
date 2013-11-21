public class MinMaxHeap<T extends Comparable<? super T>>{
	private T[] heap;
	private int size;
	
	public MinMaxHeap(int initialCapacity){
		if( initialCapacity < 1 ){
       			throw new IllegalArgumentException( "initialCapacity must be >= 1" );
		}
		heap = (T[]) new Comparable[initialCapacity+1];
      		size = 0;
	}
	
	public MinMaxHeap(){
		this(10);
	}

	public boolean isEmpty(){
		return size==0;
	}

	public int size(){
		return this.size;
	}

	public T getMax(){
		if(size==0){
			return null;
		}
		if(size>2){
			return (heap[3].compareTo(heap[2])<0)?heap[2]:heap[3];
		}
		return heap[size];
	}

	public T getMin(){
		return (size==0)?null:heap[1];
	}

	public void put(T theElement){
		if(size==heap.length-1){
			T[] old= heap;
			heap = (T[]) new Comparable[heap.length*2];
			for(int i=0; i<old.length; i++){
				heap[i]=old[i];
			}
		}
		int currentNode=++size;
		int level= (int) (Math.log(currentNode)/Math.log(2));
		
		int pa=currentNode/2;
		int grandPa=pa/2;

		if(currentNode>1&&(level%2==0&&heap[pa].compareTo(theElement)<0||
		   		   level%2!=0&&heap[pa].compareTo(theElement)>0)){
			heap[currentNode]=heap[pa];
			currentNode=pa;
			pa=grandPa;
			level--;		
		}

		while(currentNode!=1){			
			grandPa=pa/2;
			if(level<2&&theElement.compareTo(heap[pa])>=0){
				break;	
			}else if(level%2==0&&theElement.compareTo(heap[grandPa])>=0||
				 level%2!=0&&theElement.compareTo(heap[grandPa])<=0){
				break;
			}			
			heap[currentNode]= heap[grandPa];
			currentNode=grandPa;
			level=level-2;	
		}		
		heap[currentNode]=theElement;		
	}

	public T deleteMax(){
		
		if(size==0){
			return null;
		}

		T maxElement;
		int currentNode;

		if(size>2){
			if(heap[3].compareTo(heap[2])<0){
				maxElement=heap[2];
				currentNode=2;
			}else{
				maxElement=heap[3];
				currentNode=3;
			}
		}else{
			return heap[size--];
		}
		
		T lastElement = heap[size--];
		
		int level=1;
		int grandChild=currentNode*4;
		

		while( grandChild <= size ){
			int max=grandChild;			
			for(int i=0; grandChild+i<=size&&i<3; i++){
				if(heap[grandChild+i].compareTo(heap[max])>0){
					max= grandChild+i;
				}
			}
			grandChild=max;
			if(lastElement.compareTo(heap[grandChild]) >= 0 ){
				break;
			}
			level+=2;
			heap[currentNode] = heap[grandChild];
			currentNode = grandChild;
			grandChild *= 4;
		}
		
                int child=currentNode*2;
		if(child<=size){
			if(child+1<=size&&heap[child].compareTo(heap[child+1])<0){
				child++;
			}
			if(heap[child].compareTo(lastElement)<0){
				heap[ currentNode ] = lastElement;
				return maxElement;
			}else{
				heap[currentNode]=heap[child];
				currentNode=child;
				level++;
			}
		}
                int pa=currentNode/2;
                if(heap[pa].compareTo(lastElement)>0){
                        heap[currentNode]=heap[pa];
                           currentNode=pa;
                           level--;
                }
                
		while(level%2==0&&level>2){
                        pa=currentNode/2;
                        int grandPa=pa/2;
			if(lastElement.compareTo(heap[grandPa])>=0){
				break;
			}			
			heap[currentNode]= heap[grandPa];
			currentNode=grandPa;
			level=level-2;	
		}		
		heap[currentNode] = lastElement;		
		return maxElement;
	}

	public T deleteMin(){
		if(size==0){
			return null;		
		}
		T minElement= heap[1];
		int currentNode=1;
		int level =0;
		int grandChild=4;
		
		T lastElement=heap[size--];

		while( grandChild <= size ){
			int min=grandChild;			
			for(int i=0; grandChild+i<=size&&i<3; i++){
				if(heap[grandChild+i].compareTo(heap[min])<0){
					min= grandChild+i;
				}
			}
			grandChild=min;
			if(lastElement.compareTo(heap[grandChild]) <= 0 ){
				break;
			}
			level+=2;
			heap[currentNode] = heap[grandChild];
			currentNode = grandChild;
			grandChild *= 4;
		}
		int child=currentNode*2;
		if(child<=size){
			if(child+1<=size&&heap[child].compareTo(heap[child+1])>0){
				child++;
			}
			if(heap[child].compareTo(lastElement)>0){
				heap[ currentNode ] = lastElement;
				return minElement;
			}else{
				heap[currentNode]=heap[child];
				currentNode=child;
				level++;
			}
		}

		int pa=currentNode/2;
		if(level%2!=0){
			pa/=2;
		}
                if(heap[pa].compareTo(lastElement)<0){
                        heap[currentNode]=heap[pa];
                           currentNode=pa;
                           level--;
                }

		while(level%2!=0&&level>2){			
                        pa=currentNode/2;
                        int grandPa=pa/2;
                        if(lastElement.compareTo(heap[grandPa])<=0){
				break;
			}			
			heap[currentNode]= heap[grandPa];
			currentNode=grandPa;
			level=level-2;	
		}		
		heap[currentNode] = lastElement;
		
		return minElement;               
	}

	@Override
 	public String toString( ){
		StringBuilder s = new StringBuilder( );
		s.append("The " + size + " elements are [ ");
		if( size > 0 ){
			s.append(heap[1].toString() );
			for( int i = 2; i <= size; i++ ){
				s.append( ", " + heap[i].toString() );
			}
		}
      		s.append( " ]" );
		return new String( s );
	}

	public static void main(String[] args){
		MinMaxHeap<Integer> heap= new MinMaxHeap<>();
		heap.put(6);
		heap.put(81);
		heap.put(87);
		heap.put(14);
		heap.put(17);
		heap.put(12);
		heap.put(28);
		heap.put(71);
		heap.put(25);
		heap.put(80);
		heap.put(20);
		heap.put(52);
		heap.put(78);
		heap.put(31);
		heap.put(42);
				
		System.out.println(heap);
		System.out.println("Max: "+heap.getMax()+" Min: "+heap.getMin()+"\n-----------------------------");
		System.out.println("Min Deleted: "+heap.deleteMin());
		System.out.println(heap);
		System.out.println("Min Deleted: "+heap.deleteMin());
		System.out.println(heap);
		System.out.println("Min Deleted: "+heap.deleteMin());
		System.out.println(heap);
		System.out.println("Max Deleted: "+heap.deleteMax());
		System.out.println(heap);
		System.out.println("Max Deleted: "+heap.deleteMax());
		System.out.println(heap);
		System.out.println("Max Deleted: "+heap.deleteMax());
		System.out.println(heap+"\n---------------------------------------");
		
		/*SALIDA:
The 15 elements are [ 6, 81, 87, 14, 17, 12, 28, 71, 25, 80, 20, 52, 78, 31, 42 ]
Max: 87 Min: 6
-----------------------------
Min Deleted: 6
The 14 elements are [ 12, 81, 87, 14, 17, 42, 28, 71, 25, 80, 20, 52, 78, 31 ]
Min Deleted: 12
The 13 elements are [ 14, 81, 87, 25, 17, 42, 28, 71, 31, 80, 20, 52, 78 ]
Min Deleted: 14
The 12 elements are [ 17, 81, 87, 25, 20, 42, 28, 71, 31, 80, 78, 52 ]
Max Deleted: 87
The 11 elements are [ 17, 81, 52, 25, 20, 42, 28, 71, 31, 80, 78 ]
Max Deleted: 81
The 10 elements are [ 17, 80, 52, 25, 20, 42, 28, 71, 31, 78 ]
Max Deleted: 80
The 9 elements are [ 17, 78, 52, 25, 20, 42, 28, 71, 31 ]
---------------------------------------

		*/		
	}
}
