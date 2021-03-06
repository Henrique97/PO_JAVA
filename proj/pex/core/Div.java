package pex.core;

public class Div extends BinaryExpression {
	
	public Div (Expression firstArg, Expression secondArg) {
		
		super(firstArg,secondArg);
	}
	public Literal evaluate() {
		IntegerLiteral n = new IntegerLiteral(0);
		IntegerLiteral n1 = (IntegerLiteral)getFirstArgument().evaluate();
		IntegerLiteral n2 = (IntegerLiteral)getSecondArgument().evaluate();
		n.setValue(n1.intValue() / n2.intValue());
		return n;
	}
	
	
	public String getOperationName() {
		return "div";
	}
	
	public void accept(Visitor visitor){
		super.accept(visitor);
		visitor.visit(this);
	}
}
