package com.pucrs.pife;

/**
 * Implementa uma classe de partiçõa dos números {0,1,2,3,4,5,6,7,8}.
 * A partição é feita em grupos de três em três, sendo que a partição
 * {{1,2,3},{4,5,6},{7,8,0}} é tomada como a mesma partição que
 * {{0,8,7},{6,5,4},{3,2,1}}.
 */
public class Permutation
{
    private int[][] vector;
    private int numPermutation;

    /**
     * Método construtor padrão. Ele constroi e inicializa a classe
     * de permutação, calculando todas as permutações no momento que
     * é disparado para que a complexidade de acesso seja O(1).
     */
    public Permutation()
    {
        vector = new int[280][9];
        initialize();
        numPermutation = 0;
    }


    /**
     * Inicializa propriamente a classe de permutação. O método basicamente
     * cria, para cada vetor em vector[.], uma partição nova em grupos de três.
     * Ele funciona basicamente preenchendo em partes o esquema {{a,b,c},{d,e,f},{g,h,i}}.
     * Primeiramente, fazemos a = 0 por simetria, e assumimos que b < c. Daí, com essa
     * assumption. percorremos os numeros de 1 a 9 em dois loops preenchendo os valores
     * de b e c (começamos com (1 2), depois (1 3), ... (1 9), (2, 3), ... (7 8)).
     * Feito isso, conseguimos a primeira partição. Aí, criamos uma lista auxiliar list[]
     * com os números que ainda não foram escolhidos (terceiro for). Aí assumimos que o quarto
     * elemento da partição é o primeiro da lista (por simetria) e fazemos dois loops novamente,
     * em cima da lista list[], para preencher o quinto e o sexto elemento (quarto e quinto for).
     * No último for, pegamos os elementos de list[] que não foram escolhidos nem como quarto,
     * nem como quinto e nem como sexto elemento, e enfim colocamos colo sétimo, oitavo e nono.
     */
    private void initialize()
    {
        int ptr = 0;
        int list[] = new int[6];

        for (int i = 1; i < 9; i++)
            for (int j = i + 1; j < 9; j++)
            {
                for (int k = 1, l = 0; k < 9; k++)
                    if (k != i && k != j)
                    {
                        list[l] = k;
                        l++;
                    }
                for (int a = 1; a < 6; a++)
                    for (int b = a + 1; b < 6; b++)
                    {
                        vector[ptr][0] = 0;
                        vector[ptr][1] = i;
                        vector[ptr][2] = j;
                        vector[ptr][3] = list[0];
                        vector[ptr][4] = list[a];
                        vector[ptr][5] = list[b];
                        for (int z = 1, y = 6; z < 6; z++)
                            if (z != a && z != b)
                            {
                                vector[ptr][y] = list[z];
                                y++;
                            }
                        ptr++;
                    }
            }
    }

    /**
     * Acessa nova permutação. As partições estão organizadas em ordem crescente pelos elementos.
     */
    public void permute ()
    {
        numPermutation = (numPermutation + 1) % 280;
    }

    /**
     * Retorna o inteiro especificado da posição atual.
     * @param i o inteiro ao qual se quer acessar da permutação
     * @return  o valor acessado.
     */
    public int intAt(int i)
    {
        return vector[numPermutation][i];
    }
}
