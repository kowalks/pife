public class Jogo {
    private int numJogadores;
    private Baralho mesa;
    private Baralho deck;

    public Jogo (int numJogadores)
    {
        this.numJogadores = numJogadores;
        mesa = new Baralho ();
        deck = new Baralho ();
        deck.inicializa();
    }

}
