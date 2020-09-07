package pex.core;

public class Call extends UnaryExpression {
	
	Program _program;
	
	public Call (Expression firstArg, Program program) {
		super(firstArg);
		_program = program;
	}
	
	public Literal evaluate() {
		return _program.getInterpreter().getProgram(getFirstArgument().getAsText().replaceAll("\"", "")).execute();		
	}
	
	public String getOperationName() {
		return "call";
	}
	
	public void accept(Visitor visitor){
		super.accept(visitor);
		visitor.visit(this);
	}
}
