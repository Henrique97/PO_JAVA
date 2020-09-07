package pex.app.evaluator;

//FIXME import used core classes

import pex.app.BadExpressionException;
import pex.app.BadPositionException;

import pex.core.Program;

import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;
import pex.core.Expression;
import pt.utl.ist.po.ui.Display;
import pex.parser.NewParser;

/**
 * Add expression.
 */
public class AddExpression extends ProgramCommand {
    /**
     * @param receiver
     */
    public AddExpression(Program receiver) {
        super(Label.ADD_EXPRESSION, receiver);
    }
    
    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() throws BadExpressionException, BadPositionException {
        Form f = new Form();
		InputInteger inI = new InputInteger(f, Message.requestPosition());
		InputString inI2 = new InputString(f, Message.requestExpression());
		f.parse();
        NewParser parser = new NewParser(entity().getInterpreter());
		try {
			Expression expression = parser.parseString(inI2.value(),entity());
			entity().addExpression(expression, inI.value());
		}
		catch(IndexOutOfBoundsException x) {
			BadPositionException y = new BadPositionException(inI.value());
			throw y;
		}
		catch(Exception x) {
			Display display = new Display();
			display.addNewLine(x.toString());
			display.display();
		}
    }
}
