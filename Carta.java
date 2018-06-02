
/**
 * Essa classe implementa uma carta normal de baralho. Uma carta é um objeto
 * com um certo número que varia de 1 (no caso do Ás) até 13 (no cado do K)
 * e um naipe, que varia de 1 (espadas) a 4 (copas). Além disso, a carta pode
 * estar aberta ou fechada no jogo, indicando se ela é visível ou não aos
 * jogadores que estão vendo a carta.
 * 
 * @author Guilherme Kowalczuk
 * @version 14/10/2018
 */
public class Carta
{
    private int numero;
    private int naipe; // naipe 1 -> espadas   2 -> paus    3  -> ouros   4 -> copas
    private boolean aberto;
    
    public Carta(int numero, int naipe)
    {
        setNumero(numero);
        setNaipe(numero);
        this.aberto = false;
    }
    
    private void setNumero(int numero)
    {
        if (numero > 0 && numero < 14) this.numero = numero;
    }
    
    private void setNaipe (int naipe)
    {
        if (naipe > 0 && naipe < 5) this.naipe = naipe;
    }
    
    public void abrir()
    {
        this.aberto = true;
    }
    
    public void fechar()
    {
        this.aberto = false;
    }
    
    public void trocar()
    {
        this.aberto = !this.aberto;
    }
    
    public String toString()
    {
        if (this.aberto) return "asdkasdjl";
        return "***";
    }
}
