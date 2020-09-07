package jogogalo.core;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class AplicacaoJogoGalo {

    private List<JogoGalo> _jogos;

    public AplicacaoJogoGalo() {
        _jogos = new ArrayList<>();
    }

    public void guarda(JogoGalo jogo) {
        _jogos.add(jogo);
    }

    public JogoGalo obtemJogo(int idx) {
        if (idx <= 0 || idx > _jogos.size())
            return null;

        return _jogos.get(idx - 1);
    }

    public int obtemNumeroJogos() {
	return _jogos.size();
    }

    public void escreveResultado() {
        Iterator<JogoGalo> iter = _jogos.iterator();
        int i = 0;

        while (iter.hasNext()) {
            JogoGalo jogo = iter.next();
            System.out.println("Resultado do jogo " + i++ + "\n" + jogo);
        }
    }

    public List<JogoGalo> obtemJogosOrdenados() {
        Comparator<JogoGalo> comparador = new Comparator<JogoGalo>() {
                public int compare(JogoGalo g1, JogoGalo g2) {
                    if (g1.obtemResultado() == g2.obtemResultado())
                        return 0;

                    switch (g1.obtemResultado()) {
                        case JOGADOR_1:
                            return 1;
                        case EMPATE:
                            return -1;
                        case JOGADOR_2:
                            if (g2.obtemResultado() == ResultadoJogo.JOGADOR_1)
                                return -1;
                            return 1;
                        default:
                            return -1;
                        
                    }
                }
            };

        ArrayList<JogoGalo> ordenado = new ArrayList<>(_jogos);
        Collections.sort(ordenado, comparador);
        return ordenado;
    }
}
