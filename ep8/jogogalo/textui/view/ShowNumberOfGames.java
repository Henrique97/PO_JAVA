package jogogalo.textui.view;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

import jogogalo.core.AplicacaoJogoGalo;

/**
 * Command for showing the number of finished games.
 */
public class ShowNumberOfGames extends Command<AplicacaoJogoGalo> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowNumberOfGames(AplicacaoJogoGalo ent) {
        super("Obter Número de Jogos", ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
		
        Display display = new Display();
        
        display.add("Numero de jogos acabados: " + entity().obtemNumeroJogos());

        display.display();  
        
    }
}

