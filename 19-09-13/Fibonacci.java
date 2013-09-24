import java.util.Scanner;

public class Fibonacci{
	
	public static int getFibonacci(int pos){
		if(pos>2){
			return getFibonacci(pos-1)+getFibonacci(pos-2);
		}
		if(pos==2){
			return 1;		
		}
		return 0;
	}
	public static void main(String[] args){
		boolean invalid= false;
		int posicion=0;	
		do{		
			System.out.println("Inserte la posición de la sucesión bonacci que desea");
			try{
				Scanner scan = new Scanner(System.in);
				posicion = scan.nextInt();
				invalid=false;
			}catch(Exception ex){
				System.out.println("Numero inválido, intentelo nuevamente");
				invalid=true;
			}
		}while(invalid);
		System.out.println("Numero Fibonacci en la posición "+posicion+": "+getFibonacci(posicion));
	}

}
