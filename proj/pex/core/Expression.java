package pex.core;

import java.io.Serializable;


public abstract class Expression implements Serializable {
		
	public Expression () {
	}
	
	public abstract String getAsText();
	
	public abstract Literal evaluate();
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
