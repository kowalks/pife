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
     * Método toString. Caso a carta esteja aberta (atributo de classe
     * "aberto"), então exibe o número da carta e seu naipe, nessa ordem.
     * Caso contrário, são exibidos asteriscos, indicando que a carta se
     * encontra fechada (ou seja, virada para baixo).
     * @return uma string contendo a carta.
     */
    public String toString() {
        String str = "";
        if (this.aberto) {
            if (this.numero == 1) str += "A";
            else if (this.numero == 11) str += "J";
            else if (this.numero == 12) str += "Q";
            else if (this.numero == 13) str += "K";
            else str += this.numero;

            switch(this.naipe) {
                case 1: str += "♠";
                        break;
                case 2: str += "♣";
                        break;
                case 3: str += "♦";
                        break;
                case 4: str += "♥";
            }
        } else str += "**";

        return str;
    }
}
