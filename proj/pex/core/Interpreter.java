package pex.core;
import java.util.*;
import pex.AppIO;
import pex.core.Program;
import pex.AppIO;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.io.Serializable;



public class Interpreter implements Serializable {
	private Map<String, Program> _programs;
	private String _filename;
	private Map<String, Identifier> _identifiers = new HashMap<>();
	private transient AppIO _app;	

	public Interpreter(AppIO app) {
		_app = app;
		_programs = new HashMap<>();
	}
	public void addApp(AppIO app) {
		_app = app;	
	}
	public AppIO getAppIO() {
		return _app;
	}
	public void addProgram(Program program) {
		_programs.put(program.getName(),program);
	}
	public Program getProgram(String name) {
		return _programs.get(name);
	}
	public String getFile() {
		return _filename;
	}
	public void setFile(String filename) {
		_filename = filename;
	}
	public void addIdentifier(Identifier identifier) {
			_identifiers.put(identifier.getAsText(), identifier);
	}
	public Literal find_identifier(Identifier identifier) {
		if(_identifiers.containsKey(identifier.getAsText()))
			return _identifiers.get(identifier.getAsText()).getLiteral();
		else
			return null;
	}
}
