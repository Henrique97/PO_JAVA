package pex.app.main;

//FIXME import used core classes
import pex.core.ProgramMain;
import pex.core.Program;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import java.io.IOException;
import pex.parser.NewParser;

/**
 * Read existing program.
 */
public class ReadProgram extends Command<ProgramMain> {
    /**
     * @param receiver
     */
    public ReadProgram(ProgramMain receiver) {
        super(Label.READ_PROGRAM, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
        Form f = new Form();
        InputString inI = new InputString(f, Message.programFileName());
        f.parse();
        NewParser parser = new NewParser(entity().getInterpreter());
        try {
			Program program = parser.parseFile(inI.value(), inI.value());
			entity().addProg(program);
		}
		catch(Exception x) {
			System.out.println ("Error:" + x);
		}
    }
}
