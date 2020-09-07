package pex.core;
import java.util.*;

public class And extends BinaryExpression {
	
	public And (Expression firstArg, Expression secondArg) {
		super(firstArg,secondArg);
	}

	public Literal evaluate() {
		IntegerLiteral n = new IntegerLiteral(0);
		IntegerLiteral n1 = (IntegerLiteral)getFirstArgument().evaluate();
		if (n1.intValue() != 0) {
		IntegerLiteral n2 = (IntegerLiteral)getSecondArgument().evaluate();
		if (n2.intValue() != 0)
			n.setValue(1);
		}
			else
			{
				n.setValue(0);
			}
		return n;
	}
	
	public String getOperationName() {
		return "and";
	}
	
	public void accept(Visitor visitor){
		super.accept(visitor);
		visitor.visit(this);
	}
}
