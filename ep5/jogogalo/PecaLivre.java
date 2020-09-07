package jogogalo;
/**
 * Concretizacao da Peca quando a Peca esta livre
 * Realiza as funcoes basicas da Peca se a peca estiver sem Jogador<p>
 *
 * @author Henrique Almeida e Tomás Oliveira
 * @version 1.0
 * @see <a href="http://docs.oracle.com/javase/7/docs/technotes/tools/windows/javadoc.html">javadocs documentation</a>
 * @see <a href="https://en.wikipedia.org/wiki/Javadoc">javadocs at Wikipedia</a>
 * @see <a href="http://docs.oracle.com/javase/tutorial/java/package/index.html">package documentation</a>
 */

public class PecaLivre extends Peca {

    public PecaLivre() {
    }
	/**
	 * Obtem o simbolo da peca.
	 *
	 * @return string contendo o simbolo associado a uma casa livre.
	 * */
    public String obtemSimbolo() {
        return " ";
    }
	/**
	 * verifica se duas pecas pertencem ao mesmo jogador.
	 *
	 * @param p objeto correspondente a uma peca de jogo.
	 * @return false por definicao.
	 * */
    public boolean pertenceMesmoJogador(Peca p) {
        return false;
    }
	/**
	 * o metodo indica se a peca e do tipo PecaLivre.
	 *
	 * @return true por definicao,
	 * */
    public boolean estaLivre() {
        return true;
    }
	/**
	 * o metodo indica o jogador a que esta associada uma peca.
	 * 
	 * @return string "Ninguem" tendo em conta que o objeto representa
	 * uma casa livre.
	 **/
    public String devolveJogador() {
        return "Ninguém";
    }

}
