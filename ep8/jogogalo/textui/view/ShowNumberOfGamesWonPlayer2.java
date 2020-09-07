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
public class ShowNumberOfGamesWonPlayer2 extends Command<AplicacaoJogoGalo> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowNumberOfGamesWonPlayer2(AplicacaoJogoGalo ent) {
        super("Mostrar numero de jogos ganhos pelo Jogador 2", ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
		int iterator = 0;
		int i;
		JogoGalo jogo;
		int numjogos = entity().obtemNumeroJogos();
		String estado_jogo;
		Display display = new Display();
		
		for(i = 1; i <= numjogos; i++) {
			jogo = entity().obtemJogo(i);
			estado_jogo = "" + jogo.obtemResultado();
			if(estado_jogo.equals("JOGADOR_2"))
				iterator++;
		}
		
        display.add("O numero de jogos ganhos pelo Jogador 2 foi: "+ iterator);

        display.display();  
          
        
    }
}
