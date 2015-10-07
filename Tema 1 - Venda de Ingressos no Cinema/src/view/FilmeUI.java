package view;

import model.Filme;
import repositorio.RepositorioFilmes;
import util.Console;
import view.menu.FilmeMenu;

/**
 *
 * @author lhries
 */
public class FilmeUI {

    private RepositorioFilmes lista;

    public FilmeUI(RepositorioFilmes lista) {
        this.lista = lista;
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
        int codigo = Console.scanInt("Código: ");
        if (lista.filmeExiste(codigo)) {
            System.out.println("Código já existente no cadastro");
        } else {
            String nome = Console.scanString("Nome do filme: ").toUpperCase();
            String genero = Console.scanString("Gênero: ").toUpperCase();
            String sinopse = Console.scanString("Sinopse: ").toUpperCase();
            try {
                lista.addFilmes(new Filme(codigo, nome, genero, sinopse));
                System.out.println("Título " + nome + " cadastrado com sucesso!");
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao salvar!");
            }
        }
    }

    public void mostrarFilmes() {
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "CÓDIGO") + "\t"
                + String.format("%-20s", "|NOME DO FILME") + "\t"
                + String.format("%-20s", "|GÊNERO") + "\t"
                + String.format("%-20s", "|SINOPSE"));
        for (Filme filme : lista.getListaFilmes()) {
            System.out.println(String.format("%-10s", filme.getCodigoFilme()) + "\t"
                    + String.format("%-20s", "|" + filme.getNomeFilme()) + "\t"
                    + String.format("%-20s", "|" + filme.getGeneroFilme()) + "\t"
                    + String.format("%-20s", "|" + filme.getSinopseFilme()));
        }
    }
}
