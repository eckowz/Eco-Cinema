package view;

import repositorio.RepositorioFilmes;
import repositorio.RepositorioSalas;
import repositorio.Sessao;
import util.Console;
import view.menu.CadastroMenu;

/**
 *
 * @author gserafini
 */
public class CadastroUI {

    private Sessao sessao;
    private RepositorioFilmes listaFilmes;
    private RepositorioSalas listaSalas;

    public CadastroUI(Sessao sessao, RepositorioSalas listaSalas, RepositorioFilmes listaFilmes) {
        this.sessao = sessao;
        this.listaSalas = listaSalas;
        this.listaFilmes = listaFilmes;
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
                    new SessaoUI(sessao, listaSalas, listaFilmes).executar();
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
