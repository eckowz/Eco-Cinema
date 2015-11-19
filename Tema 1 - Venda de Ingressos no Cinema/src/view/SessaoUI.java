package view;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import model.Sessao;
import model.Filme;
import model.Sala;
import servico.FilmeServico;
import servico.SalaServico;
import servico.SessaoServico;
import util.Console;
import util.DateUtil;
import view.menu.SessaoMenu;

public class SessaoUI {

    private FilmeServico filmeServico;
    private SalaServico salaServico;
    private SessaoServico sessaoServico;

    public SessaoUI() {
        this.filmeServico = new FilmeServico();
        this.salaServico = new SalaServico();
        this.sessaoServico = new SessaoServico();
    }

    public void executar() {

        int opcao = 0;
        do {
            System.out.println(SessaoMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case SessaoMenu.OP_NOVO:
                    cadastrarSessao();
                    break;
                case SessaoMenu.OP_REMOVER:
                    removerSessao();
                    break;
                case SessaoMenu.OP_EDITAR:
                    editarHorario();
                    break;
                case SessaoMenu.OP_LISTAR:
                    listarHorarios();
                    break;
                case SessaoMenu.OP_CONSULTARFILME:
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

    private void cadastrarSessao() {
        try {
            System.out.println("Lista de salas existentes: ");
            new SalaUI().mostrarSalas();
            int codigoSala = Console.scanInt("\nInforme o código da sala: ");
            Sala sala = salaServico.procurarPorCodSala(codigoSala);

            if (sala != null) {
                System.out.println("Lista de filmes disponiveis: ");
                new FilmeUI().mostrarFilmes();
                int codigoFilme = Console.scanInt("\nInforme o código do filme: ");
                Filme filme = filmeServico.procurarPorIdFilme(codigoFilme);

                if (filmeServico.filmeExisteId(codigoFilme)) {
                    String dataHora = Console.scanString("Data/Hora (dd/mm/aaaa hh:mm):");
                    Date horario;
                    try {
                        horario = DateUtil.stringToDateHour(dataHora);

                        //if (sessao.sessaoExiste(horario)) {
                        //    System.out.println("Esse horario já existe para outra sessão.");
                        //} else {
                        Sessao sessao = new Sessao(horario, filme, sala, sala.getQuantidadeAssentos());
                        sessaoServico.adicionarSessao(sessao);
                        System.out.println("Sessão cadastrada com sucesso!");
                        //}
                    } catch (Exception e) {
                        System.out.println("Data ou hora no formato inválido!");
                    }
                } else {
                    System.out.println("Filme não encontrado!");
                }

            } else {
                System.out.println("Sala não encontrada!");
            }
        } catch (InputMismatchException ex) {
            System.out.println("Código inválido.");
        }
    }

    public void listarHorarios() {
        if (sessaoServico.listarSessoes().isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
        } else {
            System.out.println("-----------------------------\n");
            System.out.println(String.format("%-10s", "CÓDIGO") + "\t"
                    + String.format("%-20s", "|HORÁRIO") + "\t"
                    + String.format("%-20s", "|FILME") + "\t"
                    + String.format("%-5s", "|SALA") + "\t"
                    + String.format("%-5s", "|ASSENTOS DISP."));
            for (Sessao horario : sessaoServico.listarSessoes()) {
                System.out.println(String.format("%-10s", horario.getIdSessao()) + "\t"
                        + String.format("%-20s", "|" + DateUtil.dateHourToString(horario.getHorario())) + "\t"
                        + String.format("%-20s", "|" + horario.getFilme().getNomeFilme()) + "\t"
                        + String.format("%-5s", "|" + horario.getSala().getCodSala()) + "\t"
                        + String.format("%-5s", "|" + horario.getAssentosDisponiveis())
                );
            }
        }
    }

    private void editarHorario() {
        System.out.println("Não implementado.");
    }

    private void consultarHorarios() {
        System.out.println("Não implementado.");
    }

    private void removerSessao() {
        if (sessaoServico.listarSessoes().isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
        } else {
            listarHorarios();
            try {
                int idSessao = Console.scanInt("\nInforme o código da sessão: ");
                if (sessaoServico.sessaoExiste(idSessao)) {
                    sessaoServico.removerSessao(sessaoServico.procurarPorIdSessao(idSessao));
                    System.out.println("Sessão " + idSessao + " removida.");
                } else {
                    System.out.println("Sessão não encontrada.");
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro.");
            }
        }
    }
}
