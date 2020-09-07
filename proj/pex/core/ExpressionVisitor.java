package pex.core;

import java.util.TreeSet;

public class ExpressionVisitor implements Visitor {
	
	private TreeSet <Identifier> _identifiers = new TreeSet<>();
	private TreeSet <Identifier> _initiliazedIdentifiers = new TreeSet<>();
	
    public void visit(Identifier identifier) {
		_identifiers.add(identifier);
    }
    
    public void visit(Set set) {
			Identifier identifier = (Identifier)set.getFirstArgument();
			_initiliazedIdentifiers.add(identifier);
    }
    
    public void visit(Add element) {
	}
	public void visit(And element) {
	}
	public void visit(BinaryExpression element) {
	}
	public void visit(Call element) {
	}
	public void visit(CompositeExpression element) {
	}
	public void visit(Div element) {
	}
	public void visit(Eq element) {
	}
	public void visit(Expression element) {
	}
	public void visit(Ge element) {
	}
	public void visit(Gt element) {
	}
	public void visit(If element) {
	}
	public void visit(IntegerLiteral element) {
	}
	public void visit(Le element) {
	}
	public void visit(Literal element) {
	}
	public void visit(Lt element) {
	}
	public void visit(Mod element) {
	}
	public void visit(Mul element) {
	}
	public void visit(Neg element) {
	}
	public void visit(Ne element) {
	}
	public void visit(Not element) {
	}
	public void visit(Or element) {
	}
	public void visit(Print element) {
	}
	public void visit(Program element) {
	}
	public void visit(ReadI element) {
	}
	public void visit(ReadS element) {
	}
	public void visit(Seq element) {
	}
	public void visit(StringLiteral element) {
	}
	public void visit(Sub element) {
	}
	public void visit(TrenaryExpression element) {
	}
	public void visit(UnaryExpression element) {
	}
	public void visit(VariadicExpression element) {
	}
	public void visit(While element) {
	}
    
    public TreeSet <Identifier> getIdentifiers() {
		return _identifiers;
	}
    
    public TreeSet<Identifier> getUninitializedIdentifiers() {
		TreeSet<Identifier> uninitialized = _identifiers;
		uninitialized.removeAll(_initiliazedIdentifiers);
		return uninitialized;
	}
}

