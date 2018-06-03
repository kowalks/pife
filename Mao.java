public class Mao {
    private Carta[] mao;
    private int qtdCartas;

    public Mao ()
    {
        this.mao = new Carta[10];
        this.qtdCartas = 0;
    }

    public boolean recebe(Carta carta)
    {
        // sanity check
        if (carta == null || this.qtdCartas > 9) return false;

        this.mao[this.qtdCartas] = carta;
        this.qtdCartas++;
        return true;
    }

    public Carta retira(int i)
    {
        if (i < 0 || i > 10) return null;
        if (mao[i] == null) return null;

        Carta cartaAux = mao[i];
        for (int k = i; k < qtdCartas - 1; k++)
        {
            mao[k] = mao[k+1];
        }
        return cartaAux;
    }
}
