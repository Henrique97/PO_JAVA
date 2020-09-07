package pex.app.main;

//FIXME import used core classes
import pex.core.ProgramMain;
import pex.core.Program;
import pex.app.evaluator.EvaluatorMenu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;


/**
 * Open menu for managing programs.
 */
public class EditProgram extends Command<ProgramMain> {
    /**
     * @param receiver
     */
    public EditProgram(ProgramMain receiver) {
        super(Label.MANAGE_PROGRAM, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
		Form f = new Form();
        InputString inI = new InputString(f, Message.requestProgramId());
        f.parse();
        Program program = entity().getProg(inI.value());
        if (program != null) {
			EvaluatorMenu menu = new EvaluatorMenu(program);
			menu.open();
		}
		else {
			Display display = new Display();
			display.addNewLine(Message.noSuchProgram(inI.value()));
			display.display();
		}
    }

}
