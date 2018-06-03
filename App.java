import java.util.Scanner;

public class App
{
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        Jogador jogador[];
        String nome;
        int numJogadores, atual, resp;

        do {
            System.out.print("Digite o número de jogadores: ");
            numJogadores = in.nextInt();
        } while (numJogadores < 2 || numJogadores > 4);

        jogador = new Jogador[numJogadores];

        in.nextLine();
        for (int i = 0; i < numJogadores; i++) {
            System.out.println("Digite o nome do jogador " + (i + 1) + ": ");
            nome = in.nextLine();
            jogador[i] = new Jogador(nome);
        }

        Jogo pife = new Jogo(numJogadores, jogador);

        while (!pife.venceu()) {
            pife.next();
            atual = pife.getJogadorAtual();

            System.out.println("\fJOGADOR " + jogador[atual].getNome() + "\n\nPressione enter para continuar...");
            in.nextLine();

            System.out.println("\fMesa: " + pife.displayMesa() + "\tBaralho: " +
                    pife.displayDeck() + "\n\n" + pife.displayJogadorAtual());

            System.out.print("\n\nComprar da mesa (1) ou baralho(2)? ");
            resp = in.nextInt();
            while ( resp != 1 && resp != 2 ||
                    resp == 1 && pife.isMesaEmpty() ||
                    resp == 2 && pife.isDeckEmpty()) {
                System.out.println("Opção Inválida. Tente noamente.");
                System.out.print("Comprar da mesa (1) ou baralho(2)? ");
                resp = in.nextInt();
            }

            if (resp == 1) pife.compraMesa();
            else pife.compraDeck();

            System.out.println("\fMesa: " + pife.displayMesa() + "\tBaralho: " +
                    pife.displayDeck() + "\n\n" + pife.displayJogadorAtual());

            System.out.print("\n\nDescartar qual carta? ");
            resp = in.nextInt();
            while (!pife.descarta(resp))
            {
                System.out.println("Operação Inválida. Tente novamente.");
                System.out.print("\n\nDescartar qual carta? ");
                resp = in.nextInt();
            }
        }
    }
}
