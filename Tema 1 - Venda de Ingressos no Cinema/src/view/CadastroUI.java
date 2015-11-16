package view;

import util.Console;
import view.menu.CadastroMenu;

/**
 *
 * @author gserafini
 */
public class CadastroUI {

    public CadastroUI() {
    }

    public void executar() {
        int opcao = 0;
        do {
            System.out.println(CadastroMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case CadastroMenu.OP_CADASTROFILME:
                    new FilmeUI().executar();
                    break;
                case CadastroMenu.OP_CADASTROSALA:
                    new SalaUI().executar();
                    break;
                case CadastroMenu.OP_CADASTROSESSAO:
                    //sessaoUI.executar();
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
