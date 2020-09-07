package jogogalo.textui.view;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

import jogogalo.core.AplicacaoJogoGalo;
import jogogalo.core.JogoGalo;

/**
 * Command for showing the final state of a finished game.
 */
public class ShowGame extends Command<AplicacaoJogoGalo> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowGame(AplicacaoJogoGalo ent) {
        super("Mostrar Jogo", ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
		
        Form f = new Form();
        InputInteger jogo_num = new InputInteger(f, "Indique o jogo a mostrar: ");
        f.parse();
        Display display = new Display();
        JogoGalo jogo;
        int numjogos = entity().obtemNumeroJogos();
        
        if(jogo_num.value() <= numjogos) {
			jogo = entity().obtemJogo(jogo_num.value());
			display.add(jogo.obtemEstadoJogo());
		}
		
		else
			display.addNewLine("Jogo Invalido");

        display.display();  
          
        
    }
}
