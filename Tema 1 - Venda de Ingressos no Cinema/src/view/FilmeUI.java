package view;

import model.Filme;
import view.menu.FilmeMenu;
import servico.FilmeServico;
import util.Console;

/**
 *
 * @author lhries
 */
public class FilmeUI {

    private FilmeServico filmeServico;

    public FilmeUI() {
        this.filmeServico = new FilmeServico();
    }

    public void executar() {
        int opcao = 0;
        do {
            System.out.println(FilmeMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case FilmeMenu.OP_CADASTRAR:
                    cadastrarFilme();
                    break;
                case FilmeMenu.OP_REMOVER:
                    mostrarFilmes();
                    deletarFilme();
                case FilmeMenu.OP_LISTAR:
                    mostrarFilmes();
                    break;
                case FilmeMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");
            }
        } while (opcao != FilmeMenu.OP_VOLTAR);
    }

    private void cadastrarFilme() {
        String nome = "", genero = "", sinopse = "";

        do {
            nome = Console.scanString("Nome do filme: ").toUpperCase();
            genero = Console.scanString("Gênero: ").toUpperCase();
            sinopse = Console.scanString("Sinopse: ").toUpperCase();
            if (!(nome.equals("") || genero.equals("") || sinopse.equals(""))) {
                try {
                    filmeServico.addFilme(new Filme(nome, genero, sinopse));
                    System.out.println("Título " + nome + " cadastrado com sucesso!");
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro ao salvar!");
                }
            } else {
                System.out.println("Nenhum campo pode ser em branco.");
            }

        } while (nome.equals("") || genero.equals("") || sinopse.equals(""));
    }

    public void mostrarFilmes() {
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "CÓDIGO") + "\t"
                + String.format("%-20s", "|NOME DO FILME") + "\t"
                + String.format("%-20s", "|GÊNERO") + "\t"
                + String.format("%-20s", "|SINOPSE"));
        for (Filme filme : filmeServico.listarFilmes()) {
            System.out.println(String.format("%-10s", filme.getIdFilme()) + "\t"
                    + String.format("%-20s", "|" + filme.getNomeFilme()) + "\t"
                    + String.format("%-20s", "|" + filme.getGeneroFilme()) + "\t"
                    + String.format("%-20s", "|" + filme.getSinopseFilme()));
        }
    }

    private void deletarFilme() {
        System.out.println("Nao implementado.");
    }
}
