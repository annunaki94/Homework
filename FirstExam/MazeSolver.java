
import java.util.Stack;

public class MazeSolver{
	private static final int[] dr={0,-1,0,1};
	private static final int[] dc={-1,0,1,0};

	public static int solve(int[][] maze){
		int shortestWay= maze.length*maze.length;
		Stack<Position> pos= new Stack<>();
		int[][] newMaze= new int[maze.length+2][maze.length+2];
		for(int i=0; i<maze.length;i++){
			for(int j=0; j<maze.length; j++){
				newMaze[i+1][j+1]=maze[i][j];
			}
		}
		for(int i=0; i<newMaze.length;i++){
			newMaze[i][0]=1;
			newMaze[0][i]=1;
			newMaze[i][newMaze.length-1]=1;
			newMaze[newMaze.length-1][i]=1;
		}
		
		boolean solveAble=false;
		pos.add(new Position(1,1,0));
		while(!pos.isEmpty()){
			Position current= pos.pop();
			System.out.println("Position: "+current.getX()+","+current.getY()+" Length: "+current.getDistance());
			newMaze[current.getX()][current.getY()]=current.getDistance();
			for(int i=0; i<4;i++){
				Position son= new Position(current.getX()+dr[i],current.getY()+dc[i],current.getDistance()+1);
				if(newMaze[son.getX()][son.getY()]==0||newMaze[son.getX()][son.getY()]>son.getDistance()){
					if(son.getX()==maze.length&&son.getY()==maze.length){
						int length=son.getDistance();
						shortestWay=length<shortestWay?length:shortestWay;
						solveAble=true;
					}else{					
						pos.push(son);						
					}
				}
			}			
		}
		return solveAble?shortestWay:-1;
	}

	public static void main(String[] args){
		int[][] maze= { {0,0,0,0,0},
				{0,1,1,1,1},
				{0,1,0,0,0},
				{0,1,0,1,0},
				{0,0,0,1,0}};
		for(int i=0;i<maze.length;i++){
			for(int j=0; j<maze.length; j++){
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}

		System.out.println("Shortest way length: "+ solve(maze));
	}

	private static class Position{
		private int distance;		
		private int x;
		private int y;
		public Position(int x, int y,int distance){
			this.distance=distance;
			this.x=x;
			this.y=y;
		}

		public int getDistance(){
			return this.distance;
		}

		public int getX(){
			return this.x;		
		}

		public int getY(){
			return this.y;		
		}
	}
}

