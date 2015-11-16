/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import util.Console;
import view.menu.VendaIngressoMenu;

/**
 *
 * @author Eckowz
 */
public class VendaIngressoUI {

    public VendaIngressoUI() {

    }
//
//    public void executar() {
//        int opcao = 0;
//        do {
//            System.out.println(VendaIngressoMenu.getOpcoes());
//            opcao = Console.scanInt("Digite sua opção:");
//            switch (opcao) {
//                case VendaIngressoMenu.OP_VENDAINGRESSOS:
//                    registraVenda();
//                    break;
//                case VendaIngressoMenu.OP_LISTASESSAO:
//                    sessaoUI.listarHorariosComAssentos();
//                    break;
//                case VendaIngressoMenu.OP_VOLTAR:
//                    System.out.println("Retornando ao menu anterior..");
//                    break;
//                default:
//                    System.out.println("Opção inválida..");
//            }
//        } while (opcao != VendaIngressoMenu.OP_VOLTAR);
//    }
//
//    private void registraVenda() {
//        int cod = 0;
//        sessaoUI.listarHorariosComAssentos();
//        cod = Console.scanInt("Informe o código da sessão para a venda: ");
//        if (sessao.sessaoExistePorCodigo(cod)) {
//            if(sessao.temAssento(cod)){
//                sessao.ocupaAssento(cod);
//                System.out.println("Assentos disponiveis: " + sessao.listarAssentosDisponiveisPorSessao(cod) + ".");
//            }else{
//                System.out.println("Não há assentos disponiveis.");
//            }
//        }else{
//            System.out.println("Sessão não localizada.");
//        }
//    }
//    
    
}
