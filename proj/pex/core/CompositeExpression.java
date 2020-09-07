package pex.core;

public abstract class CompositeExpression extends Expression {
	public void accept(Visitor visitor) {
		super.accept(visitor);
		visitor.visit(this);
	}
}
