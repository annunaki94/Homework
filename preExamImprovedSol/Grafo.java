
public class Grafo<T>{
	private T[] vertices;
	private Integer[][] matrix;
	private boolean[] visited;

	public Grafo(T[] V, Integer[][] M){
		this.vertices=V;
		this.visited= new boolean[V.length];
		setMatrix(M);
	}
	
	public <T> void setMatrix(Integer[][] M){
		if(M.length==this.vertices.length&&M.length>0&&M[0].length==M.length){
			this.matrix=M;
		}
		else{
			throw new IndexOutOfBoundsException("Invalid size of adyacence matrix");
		}
	}

	public Integer[][] getMatrix(){
		return this.matrix;
	}


	public T[] getVertices(){
		return this.vertices;
	}

	public void printDFS(int index){
		if(index>=0&& index<this.vertices.length){
			System.out.println("DFS order from index "+index+" (index:value):");
			for(int i=0; i<visited.length;i++){				
				visited[i]=false;				
			}
			DFS(index);
		}else{
			throw new IndexOutOfBoundsException("Invalid size of adyacence matrix");
		}
	}
	private void DFS(int index){
		System.out.println(index+":"+this.vertices[index]);
		this.visited[index]=true;
		for(Integer i=0;i<this.matrix[index].length;i++){
			if(this.matrix[index][i]==1&&!this.visited[i]){
				DFS(i);
			}
		}
	}
	
	public static void main(String[] args){
		Integer[] numbers= {1,2,3,4,5,6,7,8};		
		Integer[][] matriz= {{0,1,0,0,1,0,0,1},
				     {1,0,1,0,1,0,0,0},
				     {0,1,0,1,0,0,0,0},
				     {0,0,1,0,1,1,0,0},
				     {1,1,0,1,0,0,0,1},
				     {0,0,0,1,0,0,0,0},
				     {0,0,0,0,0,0,0,0},
				     {1,0,0,0,1,0,0,0}
		};
		Grafo<Integer> graph= new Grafo<>(numbers,matriz);
		graph.printDFS(3);
	}	
}
