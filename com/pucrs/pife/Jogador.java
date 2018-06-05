package com.pucrs.pife;

public class Jogador {
    private String nome;
    private Mao mao;

    public Jogador(String nome)
    {
        this.nome = nome;
        this.mao = new Mao();
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

        sb.append("Jogador: ");
        sb.append(nome);
        sb.append("\n\n");
        sb.append(this.mao.toString());
        sb.append("\n");

        for (int i = 0; i < this.mao.getQtdCartas(); i++)
            sb.append("(").append(i).append(") ");

        return sb.toString();

    }

    public boolean bateu()
    {
        return mao.bateu();
    }

    public boolean compra(Baralho deck)
    {
        return mao.compra(deck);
    }

    public boolean descarta(int i, Baralho mesa)
    {
        return mao.descarta(i, mesa);
    }
}
