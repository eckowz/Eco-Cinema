package view;

import java.util.Date;
import java.util.InputMismatchException;
import model.Filme;
import model.Sessao;
import model.Sala;
import repositorio.RepositorioFilmes;
import repositorio.RepositorioSalas;
import repositorio.RepositorioSessao;
import util.Console;
import util.DateUtil;
import view.menu.MainMenu;

/**
 *
 * @author lhries
 */
public class MainUI {

    private RepositorioFilmes listaFilmes;
    private RepositorioSalas listaSalas;
    private RepositorioSessao listaSessoes;
    private SessaoUI sessaoUI;

    public MainUI() {
        listaFilmes = new RepositorioFilmes();
        listaSalas = new RepositorioSalas();
        listaSessoes = new RepositorioSessao();
        sessaoUI = new SessaoUI(listaSessoes, listaSalas, listaFilmes);
        try {
            listaSalas.addSalas(new Sala(1, 45));
            listaFilmes.addFilmes(new Filme(1, "TesteTítulo", "TesteGenero", "TesteSinopse"));
            Filme filme = listaFilmes.buscarFilme(1);
            Sala sala = listaSalas.buscarSala(1);

            Date dataSessaoTeste = DateUtil.stringToDateHour("28/05/2015 15:30");
            listaSessoes.addHorario(new Sessao(dataSessaoTeste, filme, sala));
        } catch (Exception e) {
            System.out.println("Erro.");
        }

    }

    public void executar() {

        int opcao = -1;
        do {
            System.out.println(MainMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");

            switch (opcao) {
                case MainMenu.OP_VENDAINGRESSOS:
                    new VendaIngressoUI(listaSessoes, sessaoUI).executar();
                    break;
                case MainMenu.OP_CADASTROS:
                    new CadastroUI(listaSessoes, listaSalas, listaFilmes, sessaoUI).executar();
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
