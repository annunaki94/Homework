
import java.util.ArrayList;

public class Termino{

	private ArrayList<Termino> operandos;
	private String valor;

	public Termino(String val){
		this.operandos= new ArrayList<>();
		this.valor=val;
	}

	public void addOperando(Termino term){
		this.operandos.add(term);
	}
	
	public ArrayList<Termino> getOperandos(){
		return this.operandos;
	}

	public void setValor(String value){
		this.valor=value;
	}

	public String getValor(){
		return this.valor;
	}

	public boolean isFull(){
		return operandos.size()==2;
	}

	public boolean isOperator(){
		return valor.equals("*")||valor.equals("/")||valor.equals("+")||valor.equals("-");
	}

	public String toInfix(){
		if(!isFull()){
			return this.getValor();
		}
		return "("+operandos.get(0).toInfix()+valor+operandos.get(1).toInfix()+")";
	}

	public String toPrefix(){
		if(!isFull()){
			return this.getValor()+" ";
		}
		return valor+operandos.get(0).toPrefix()+operandos.get(1).toPrefix();
	}

	public String toPostfix(){
		if(!isFull()){
			return " "+this.getValor();
		}
		return operandos.get(0).toPostfix()+operandos.get(1).toPostfix()+valor;
	}
}
