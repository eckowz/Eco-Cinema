/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import repositorio.RepositorioFilmes;
import repositorio.RepositorioSalas;
import repositorio.Sessao;
import util.Console;
import view.menu.VendaIngressoMenu;

/**
 *
 * @author Eckowz
 */
public class VendaIngressoUI {

    private Sessao sessao;
    private SessaoUI sessaoUI;
    private RepositorioFilmes listaFilmes;
    private RepositorioSalas listaSalas;

    public VendaIngressoUI(Sessao sessao, RepositorioSalas listaSalas, RepositorioFilmes listaFilmes) {
        this.sessao = sessao;
        this.listaSalas = listaSalas;
        this.listaFilmes = listaFilmes;
    }

    public void executar() {
        int opcao = 0;
        do {
            System.out.println(VendaIngressoMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case VendaIngressoMenu.OP_VENDAINGRESSOS:
                    break;
                case VendaIngressoMenu.OP_LISTASESSAO:
                    new SessaoUI(sessao, listaSalas, listaFilmes).listarHorarios();
                    break;
                case VendaIngressoMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu anterior..");
                    break;
                default:
                    System.out.println("Opção inválida..");
            }
        } while (opcao != VendaIngressoMenu.OP_VOLTAR);
    }
}
