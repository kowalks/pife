/**
 * Implementa uma classe Mao, que corresponde à mao dos jogadores
 * que vão jogar o jogo. Ela é uma array de cartas no qual se pode
 * comprar uma carta de um baralho ou descartar uma carta na mesa.
 * @author Guilherme Kowalczuk
 * @version 02/06/2018
 *
 */
public class Mao {
    private Carta[] mao;
    private int qtdCartas;

    /**
     * Construtor padrão da classe. A mão começa sem nenhuma carta.
     */
    public Mao ()
    {
        this.mao = new Carta[10];
        this.qtdCartas = 0;
    }

    /**
     * Compra uma carta do deck
     * @param deck  o baralho de onde vem a carta comprada.
     * @return  true se foi possível efetuar a compra.
     */
    public boolean compra (Baralho deck)
    {
        if(this.qtdCartas > 9) return false;

        Carta carta = deck.compra();

        // sanity check
        if (carta == null) return false;

        this.mao[this.qtdCartas] = carta;
        this.qtdCartas++;
        return true;
    }

    /**
     * Descarta uma carta na mesa
     * @param i     a posição da carta a ser descartada.
     * @param mesa  a mesa para onde vai a carta descartada.
     * @return      true se foi possível descartar a carta especificada.
     */
    public boolean descarta(int i, Baralho mesa)
    {
        if (i < 0 || i > 10) return false;
        if (mao[i] == null) return false;

        Carta cartaAux = mao[i];

        System.arraycopy(mao, i + 1, mao, i, qtdCartas - 1 - i);

        mesa.descarta(cartaAux);

        return true;
    }
}
