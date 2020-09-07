package pex.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import pex.core.Interpreter;
import pex.core.ProgramMain;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;
/**
 * Open existing interpreter.
 */
public class Open extends Command<ProgramMain> {
    /**
     * @param receiver
     */
    public Open(ProgramMain receiver) {
        super(Label.OPEN, receiver);
    }

    /** @see pt.tecnico.po.ui.Command#execute() */
    @Override
    public final void execute() throws InvalidOperation {
		Form f = new Form();
        InputString inI = new InputString(f, Message.openFile());
        f.parse();
		try {
			entity().openInterpreter(inI.value());
		}
		catch (ClassNotFoundException x) {
				Display display = new Display();
			    display.addNewLine("Error:" + x);
			    display.display();
			}
		catch (IOException x) {
			Display display = new Display();
			display.addNewLine(Message.fileNotFound());
			display.display();
		}
    }
}
