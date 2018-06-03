public class Jogo {
    private int numJogadores;
    private Baralho mesa;
    private Baralho deck;
    private Mao[] jogador;

    public Jogo (int numJogadores)
    {
        if (numJogadores > 1 && numJogadores < 5) {
            this.numJogadores = numJogadores;
            mesa = new Baralho();
            deck = new Baralho();
            jogador = new Mao[numJogadores];
        }
    }

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
