package view;

import model.Sala;
import repositorio.RepositorioSalas;
import util.Console;
import view.menu.SalaMenu;

/**
 *
 * @author lhries
 */
public class SalaUI {

    private RepositorioSalas lista;

    public SalaUI(RepositorioSalas lista) {
        this.lista = lista;
    }

    public void executar() {
        int opcao = 0;
        do {
            System.out.println(SalaMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case SalaMenu.OP_CADASTRAR:
                    cadastrarSala();
                    break;
                case SalaMenu.OP_REMOVER:
                    mostrarSalas();
                    lista.removerSala();
                    break;
                case SalaMenu.OP_LISTAR:
                    mostrarSalas();
                    break;
                case SalaMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");
            }
        } while (opcao != SalaMenu.OP_VOLTAR);
    }

    private void cadastrarSala() {
        int codigo = Console.scanInt("Código: ");
        if (lista.salaExiste(codigo)) {
            System.out.println("Código já existente no cadastro");
        } else {
            int qtdAssentos = Console.scanInt("Quantidade de assentos: ");
            try {
                lista.addSalas(new Sala(codigo, qtdAssentos));
                System.out.println("Sala " + codigo + " cadastrada com sucesso!");
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao salvar!");
            }
        }
    }

    public void mostrarSalas() {
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "CÓDIGO") + "\t"
                + String.format("%-20s", "|QUANTIDADE DE ASSENTOS"));
        for (Sala sala : lista.getListaSalas()) {
            System.out.println(String.format("%-10s", sala.getCodigoSala()) + "\t"
                    + String.format("%-20s", "|" + sala.getQuantidadeAssentos()));
        }
    }
}
