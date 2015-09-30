package view;

import java.util.Date;
import model.HorarioSessao;
import model.Filme;
import model.Sala;
import repositorio.Sessao;
import repositorio.RepositorioFilmes;
import repositorio.RepositorioSalas;
import util.Console;
import util.DateUtil;
import view.menu.SessaoMenu;

public class SessaoUI {

    private Sessao sessao;
    private RepositorioFilmes listaFilmes;
    private RepositorioSalas listaSalas;

    public SessaoUI(Sessao sessao, RepositorioSalas listaSalas, RepositorioFilmes listaFilmes) {
        this.sessao = sessao;
        this.listaSalas = listaSalas;
        this.listaFilmes = listaFilmes;

    }

    public void executar() {
        int opcao = 0;
        do {
            System.out.println(SessaoMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case SessaoMenu.OP_NOVO:
                    cadastrarHorario();
                    break;
                case SessaoMenu.OP_REMOVER:
                    removerHorario();
                    break;
                case SessaoMenu.OP_EDITAR:
                    editarHorario();
                    break;
                case SessaoMenu.OP_LISTAR:
                    listarHorarios();
                    break;
                case SessaoMenu.OP_CONSULTAR:
                    consultarHorarios();
                    break;
                case SessaoMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != SessaoMenu.OP_VOLTAR);
    }

    private void cadastrarHorario() {
        System.out.println("Lista de salas existentes: ");
        new SalaUI(listaSalas).mostrarSalas();
        int codigoSala = Console.scanInt("\nInforme o código da sala: ");

        if (listaSalas.salaExiste(codigoSala)) {
            System.out.println("Lista de filmes disponiveis: ");
            new FilmeUI(listaFilmes).mostrarFilmes();
            int codigoFilme = Console.scanInt("\nInforme o código do filme: ");

            if (listaFilmes.filmeExiste(codigoFilme)) {
                Filme filme = listaFilmes.buscarFilme(codigoFilme);
                Sala sala = listaSalas.buscarSala(codigoSala);
                String dataHora = Console.scanString("Data/Hora (dd/mm/aaaa hh:mm):");
                Date horario;
                try {
                    horario = DateUtil.stringToDateHour(dataHora);
                    if (sessao.consultaExiste(horario)) {
                        System.out.println("Nesse horario já existe outra sessão");
                    }
                    sessao.addHorario(new HorarioSessao(horario, filme, sala));
                    System.out.println("Sessão cadastrada com sucesso!");
                } catch (Exception e) {
                    System.out.println("Data ou hora no formato inválido!");
                }
            } else {
                System.out.println("Filme não encontrado!");
            }

        } else {
            System.out.println("Sala não encontrada!");
        }
    }

    public void listarHorarios() {
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-20s", "HORÁRIO") + "\t"
                + String.format("%-20s", "|SALA") + "\t"
                + String.format("%-20s", "|FILME"));
        for (HorarioSessao horario : sessao.getListaHorarios()) {
            System.out.println(String.format("%-20s", DateUtil.dateHourToString(horario.getHorario())) + "\t"
                    + String.format("%-20s", "|" + horario.getSala().getCodigoSala()) + "\t"
                    + String.format("%-20s", "|" + horario.getFilme().getNomeFilme()) );
        }
    }

    private void removerHorario() {
        //Definir o método
    }

    private void editarHorario() {
        //Definir o método
    }

    private void consultarHorarios() {
        //Definir o método
    }
}
