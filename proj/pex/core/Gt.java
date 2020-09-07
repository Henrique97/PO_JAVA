package pex.core;

public class Gt extends BinaryExpression {
	
	public Gt (Expression firstArg, Expression secondArg) {
		
		super(firstArg,secondArg);
	}
	public Literal evaluate() {
		IntegerLiteral n = new IntegerLiteral(0);
		IntegerLiteral n1 = (IntegerLiteral)getFirstArgument().evaluate();
		IntegerLiteral n2 = (IntegerLiteral)getSecondArgument().evaluate();
		if (n1.intValue() > n2.intValue()) {
			n.setValue(1);
		}
			else
			{
				n.setValue(0);
			}
		return n;
	}
	public String getOperationName() {
		return "gt";
	}
	
	public void accept(Visitor visitor){
		super.accept(visitor);
		visitor.visit(this);
	}
}
