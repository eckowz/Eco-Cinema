package view;

import repositorio.RepositorioFilmes;
import util.Console;
import view.menu.MainMenu;

/**
 *
 * @author lhries
 */
public class MainUI {

    private RepositorioFilmes listaFilmes;

    public MainUI() {
        listaFilmes = new RepositorioFilmes();
    }

    public void executar() {
        int opcao = 0;
        do {
            System.out.println(MainMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case MainMenu.OP_VENDAINGRESSOS:
                    break;
                case MainMenu.OP_CADASTROS:
                    new FilmeUI(listaFilmes).executar();
                    break;
                case MainMenu.OP_RELATORIOS:
                    break;
                case MainMenu.OP_SAIR:
                    System.out.println("Aplicação finalizada!!!");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != MainMenu.OP_SAIR);
    }

}
