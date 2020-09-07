package pex.app.main;

import java.io.IOException;
import pex.core.ProgramMain;
import pex.core.Program;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
/**
 * Create new program.
 */
public class NewProgram extends Command<ProgramMain> {

    /**
     * @param receiver
     */
    public NewProgram(ProgramMain receiver) {
        super(Label.NEW_PROGRAM, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
		Form f = new Form();
        InputString inI = new InputString(f, Message.requestProgramId());
        f.parse();
		Program program = new Program(inI.value(),entity().getInterpreter());
		entity().addProg(program);
    }
}
