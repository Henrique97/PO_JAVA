package pex.app.main;
import pex.core.ProgramMain;
import pex.core.Interpreter;
import pex.app.App;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputBoolean;

/**
 * Command for creating a new interpreter.
 */
public class New extends Command<ProgramMain> {
    /**
     * @param receiver
     */
    public New(ProgramMain receiver) {
        super(Label.NEW, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
		App app = new App();
		Interpreter interpreter = new Interpreter(app);
		entity().setInterpreter(interpreter);
	}
}
