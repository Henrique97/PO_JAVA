package jogogalo.core;

public abstract class Peca {

    public abstract String obtemSimbolo();

    public boolean pertenceMesmoJogador(Peca p) {
        return getClass() == p.getClass();
    }

    public boolean estaLivre() {
        return false;
    }

    public abstract String devolveJogador();
}
