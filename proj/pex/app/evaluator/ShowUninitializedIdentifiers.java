package pex.app.evaluator;

//FIXME import core classes
import pex.core.Program;
import pex.core.Identifier;
import pex.core.ExpressionVisitor;

import pt.utl.ist.po.ui.Display;
import java.util.Set;
import java.util.HashSet;	

/**
 * Show uninitialized identifiers.
 */
public class ShowUninitializedIdentifiers extends ProgramCommand {

    /**
     * @param receiver
     */
    public ShowUninitializedIdentifiers(Program receiver) {
        super(Label.SHOW_UNINITIALIZED_IDENTIFIERS, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
        ExpressionVisitor n = new ExpressionVisitor();
		entity().accept(n);
		Set<Identifier> identifiers = n.getUninitializedIdentifiers();
		Display display = new Display();
		for (Identifier id : identifiers) {
			display.addNewLine(id.getAsText());
        }
        display.display();
    }
}
