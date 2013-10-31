
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class ThirdPoint{

	public static <T extends Comparable<? super T>> T getMaximal(List<T> list){
		Collections.sort(list);
		return list.get(list.size()-1);
	}
	
	public static void main(String[] args){
		ArrayList<Integer> integers= new ArrayList<>();
		integers.add(1);
		integers.add(2);
		integers.add(6);
		integers.add(4);
		integers.add(5);

		System.out.println("Maximal: "+getMaximal(integers));
	}

}
