package pex.core;

import java.util.*;

public class If extends TrenaryExpression {
	
	public If (Expression firstArg, Expression secondArg, Expression thirdArg) {
		
		super(firstArg,secondArg,thirdArg);
	}
	
	public Literal evaluate() {
		Expression x = this.getFirstArgument();
		IntegerLiteral n1 = (IntegerLiteral)x.evaluate();
		if (n1.intValue() != 0) {
			return this.getSecondArgument().evaluate();
		}
		else {
			return this.getThirdArgument().evaluate();
		}
	}
	
	public String getOperationName() {
		return "if";
	}
	
	public void accept(Visitor visitor){
		super.accept(visitor);
		visitor.visit(this);
	}
}
