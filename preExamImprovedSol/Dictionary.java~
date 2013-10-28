import java.util.Scanner;
import java.util.ArrayList;

public class Dictionary{
	private ArrayList<String> words;

	public Dictionary(ArrayList<String> words){
		this.words=words;
	}
	public void playGame(){
		Scanner scan= new Scanner(System.in);
		for(String s: words){
			System.out.println(s);
		}
		System.out.println("Elija una palabra de las listadas");
		int start=0;
		int end= words.size()-1;
		
		while(start<=end){
			int mid = (end-start)/2 + start;
			System.out.println("¿Su palabra es \""+words.get(mid)+"\"? (s/n)");
			if(scan.next().charAt(0)=='s'){
				return;
			}
			System.out.println("¿Su palabra es menor lexicográficamente? (s/n)");
			if(scan.next().charAt(0)=='s'){
				end=mid-1;
			}else{
				start=mid+1;
			}
		}
	}
	public static void main(String[] args){
		ArrayList<String> w= new ArrayList<>();
		w.add("A");
		w.add("B");
		w.add("C");
		w.add("D");
		w.add("E");
		w.add("F");
		w.add("G");
		w.add("H");
		w.add("I");
		w.add("J");
		Dictionary dic= new Dictionary(w);
		dic.playGame();
	}
}
