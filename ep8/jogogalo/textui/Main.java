package jogogalo.textui;

import jogogalo.core.AplicacaoJogoGalo;

import jogogalo.textui.main.MainMenu;

import static pt.utl.ist.po.ui.UserInteraction.IO;


public class Main {

    public static void main(String[] args) throws Exception {

        AplicacaoJogoGalo app =  new AplicacaoJogoGalo();
        MainMenu menu = new MainMenu(app);
    
        menu.open();
        IO.close();
    }
}
