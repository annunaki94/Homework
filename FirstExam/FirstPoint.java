
import java.util.ArrayList;
import java.util.List;

public class FirstPoint {

	public static void print(List<? extends Number> list){
		for(Number n: list)
			System.out.print(n+" ");
		System.out.println();
	}
	
	public static void main(String[] args){
		ArrayList<Integer> integers= new ArrayList<>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		integers.add(4);
		integers.add(5);

		print(integers);
		System.out.println("Success");
	}
}
