package pex.core;

import java.lang.Comparable;

public class Identifier extends Expression implements Comparable<Identifier>{
	
	private String _name;
	private Literal _literal = new IntegerLiteral(0);
	private Program _program;

	public Identifier(String name, Program program) {
		_program = program;
		_name= name;
	}
	
	public String getAsText() {
		return _name;
	} 
	
	public Literal evaluate() {
		return _program.getInterpreter().find_identifier(this);
	}	
	
	public void accept(Visitor visitor){
		super.accept(visitor);
		visitor.visit(this);
	}	
	
	public int compareTo(Identifier id) {
        return _name.compareTo(id.getAsText());
    }
    
    public void changeLiteral (Literal literal) {
		_literal = literal;
	}
	public Literal getLiteral() {
		return _literal;
	}
	
}
