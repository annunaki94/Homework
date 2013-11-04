
import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;

public class Expression{

	public static final String[] ALLOWED_OPS= {"*","/","+","-"};
	public static final int TO_INFIX=1;
	public static final int TO_PREFIX=2;
	public static final int TO_POSTFIX=3;
	public static final int FROM_INFIX=1;
	public static final int FROM_PREFIX=2;
	public static final int FROM_POSTFIX=3;
	private Termino t;

	public Expression(String expression, int format){
		Stack<Termino> terms= new Stack<>();		
		ArrayList<Termino> temporal= new ArrayList<>();
		
		int i=0;		
		while(i==0||!terms.isEmpty()&&i<expression.length()){
			char c=expression.charAt(i++);
			boolean number=false;
			StringBuilder term= new StringBuilder(""+c);
			while(c>='0'&&c<='9'){
				number=true;
				if(i<expression.length()){
					c=expression.charAt(i);
					if(c>='0'&&c<='9'){
						term.append(""+c);
						i++;
					}
				}else{
					break;
				}
			}
			String val=term.toString();
			if(number){
				Termino te= new Termino(val);
				switch(format){			
					case FROM_INFIX:{
						if(!terms.isEmpty()&&terms.peek().isOperator()&&!terms.peek().isFull()){
							terms.peek().addOperando(te);
						}else{
							terms.push(te);
						}
						break;}			
					case FROM_PREFIX:{
						terms.peek().addOperando(te);
						break;}
					case FROM_POSTFIX:{
						terms.push(te);
						break;}
				}
			}			
			for(int j=0; j<ALLOWED_OPS.length;j++){
				if(val.equals(ALLOWED_OPS[j])){
					Termino te= new Termino(val);
					switch(format){			
						case FROM_INFIX:{
							te.addOperando(terms.pop());
							terms.push(te);
							break;}			
						case FROM_PREFIX:{
							if(!terms.isEmpty()){
								terms.peek().addOperando(te);
							}
							terms.push(te);
							break;}	
						case FROM_POSTFIX:{
							Termino sec= terms.pop();
							te.addOperando(terms.pop());
							te.addOperando(sec);
							terms.push(te);
							break;}			
					}				
					continue;
				}
			}
			if(format==FROM_PREFIX&&terms.peek().isFull()){
					t=terms.pop();
			}			
		}
		if(!terms.isEmpty()){
			t=terms.pop();
		}		
	}

	public String transform(int toFormat){
		switch(toFormat){
			case TO_INFIX:{
				return t.toInfix();				
			}
			case TO_PREFIX:{
				return t.toPrefix();				
			} 
			case TO_POSTFIX:{
				return t.toPostfix();				
			}	
		}
		return null;	
	}

	public int evaluar(){
		return evaluar(this.t);
	}
	
	private int evaluar(Termino te){
		if(te.getValor().equals("*")){
			return evaluar(te.getOperandos().get(0))*evaluar(te.getOperandos().get(1));
		}else if(te.getValor().equals("/")){
			return evaluar(te.getOperandos().get(0))/evaluar(te.getOperandos().get(1));
		}else if(te.getValor().equals("+")){
			return evaluar(te.getOperandos().get(0))+evaluar(te.getOperandos().get(1));
		}else if(te.getValor().equals("-")){
			return evaluar(te.getOperandos().get(0))-evaluar(te.getOperandos().get(1));
		}		
		return Integer.parseInt(te.getValor());
	}
	
	public static void main(String[] args){
		Scanner scan= new Scanner(System.in);		
		System.out.println("Ingrese la expresión a transformar: ");
		String originalExp= scan.nextLine();
		System.out.println("¿En que formato se encuentra?\n1.Infix\n2.Prefix\n3.Postfix");
		int format= scan.nextInt();
		Expression e= new Expression(originalExp,format);
		System.out.println("Equivalente infix: "+e.transform(Expression.TO_INFIX));
		System.out.println("Equivalente prefix: "+e.transform(Expression.TO_PREFIX));
		System.out.println("Equivalente postfix: "+e.transform(Expression.TO_POSTFIX));
		System.out.println("Solución: "+e.evaluar());
	}
}
