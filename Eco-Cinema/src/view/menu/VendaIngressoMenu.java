/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menu;

/**
 *
 * @author Eckowz
 */
public class VendaIngressoMenu {

    public static final int OP_VENDAINGRESSOS = 1;
    public static final int OP_LISTASESSAO = 2;
    public static final int OP_VOLTAR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1- Realizar venda\n"
                + "2- Listar sessões\n"
                + "0- Voltar"
                + "\n--------------------------------------");
    }    
}
