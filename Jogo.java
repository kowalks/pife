/**
 * Implementa um jogo de pife com um certo número de jogadores, uma
 * mesa e um baralho a ser jogado.
 *
 * @author Guilherme Kowalczuk
 * @version 02/06/2018
 *
 */
public class Jogo {
    private int numJogadores;
    private Baralho mesa;
    private Baralho deck;
    private Mao[] jogador;
    private int jogadorAtual;

    /**
     * Construtor padrão de classe. O jogo começa com um número especificado
     * de jogadores, criando um baralho com 52 cartas e uma mesa vazia. Os
     * jogadores começam com 9 cartas cada um.
     * @param numJogadores o número de jogadores da partida.
     */
    public Jogo (int numJogadores)
    {
        if (numJogadores > 1 && numJogadores < 5) {
            this.numJogadores = numJogadores;
            mesa = new Baralho();
            deck = new Baralho();
            jogador = new Mao[numJogadores];
            inicializa();
        }
    }

    /**
     * Inicializa o jogo de fato. Põe as 52 cartas no deck e, em seguida,
     * distribui 9 cartas aleatórias para cada jogador.
     */
    private void inicializa()
    {
        deck.inicializa();
        for (int i = 0; i < numJogadores; i++) {
            jogador[i] = new Mao();
            for (int j = 0; j < 9; j++)
                jogador[i].compra(deck);
        }
        jogadorAtual = 0;
    }

    /**
     * Método modificador do atributo jogadorAtual. Caso não esteja nos padrões,
     * então ele não modifica o valor antigo.
     * @param jogadorAtual o novo jogadorAtual.
     */
    public void setJogadorAtual(int jogadorAtual) {
        if (jogadorAtual >= 0 && jogadorAtual < numJogadores) this.jogadorAtual = jogadorAtual;
    }

    /**
     * Método de acesso de jogadorAtual.
     * @return o jogadorAtual desse objeto.
     */
    public int getJogadorAtual() {
        return jogadorAtual;
    }

    /**
     * Verifica se o jogador da posiçaõ i venceu o jogo.
     * @param i o jogador a ser analisado
     * @return true se o jogador venceu o jogo (bateu).
     */
    public boolean venceu(int i)
    {
        if (i < 0 || i >= numJogadores) return false;
        return jogador[i].bateu();
    }

    /**
     * Gera uma string contendo a carta virada por cima da mesa. Se não
     * houver cartas, retorna espaço em branco.
     * @return a mesa em formato String.
     */
    public String displayMesa() {
        mesa.abreTopo();
        return mesa + "";
    }

    /**
     * Método basicamente sempre retorna ** indicando que há uma carta fechada sobre a mesa,
     * e "  " quando não há cartas no baralho.
     * @return o baralho em formato String.
     */
    public String displayDeck() {
        return deck + "";
    }

    public String displayMaoAtual() {
        return jogador[jogadorAtual].toString();
    }
}
