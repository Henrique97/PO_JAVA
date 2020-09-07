package pex.core;

public class IntegerLiteral extends Literal {	
	
		int _value;
	
	public IntegerLiteral (Integer value) {
	
		_value = value;
	}
	
	public int intValue() {
		
		return _value;
	}
	
	public void setValue(int value) {
		
		_value = value;
	}
	
	public String getAsText() {
		
		return "" + this.intValue();
	}
	
	public void accept(Visitor visitor){
		super.accept(visitor);
		visitor.visit(this);
	}
	
	public Literal evaluate() {
		return this;	
	}
}
