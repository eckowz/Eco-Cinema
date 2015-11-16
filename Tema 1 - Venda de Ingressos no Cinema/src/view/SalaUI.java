package view;

import model.Sala;
import servico.SalaServico;
import util.Console;
import view.menu.SalaMenu;

/**
 *
 * @author lhries
 */
public class SalaUI {

    private SalaServico servicoSala;

    public SalaUI() {
        servicoSala = new SalaServico();
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
                    removerSala();
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
        int codigo = Console.scanInt("Código da Sala: ");
        if (servicoSala.salaExisteCodSala(codigo)) {
            System.out.println("Código já existente no cadastro");
        } else {
            int qtdAssentos = Console.scanInt("Quantidade de assentos: ");
            try {
                servicoSala.addSala(new Sala(codigo, qtdAssentos));
                System.out.println("Sala " + codigo + " cadastrada com sucesso!");
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao salvar!");
            }
        }
    }

    private void removerSala() {
        mostrarSalas();
        try {
            int codSala = Console.scanInt("\nInforme o código da sala: ");
            if (servicoSala.salaExisteCodSala(codSala)) {
                servicoSala.removerSala(servicoSala.procurarPorCodSala(codSala));
                System.out.println("Sala " + codSala + "removida.");
            } else {
                System.out.println("Sala não encontrada.");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro.");
        }
    }

    public void mostrarSalas() {
        System.out.println("-----------------------------\n");
        System.out.println(String.format("%-10s", "CÓDIGO") + "\t"
                + String.format("%-20s", "|QUANTIDADE DE ASSENTOS"));
        for (Sala sala : servicoSala.listarSalas()) {
            System.out.println(String.format("%-10s", sala.getCodSala()) + "\t"
                    + String.format("%-20s", "|" + sala.getQuantidadeAssentos()));
        }
    }
}
