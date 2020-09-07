package pex.app;

import java.io.*;

import pex.core.ProgramMain;
import pex.core.Program;
import pex.AppIO;
import pex.parser.ParserException;
import pex.app.main.MainMenu;
import pex.parser.NewParser;

import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.Display;

/**
 * This is a sample client for the expression evaluator.
 * It uses a text-based user interface.
 */
public class App implements AppIO {
    // Add fileds here if needed

    public App() {
	// add core here if needed
    }

    /**
     * Writes a string to be presented to the user.
     *
     * @param str the string to write
     **/
    public void println(String str) {        
		Display display = new Display();
		display.addNewLine(str);
		display.display();
    }

    /**
     * Reads a string inputed by the user.
     *
     * @return the string written by the user.
     **/
    public String readString() {
		Form fs = new Form();
		InputString s = new InputString(fs,"");
		fs.parse();
		return s.value();
    }

    /**
     * Reads an integer inputed by the user.
     *
     * @return the number written by the user.
     **/
    public int readInteger() {
		Form f = new Form();
		InputInteger i = new InputInteger(f,"");
		f.parse();
		return i.value();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        ProgramMain app =  new ProgramMain();
		app.newInterpreter();
        String datafile = System.getProperty("import"); //$NON-NLS-1$
        if (datafile != null) {
            try {
				NewParser parser = new NewParser(app.getInterpreter());
				Program program = parser.parseFile(datafile, "import");
				app.addProg(program);
                //FIXME read import file into core object (use Parser instance)
            } catch (ParserException e) {
                // no behavior described: just present the problem
                e.printStackTrace();
            }
        }
        MainMenu menu = new MainMenu(app);
        menu.open();
    }
}
