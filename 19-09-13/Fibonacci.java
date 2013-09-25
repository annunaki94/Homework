import java.util.Scanner;

public class Fibonacci{
	
	public static int getFibonacci(int pos){		
		int fib=0;
		int fibPast=1;
		int fibPast2=0;

		for(int i=0; i<pos; i++){
			fibPast2=fibPast;
			fibPast=fib;			
			fib=fibPast+fibPast2;
		}				
		return fib;		
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
