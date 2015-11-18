package view;

import java.util.Date;
import java.util.InputMismatchException;
import model.Filme;
import model.Sessao;
import model.Sala;
import util.Console;
import util.DateUtil;
import view.menu.MainMenu;

/**
 *
 * @author lhries
 */
public class MainUI {

    public MainUI() {
    }

    public void executar() {

        int opcao = -1;
        do {
            System.out.println(MainMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");

            switch (opcao) {
                case MainMenu.OP_VENDAINGRESSOS:
                    new VendaIngressoUI().executar();
                    break;
                case MainMenu.OP_CADASTROS:
                    new CadastroUI().executar();
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
