package pex.app.main;

import java.io.IOException;
import pex.core.ProgramMain;
import pex.core.Interpreter;
import pex.core.ProgramMain;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;
import pt.utl.ist.po.ui.Display;

/**
 * Save to file under current name (if unnamed, query for name).
 */
public class Save extends Command<ProgramMain> {
    /**
     * @param receiver
     */
    public Save(ProgramMain receiver) {
        super(Label.SAVE, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() throws InvalidOperation {
		if(entity().asChange()==1) {
			Interpreter interpreter = entity().getInterpreter(); 
			Form f = new Form();
			String filename;
			if (interpreter.getFile() == null) {
				InputString inI = new InputString(f, Message.newSaveAs());
				f.parse();
				filename = inI.value();
			}
			else {
				filename = interpreter.getFile();
			}
			try {
				entity().saveInterpreter(filename);
			}
			catch (IOException x) {
				Display display = new Display();
				display.addNewLine("Error:" + x);
				display.display();
			}
			entity().noChange();
		}
	}
}
