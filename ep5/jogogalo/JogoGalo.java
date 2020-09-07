package jogogalo;
/**
 * Implementação do Jogo do Galo propriemente dito	
 * Realiza jogadas, verifica a existencia de jogadas disponiveis e processa o jogo. <p>
 * Cria tambem o tabuleiro do jogo.  <p>
 *
 * @author Henrique Almeida e Tomás Oliveira
 * @version 1.0
 * @see <a href="http://docs.oracle.com/javase/7/docs/technotes/tools/windows/javadoc.html">javadocs documentation</a>
 * @see <a href="https://en.wikipedia.org/wiki/Javadoc">javadocs at Wikipedia</a>
 * @see <a href="http://docs.oracle.com/javase/tutorial/java/package/index.html">package documentation</a>
 */

public class JogoGalo {
	/**
	 * array do tipo Peca que representa todas as posicoes
	 * de um tabuleiro.
	 **/
    private Peca[][] _tabuleiro;
	
	/**
	 * Overloaded constructor: construtor que cria um objeto com
	 * uma array _tabuleiro com todas as posicoes preenchidas com
	 * objetos do tipo Pecalivre
	 * 
	 * @param tamanho tamanho do tabuleiro quadrado.
	 * @see JogoGalo jogogalo
	 **/
    public JogoGalo(int tamanho) {
        _tabuleiro = new Peca[tamanho][tamanho];
        Peca peca = new PecaLivre();

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                _tabuleiro[i][j] = peca;
            }
        }
    }
	/**
	 * Realiza uma jogada.
	 * Verifica se a jogada recebida e valida e introduz a jogada no
	 * tabuleiro de jogo.
	 * 
	 * @param peca peca que vai ser jogada.
	 * @param linha linha do tabuleiro onde vai ser colocada a peca.
	 * @param coluna coluna do tabuleiro onde vai ser colocada a peca.
	 * @return true se a a jogada for efetuada, caso contrario, retorna false
	 * */
    public boolean joga(Peca peca, int linha, int coluna) {
        if (linha >= 1 && linha <= _tabuleiro.length && coluna >= 1 && coluna <= _tabuleiro[0].length &&
          _tabuleiro[linha - 1][coluna - 1].estaLivre()) {
            _tabuleiro[linha - 1][coluna - 1] = peca;
            return true;
        }

        return false;
    }
	/**
	 * Verifica se o tabuleiro esta completo.
	 * O metodo acede a todas as casas do tabuleiro e verifica
	 * se existe alguma PecaLivre que indique uma casa vazia.
	 * 
	 * @return true se existir jogada disponivel, caso contrario, retorna false
	 * */
    public boolean temJogadasDisponiveis() {
        for (Peca[] linha : _tabuleiro) {
            for (Peca p : linha) {
                if (p.estaLivre())
                    return true;
            }
        }
        
        return false;
    }
	/**
	 * Verificacao de que existe um vencedor.
	 * O metodo verifica tendo em conta a ultima posicao se um jogador
	 * ganhou o jogo.
	 * 
	 * @param linha linha da ultima peca colocada no tabuleiro.
	 * @param coluna coluna da ultima peca colocada no tabuleiro.
	 * return boolean a funcao retorna um bolean tendo em conta o
	 * @return resultado do jogo (True - existe um vencedor; False - nao existe vencedor)
	 * */
    public boolean ganhou(int linha, int coluna) {
        Peca jogada = _tabuleiro[--linha][--coluna];
        boolean resultado = true;
        int i;

        // verifica linha
        for (i = 0; i < _tabuleiro[linha].length; i++) {
            if (!_tabuleiro[linha][i].pertenceMesmoJogador(jogada)) {
                resultado = false;
                break;
            }
        }

        if (resultado)
            return true;

        resultado = true;
        // verifica coluna
        for (i = 0; i < _tabuleiro.length; i++) {
            if (!_tabuleiro[i][coluna].pertenceMesmoJogador(jogada)) {
                resultado = false;
                break;
            }
        }

        if (resultado)
            return true;

        // verifica diagonais.. Só é necessário se a peça estiver numa diagonal.
        if (linha == coluna) {             // verifica diagonal principal
            resultado = true;
            for (i = 0; i < _tabuleiro.length; i++) {
                if (!_tabuleiro[i][i].pertenceMesmoJogador(jogada)) {
                    resultado = false;
                    break;
                }
            }

            if (resultado)
                return true;
        }
        
        if (linha + coluna == _tabuleiro.length - 1) {             // verifica diagonal inversa
            resultado = true;
            int j;
            for (i = 0, j = _tabuleiro.length - 1; i < _tabuleiro.length; i++, j--) {
                if (!_tabuleiro[i][j].pertenceMesmoJogador(jogada)) {
                    resultado = false;
                    break;
                }
            }

            if (resultado)
                return true;
        }
        
        return false;
    }
	 /**
	 * Criacao de separador de linha.
	 * O metodo permite a criacao duma string com uma representacao de
	 * um separador de linha. 
	 *
	 * @return string representante de um separador de tabuleiro.
	 */
    private String criaSeparadorLinha() {
        StringBuilder separador = new StringBuilder();

        for (int i = 0; i < _tabuleiro[0].length - 1; i++)
            separador.append("-+");

        separador.append("-\n");

        return separador.toString();
    }
	 /**
	 * Criacao de linha de tabuleiro no formato string.
	 * O metodo recebe uma linha de um tabuleiro e cria uma
	 * representacao da mesma. 
	 *
	 * @param linha vetor representante das pecas numa linha de tabuleiro
	 * @return string contendo representacao de uma linha de tabuleiro.
	 */
    private String processaLinha(Peca[] linha) {
        StringBuilder res = new StringBuilder();
        int i;

        for(i = 0; i < linha.length - 1; i++) {
            res.append(linha[i].obtemSimbolo()).append("|");
        }

        res.append(linha[i].obtemSimbolo()).append("\n");
        return res.toString();
    }
	/**
	 * Auxiliar para impressao do tabuleiro de jogo.
	 * O metodo cria uma string com uma representacao
	 * do tabuleiro. 
	 *
	 * @return string contendo uma representacao do tabuleiro.
	 */
    public String obtemEstadoJogo() {
        StringBuilder str = new StringBuilder();
        String separador = criaSeparadorLinha();
        int i;

        for (i = 0; i < _tabuleiro.length - 1; i++) {
            str.append(processaLinha(_tabuleiro[i]));
            str.append(separador);
        }

        str.append(processaLinha(_tabuleiro[i]));
        return str.toString();
    }

    public static void main(String[] args) {
        JogoGalo jogo = new JogoGalo(3);
        Peca p1 = new PecaJogador1();
        Peca p2 = new PecaJogador2();

        System.out.println("Estado Inicial\n" + jogo.obtemEstadoJogo());
        jogo.joga(p1, 1, 1);
        jogo.joga(p2, 1, 2);
        System.out.println("Após duas jogadas\n" + jogo.obtemEstadoJogo());
        
        System.out.println("P1 ganhou " + jogo.ganhou(1, 1));
        System.out.println("P2 ganhou " + jogo.ganhou(1, 2));

        jogo.joga(p1, 2, 2);
        jogo.joga(p2, 2, 3);
        System.out.println("Após 4  jogadas\n" + jogo.obtemEstadoJogo());
        System.out.println("P1 ganhou " + jogo.ganhou(2, 2));
        System.out.println("P2 ganhou " + jogo.ganhou(2, 3));

        jogo.joga(p1, 3, 3);
        jogo.joga(p2, 1, 3);
        System.out.println("Após 4  jogadas\n" + jogo.obtemEstadoJogo());
        System.out.println("P1 ganhou " + jogo.ganhou(3, 3));
        System.out.println("P2 ganhou " + jogo.ganhou(1, 3));

        jogo.joga(p1, 3, 1);
        jogo.joga(p1, 3, 2);
        System.out.println("Após 6  jogadas\n" + jogo.obtemEstadoJogo());
        System.out.println("P1 ganhou 3ª linha: " + jogo.ganhou(3, 2));

        jogo.joga(p1, 2, 1);
        System.out.println("Após 7  jogadas\n" + jogo.obtemEstadoJogo());
        System.out.println("P1 ganhou 1ª coluna: " + jogo.ganhou(2, 1));
        
    }
}

    
