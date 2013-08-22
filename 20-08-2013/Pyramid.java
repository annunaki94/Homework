import java.util.Scanner;

public class Pyramid{

	public static void main(String args[]){
		System.out.println("Ingrese la altura de la piramide");		
		boolean isInteger= false;
		int altura=1;		
		do{
			try{
				Scanner sc= new Scanner(System.in);
				altura= sc.nextInt();
				isInteger=true;			
			}catch(Exception ex){
				System.out.println("Número inválido, vuelva a intentarlo");
				isInteger=false;
			}
		}while(!isInteger);		
				
		for(int i=0; i<altura;i++){
			for(int k=i;k<altura-1;k++){ 
				System.out.print(" ");}
			for(int j=0; j<i+1 ; j++){						
				System.out.print("* ");}
			System.out.println();
		}	
	}
}
