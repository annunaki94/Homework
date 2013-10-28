package preExam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DicctionaryGame {
    
    private static ArrayList<String> words= new ArrayList<>();
    
    public static void showWords(){
        for(String w: words){
            System.out.println(w);
        }
    }
    
    public static String guessWord(){
        Scanner scan = new Scanner(System.in);
        Collections.sort(words);
        int start = 0;
        int end = words.size() - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int comparation;
            System.out.println("¿Su palabra es \""+words.get(mid)+"\"? (s/n)");
            if(scan.next().charAt(0)=='s'){
                return words.get(mid);
            }
            
            System.out.println("¿Su palabra es menor lexicográficamente? (s/n)");
            if(scan.next().charAt(0)=='s'){
                comparation=-1;
            }else{
                comparation=1;
            }
                        
            if (comparation < 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            } 
        }        
        return "not_to_be_found";
    }
    
    public static void main(String[] args){
        words.add("casa");
        words.add("cometa");
        words.add("zorro");
        words.add("bus");
        words.add("escalera");
        words.add("loro");
        words.add("gato");
        words.add("perro");
        
        
        System.out.println("Seleccione una palabra");
        showWords();
        System.out.println("Su palabra es: "+guessWord());        
    }    
}
