import java.util.Random;
/**
 * Escreva a descrição da classe Baralho aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Baralho
{
    private Carta[] deck;
    private int finalBaralho; // esse aponta para o indice do ultimo elemento do baralho
    
    private static int numCartas = 52;
    
    public Baralho ()
    {
        this.deck = new Carta[numCartas];
        this.finalBaralho = -1;
    }
    
    public void inicializa()
    {
        this.finalBaralho = numCartas - 1;
        for (int i = 0; i < 13; i++)
            for(int j = 0; j < 4; j++)
                this.deck[4*i + j] = new Carta(i + 1, j + 1);
        embaralha();
    }
    
    /*
    public void embaralha()
    {
        double vetor[] = new double[finalBaralho + 1];
        for (int i = 0; i <= finalBaralho; i++)
            vetor[i] = Math.random();
        
        // bubblesort
        int t, k = 0;
        int m = finalBaralho - 1;
        do
        {
            t = 0;
            for (int i = 0; i < m; i++)
            {
                if (vetor[i] > vetor[i+1])
                {
                    double aux = vetor[i];
                    vetor[i] = vetor[i+1];
                    vetor[i+1] = aux;
                    t = 1;
                    swapCartas(i, i+1);
                    k = i;
                }
            }
            m = k;
            TESTE
        } while (t == 1);
        
    } */
    
    public void embaralha()
    {
        Random gera = new Random();
        int rand1, rand2;
        for (int i = 0, j = numCartas*2; i < j; i++)
        {
            rand1 = gera.nextInt(finalBaralho + 1);
            rand2 = gera.nextInt(finalBaralho + 1);
            swapCartas(rand1, rand2);
        }
    }
    
    private void swapCartas(int i, int j)
    {
        Carta aux = deck[i];
        deck[i] = deck[j];
        deck[j] = aux;
    }
    
    public Carta compra()
    {
        if (finalBaralho < 0) return null;
        Carta carta = this.deck[finalBaralho];
        this.deck[finalBaralho] = null;
        this.finalBaralho--;
        return carta;
    }
    
    public void descarta(Carta carta)
    {
        this.finalBaralho++;
        this.deck[finalBaralho] = carta;
    }
}
