package pex.app.evaluator;

//FIXME import core classes
import pex.core.Program;
import pex.core.Identifier;
import pex.core.ExpressionVisitor;

import pt.utl.ist.po.ui.Display;
import java.util.Set;
import java.util.HashSet;

/**
 * Show all program identifiers.
 */
public class ShowAllIdentifiers extends ProgramCommand {

    /**
     * @param receiver
     */
    public ShowAllIdentifiers(Program receiver) {
        super(Label.SHOW_ALL_IDENTIFIERS, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
		ExpressionVisitor n = new ExpressionVisitor();
		entity().accept(n);
		Set<Identifier> identifiers = n.getIdentifiers();
		Display display = new Display();
		for (Identifier id : identifiers) {
			display.addNewLine(id.getAsText());
        }
        display.display();
    }
}
