public class Jogador {
    private String nome;
    private Mao mao;

    public Jogador(String nome, Mao mao)
    {
        this.nome = nome;
        this.mao = mao;
    }

    public String getNome() {
        return nome;
    }

    public Mao getMao() {
        return mao;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("Jogador: \n\n");
        sb.append(this.mao.toString());
        sb.append("\n");

        for (int i = 0; i < this.mao.getQtdCartas(); i++)
            sb.append("(").append(i).append(")");

        return sb.toString();

    }
}
