package view;

import repositorio.RepositorioFilmes;
import repositorio.RepositorioSalas;
import repositorio.Sessao;
import util.Console;
import view.menu.MainMenu;

/**
 *
 * @author lhries
 */
public class MainUI {

    private RepositorioFilmes listaFilmes;
    private RepositorioSalas listaSalas;
    private Sessao sessoes;

    public MainUI() {
        listaFilmes = new RepositorioFilmes();
        listaSalas = new RepositorioSalas();
        sessoes = new Sessao();
    }

    public void executar() {
        int opcao = 0;
        do {
            System.out.println(MainMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case MainMenu.OP_VENDAINGRESSOS:
                    new VendaIngressoUI(sessoes, listaSalas, listaFilmes).executar();
                    break;
                case MainMenu.OP_CADASTROS:
                    new CadastroUI(sessoes, listaSalas, listaFilmes).executar();
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
