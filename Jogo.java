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
            jogador[i] = new Mao(this.mesa, this.deck);
            for (int j = 0; j < 9; j++)
                jogador[i].compra();
        }
    }

}
