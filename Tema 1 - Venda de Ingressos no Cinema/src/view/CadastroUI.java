package view;

import repositorio.RepositorioFilmes;
import repositorio.RepositorioSalas;
import repositorio.RepositorioSessao;
import util.Console;
import view.menu.CadastroMenu;

/**
 *
 * @author gserafini
 */
public class CadastroUI {

    private RepositorioSessao sessao;
    private RepositorioFilmes listaFilmes;
    private RepositorioSalas listaSalas;
    private SessaoUI sessaoUI;

    public CadastroUI(RepositorioSessao sessao, RepositorioSalas listaSalas, RepositorioFilmes listaFilmes, SessaoUI sessaoUI) {
        this.sessao = sessao;
        this.listaSalas = listaSalas;
        this.listaFilmes = listaFilmes;
        this.sessaoUI = sessaoUI;
    }

    public void executar() {
        int opcao = 0;
        do {
            System.out.println(CadastroMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case CadastroMenu.OP_CADASTROFILME:
                    new FilmeUI(listaFilmes).executar();
                    break;
                case CadastroMenu.OP_CADASTROSALA:
                    new SalaUI(listaSalas).executar();
                    break;
                case CadastroMenu.OP_CADASTROSESSAO:
                    sessaoUI.executar();
                    break;
                case CadastroMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu anterior..");
                    break;
                default:
                    System.out.println("Opção inválida..");
            }
        } while (opcao != CadastroMenu.OP_VOLTAR);
    }

}
