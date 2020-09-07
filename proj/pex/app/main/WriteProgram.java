package pex.app.main;

import java.io.*;
import java.io.IOException;
import java.util.*;
//FIXME import used core classes
import pex.core.ProgramMain;
import pex.core.Program;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Write (save) program to file.
 */
public class WriteProgram extends Command<ProgramMain> {
    /**
     * @param receiver
     */
    public WriteProgram(ProgramMain receiver) {
        super(Label.WRITE_PROGRAM, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() throws InvalidOperation {
        Form f = new Form();
        InputString inI = new InputString(f, Message.requestProgramId());
        InputString inI2 = new InputString(f, Message.programFileName());
        f.parse();
		try {
			Boolean state = entity().saveProg(inI.value(),inI2.value());
			if (state == false) {
				Display display = new Display();
				display.addNewLine(Message.noSuchProgram(inI.value()));
				display.display();
			}        
		}
		catch(IOException x) {
			Display display = new Display();
			display.addNewLine("Error:" + x);
			display.display();
		}
    }
}
