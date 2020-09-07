package jogogalo.textui.main;

import jogogalo.core.AplicacaoJogoGalo;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

/**
 * Represents the main menu of this apllication. This is the first menu
 * shown to the users.
 ***/
public class MainMenu extends Menu {
  /**
   * Constructor
   **/
  public MainMenu(AplicacaoJogoGalo app) {
    super("Aplicação Jogo do Galo", new Command<?>[] {
        new PlayGame(app),
        new ViewData(app)
          });
  }
}
