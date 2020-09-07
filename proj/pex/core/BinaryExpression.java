package pex.core;

public abstract class BinaryExpression extends CompositeExpression {
	
	private Expression _firstArg;
	private Expression _secondArg;
	
	public BinaryExpression (Expression firstArg, Expression secondArg) {
		_firstArg = firstArg;
		_secondArg = secondArg;
	}
	
	public Expression getFirstArgument() {
		return _firstArg;
	}

	public Expression getSecondArgument() {
		return _secondArg;
	}
	
	public abstract String getOperationName();

	public String getAsText() {
		return "(" + this.getOperationName() + " " + this.getFirstArgument().getAsText() + " " +this.getSecondArgument().getAsText() + ")";
	}
	public void accept(Visitor visitor){
		super.accept(visitor);
		_firstArg.accept(visitor);
		_secondArg.accept(visitor);
		visitor.visit(this);
	}
	
}
