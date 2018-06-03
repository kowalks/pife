import java.util.Random;
/**
 * Implementa um baralho, constituido por uma array de cartas (classe Carta)
 *
 * @author Guilherme Kowalczuk
 * @version 02/06/2018
 */
public class Baralho
{
    private Carta[] deck;
    private int finalBaralho; // esse aponta para o indice do ultimo elemento do baralho
    
    private static int numCartas = 52;

    /**
     * Construtor padrão da classe. Começa com uma array em que todos os
     * elementos são nulos, e o final do baralho aponto para a posição -1.
     */
    public Baralho ()
    {
        this.deck = new Carta[numCartas];
        this.finalBaralho = -1;
    }

    /**
     * Inicializa o baralho preenchendo com todas as cartas de um balhalho convencional,
     * isto é, inicializa com 13 cartas de números (A, 2, ..., 10, J, Q, K) de 4 naipes
     * diferentes (copas, paus, espadas, ouros). Ao final, o baralho é embaralhado e
     * suas cartas são misturadas.
     */
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
            TESTE Ola
        } while (t == 1);
        
    } */

    /**
     * Embaralha o baralho, isto é, deixa as cartas randomicamente organizadas
     * no baralho.
     */
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

    /**
     * Troca duas cartas em uma certa posição do baralho de lugar. Método privado
     * usado no método de embaralhamento.
     * @param i primeira posição a ser considerada
     * @param j segunda posição a ser considerada
     */
    private void swapCartas(int i, int j)
    {
        Carta aux = deck[i];
        deck[i] = deck[j];
        deck[j] = aux;
    }

    /**
     * Tira a carta do topo do baralho. O espaço que essa carta estava ocupando é
     * preenchido com vazio, então se pode realmente considerar que a carta foi removida
     * @return o endereço da carta removida. Note que o baralho é estruturalmente uma
     * pilha, então essa é a carta do topo do baralho.
     */
    public Carta compra()
    {
        if (finalBaralho < 0) return null;
        Carta carta = this.deck[finalBaralho];
        this.deck[finalBaralho] = null;
        this.finalBaralho--;
        return carta;
    }

    /**
     * Acrescenta a carta no baralho. Note que o baralho é uma pilha, e essa carta é
     * organizada na parte de cima do baralho.
     * @param carta a carta a ser acrescentada.
     */
    public void descarta(Carta carta)
    {
        this.finalBaralho++;
        this.deck[finalBaralho] = carta;
    }


}
