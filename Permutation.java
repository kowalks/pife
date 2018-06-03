public class Permutation
{
    private int[][] vector;
    private int numPermutation;

    public Permutation()
    {
        vector = new int[280][9];
        initialize();
        numPermutation = 0;
    }

    private void initialize()
    {
        int ptr = 0;
        int list[] = new int[6];

        for (int i = 1; i < 9; i++)
        {
            for (int j = i + 1; j < 9; j++)
            {
                for (int k = 1, l = 0; k < 9; k++)
                {
                    if (k != i && k != j) {
                        list[l] = k;
                        l++;
                    }
                }
                for (int a = 1; a < 6; a++)
                {
                    for (int b = a+1; b < 6; b++)
                    {
                        vector[ptr][0] = 0;
                        vector[ptr][1] = i;
                        vector[ptr][2] = j;
                        vector[ptr][3] = list[0];
                        vector[ptr][4] = list[a];
                        vector[ptr][5] = list[b];
                        for (int z = 1, y = 6; z < 6; z++)
                        {
                            if (z != a && z != b)
                            {
                                vector[ptr][y] = list[z];
                                y++;
                            }
                        }
                        ptr++;
                    }
                }
            }
        }
    }

    public void permute ()
    {
        numPermutation = (numPermutation + 1) % 280;
    }

    public int intAt(int i)
    {
        return vector[numPermutation][i];
    }
}
