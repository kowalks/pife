public class Mao {
    private Carta[] mao;
    private Baralho mesa;
    private Baralho deck;
    private int qtdCartas;

    public Mao (Baralho mesa, Baralho deck)
    {
        this.mesa = mesa;
        this.deck = deck;
        this.mao = new Carta[10];
        this.qtdCartas = 0;
    }

    public boolean compra ()
    {
        if(this.qtdCartas > 9) return false;

        Carta carta = deck.compra();

        // sanity check
        if (carta == null) return false;

        this.mao[this.qtdCartas] = carta;
        this.qtdCartas++;
        return true;
    }

    public boolean descarta(int i)
    {
        if (i < 0 || i > 10) return false;
        if (mao[i] == null) return false;

        Carta cartaAux = mao[i];
        for (int k = i; k < qtdCartas - 1; k++)
        {
            mao[k] = mao[k+1];
        }
        mesa.descarta(cartaAux);

        return true;
    }
}
