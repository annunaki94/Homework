import java.util.Scanner;

public class Pyramid{

	public static void main(String args[]){
		System.out.println("Ingrese la altura de la piramide");
		Scanner sc= new Scanner(System.in);
		int altura= sc.nextInt();		
		for(int i=0; i<altura;i++){
			for(int k=i;k<altura-1;k++){ 
				System.out.print(" ");}
			for(int j=0; j<i+1 ; j++){						
				System.out.print("* ");}
			System.out.println();
		}	
	}
}
