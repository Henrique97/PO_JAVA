package jogogalo;
/**
 * Classe abstrata do tipo Peça
 * Realiza as funcoes basicas de uma Peca <p>
 *
 * @author Henrique Almeida e Tomás Oliveira
 * @version 1.0
 * @see <a href="http://docs.oracle.com/javase/7/docs/technotes/tools/windows/javadoc.html">javadocs documentation</a>
 * @see <a href="https://en.wikipedia.org/wiki/Javadoc">javadocs at Wikipedia</a>
 * @see <a href="http://docs.oracle.com/javase/tutorial/java/package/index.html">package documentation</a>
 */

public abstract class Peca {
	
	/**
	 * Obtem o simbolo da peca.
	 *
	 * @return string contendo o simbolo de jogo
	 * */
    public abstract String obtemSimbolo();
	
	/**
	 * verifica se duas pecas pertencem ao mesmo jogador.
	 *
	 * @param p objeto correspondente a uma peca de jogo.
	 * @return true se as pecas forem do mesmo jogador, caso contrario
	 * retorna false.
	 * */
    public boolean pertenceMesmoJogador(Peca p) {
        return getClass() == p.getClass();
    }
	
	/**
	 * o metodo indica se a peca e do tipo PecaLivre.
	 *
	 * @return false por definicao
	 * */
    public boolean estaLivre() {
        return false;
    }
	/**
	 * o metodo indica o jogador a que esta associada uma peca.
	 * @return nome do Jogador (String)
	 **/
    public abstract String devolveJogador();
}
