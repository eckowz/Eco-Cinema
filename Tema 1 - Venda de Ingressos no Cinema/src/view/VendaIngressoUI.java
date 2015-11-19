/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.InputMismatchException;
import servico.SessaoServico;
import servico.VendaIngressoServico;
import util.Console;
import view.menu.VendaIngressoMenu;
import model.Sessao;

/**
 *
 * @author Eckowz
 */
public class VendaIngressoUI {

    private VendaIngressoServico vendaIngressoServico;
    private SessaoServico sessaoServico;

    public VendaIngressoUI() {
        this.vendaIngressoServico = new VendaIngressoServico();
        this.sessaoServico = new SessaoServico();
    }

    public void executar() {
        int opcao = 0;
        do {
            System.out.println(VendaIngressoMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case VendaIngressoMenu.OP_VENDAINGRESSOS:
                    registraVenda();
                    break;
                case VendaIngressoMenu.OP_LISTASESSAO:
                    new SessaoUI().listarHorarios();
                    break;
                case VendaIngressoMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu anterior..");
                    break;
                default:
                    System.out.println("Opção inválida..");
            }
        } while (opcao != VendaIngressoMenu.OP_VOLTAR);
    }

    private void registraVenda() {
        int cod = 0;
        new SessaoUI().listarHorarios();
        try {
            cod = Console.scanInt("Informe o código da sessão para a venda: ");
            if (sessaoServico.sessaoExiste(cod)) {
                if (sessaoServico.assentosDisponiveis(cod) > 0) {
                    sessaoServico.ocupaAssento(sessaoServico.procurarPorIdSessao(cod));
                    System.out.println("Assentos disponiveis: " + sessaoServico.assentosDisponiveis(cod) + ".");
                } else {
                    System.out.println("Não há assentos disponiveis.");
                }
            } else {
                System.out.println("Sessão não localizada.");
            }
        } catch (InputMismatchException ex) {
            System.out.println("Código inválido.");
        }
    }

}
