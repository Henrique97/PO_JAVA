package jogogalo;
/**
 * Concretizacao da Peca no Jogador2
 * Realiza as funcoes basicas da Peca no Jogador2<p>
 *
 * @author Henrique Almeida e Tomás Oliveira
 * @version 1.0
 * @see <a href="http://docs.oracle.com/javase/7/docs/technotes/tools/windows/javadoc.html">javadocs documentation</a>
 * @see <a href="https://en.wikipedia.org/wiki/Javadoc">javadocs at Wikipedia</a>
 * @see <a href="http://docs.oracle.com/javase/tutorial/java/package/index.html">package documentation</a>
 */

public class PecaJogador2 extends Peca {

    public PecaJogador2() {
    }
	/**
	 * Obtem o simbolo da peca.
	 *
	 * @return string contendo a peca do jogodor2.
	 * */
    public String obtemSimbolo() {
        return "o";
    }
	/**
	 * o metodo indica o jogador a que esta associada uma peca.
	 * 
	 * @return jogador2.
	 **/
    public String devolveJogador() {
        return "Jogador 2";
    }
}
