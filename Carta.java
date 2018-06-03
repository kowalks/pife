/**
 * Essa classe implementa uma carta normal de baralho. Uma carta é um objeto
 * com um certo número que varia de 1 (no caso do Ás) até 13 (no cado do K)
 * e um naipe, que varia de 1 (espadas) a 4 (copas). Além disso, a carta pode
 * estar aberta ou fechada no jogo, indicando se ela é visível ou não aos
 * jogadores que estão vendo a carta.
 *
 * @author Guilherme Kowalczuk
 * @version 02/06/2018
 */
public class Carta
{
    private int numero;
    private int naipe; // naipe 1 -> espadas   2 -> paus    3  -> ouros   4 -> copas
    private boolean aberto;

    /**
     * Método construtor para carta. Recebe o número da carta
     * e o naipe como inteiros, conforme a seguinte convenção:
     * <p>
     * NAIPE: 1(♠) 2(♣) 3(♦) 4 (♥)
     * @param numero    o número da carta. Deve ser um inteiro entre 1 e 14, para
     *                  um baralho normal.
     * @param naipe     o naipe da carta.
     */
    public Carta(int numero, int naipe) {
        setNumero(numero);
        setNaipe(naipe);
        this.aberto = false;
    }

    public int getNumero()
    {
        return this.numero;
    }

    public int getNaipe()
    {
        return this.naipe;
    }

    public String getNaipeString()
    {
        switch(this.naipe) {
            case 1: return "♠";
            case 2: return "♣";
            case 3: return "♦";
            case 4: return "♥";
            default:return "*";
        }
    }

    public String getNumeroString()
    {
        if (this.numero == 1) return "A";
        if (this.numero <= 10) return "" + this.numero;
        if (this.numero == 11) return "J";
        if (this.numero == 12) return "Q";
        if (this.numero == 13) return "K";
        return "*";
    }

    private void setNumero(int numero) {
        if (numero > 0 && numero < 14) this.numero = numero;
    }

    private void setNaipe (int naipe) {
        if (naipe > 0 && naipe < 5) this.naipe = naipe;
    }

    /**
     * Abre uma carta, tornando ela visível ao método toString.
     */
    public void abrir() {
        this.aberto = true;
    }

    /**
     * Fecha uma carta, tornando o número e o naipe invisíveis
     * ao método toString.
     */
    public void fechar() {
        this.aberto = false;
    }

    /**
     * Troca o estado de uma carta de fechado para aberto ou vice
     * versa. O estado da carta tem influência somente no método
     * toString, que serve para revelar o conteúdo da carta.
     */
    public void trocar() {
        this.aberto = !this.aberto;
    }

    /**
     * Método de acesso ao atributo "aberto".
     * @return  true se a carta está aberta, ou seja, visível pelo
     *          método toString.
     */
    public boolean estaAberto() {
        return this.aberto;
    }

    /**
     * Verifica se duas cartas são iguais em naipe e número.
     * @param carta a carta a ser comparada.
     * @return true se as cartas são iguais.
     */
    public boolean isEqual(Carta carta)
    {
        return (carta.getNaipe() == this.getNaipe() && carta.getNumero() == this.getNumero());
    }

    /**
     * Método toString. Caso a carta esteja aberta (atributo de classe
     * "aberto"), então exibe o número da carta e seu naipe, nessa ordem.
     * Caso contrário, são exibidos asteriscos, indicando que a carta se
     * encontra fechada (ou seja, virada para baixo).
     * @return uma string contendo a carta.
     */
    public String toString() {
        if (this.aberto) return getNumeroString() + getNaipeString();

        return "**";
    }


    public static boolean isTrinca(Carta c1, Carta c2, Carta c3)
    {
        // essas três linhas garantem que as cartas são não nulas, não identicas, e com naipes diferentes
        if (c1 == null || c2 == null || c3 == null) return false;
        if (c1.isEqual(c2) || c2.isEqual(c3) || c3.isEqual(c1)) return false;
        if (c1.getNaipe()==c2.getNaipe()||c1.getNaipe()==c3.getNaipe()||c2.getNaipe()==c3.getNaipe()) return false;

        return (c1.getNumero() == c2.getNumero() && c2.getNumero() == c3.getNumero());
    }

    public static boolean isSequencia(Carta c1, Carta c2, Carta c3)
    {
        // assegunrando que todas as cartas tem o mesmo naipe.
        if (c1.getNaipe()!=c2.getNaipe()||c2.getNaipe()!=c3.getNaipe()||c1.getNaipe()!=c2.getNaipe()) return false;

        int da[] = {0,0,1,1,2,2};
        int db[] = {1,2,0,2,0,1};
        int dc[] = {2,1,2,0,1,0};

        Carta[] carta = {c1, c2, c3};

        // checa para todas as permutações possíveis
        for (int i = 0; i < 6; i++)
        {
            // checa se formam uma sequencia normal
            if (carta[da[i]].getNumero() == carta[db[i]].getNumero() + 1)
                if (carta[db[i]].getNumero() == carta[dc[i]].getNumero() + 1)
                    return true;
            // checa se formam uma sequencia Q K A
            if (carta[da[i]].getNumero() == 12 && carta[db[i]].getNumero() == 13 && carta[dc[i]].getNumero() == 1)
                return true;
        }

        return false;
    }

}
