
import java.util.ArrayList;

public class Conjuntos{

	public static void printIndexes(ArrayList<Integer> L, ArrayList<Integer> P){
		for(Integer i: P){
			System.out.print(((i>=0&&i<L.size())?L.get(i):"no_such_position")+" ");
		}
		System.out.println();
	}

	public static <T> ArrayList<T> getIntersection(ArrayList<T> L1, ArrayList<T> L2){
		ArrayList<T> response= new ArrayList<>();	
		for(T t: L1){
			if(!response.contains(t)&&L2.contains(t)){
				response.add(t);
			}
		}
		return response;
	}

	public static <T> ArrayList<T> getUnion(ArrayList<T> L1, ArrayList<T> L2){
		ArrayList<T> response= new ArrayList<>();	
		for(T t: L1){
			if(!response.contains(t)){
				response.add(t);
			}
		}
		for(T t: L2){
			if(!response.contains(t)){
				response.add(t);
			}
		}
		return response;
	}

	public static void main(String[] args){
		ArrayList<Integer> L= new ArrayList<>();
		ArrayList<Integer> P= new ArrayList<>();
		L.add(10);		
		L.add(14);
		L.add(2);
		L.add(5);
		L.add(55);
		L.add(6);
		L.add(8);
		P.add(5);
		P.add(7);
		P.add(4);
		P.add(3);
		P.add(2);
		printIndexes(L,P);

		System.out.print("intersection: ");
		ArrayList<Integer> inter= getIntersection(L,P);
		for(Integer i: inter){
			System.out.print(i+" ");
		}
		System.out.println();	

		System.out.print("union: ");
		ArrayList<Integer> union= getUnion(L,P);
		for(Integer i: union){
			System.out.print(i+" ");
		}
		System.out.println();	
	}


}
