/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Eckowz
 */
public class PrintUtil {

    /**
     * Mensagem de retorno com tratamento de Exception.
     *
     * @param janela
     * @param msg
     * @param e
     */
    public static void printMessageErro(JFrame janela, String msg, Exception e) {
        JOptionPane.showMessageDialog(janela,
                "Ocorreu um erro " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Mensagem de retorno apenas com aviso de operação cancelada.
     *
     * @param janela
     * @param msg
     */
    public static void printMessageCancelar(JFrame janela, String msg) {
        JOptionPane.showMessageDialog(janela,
                "Operação cancelada.",
                "Erro",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Mensagem de retorno para operação realizada com sucesso.
     *
     * @param janela
     * @param msg
     */
    public static void printMessageSucesso(JFrame janela, String msg) {
        JOptionPane.showMessageDialog(janela,
                "Operação realizada com sucesso.",
                "Sucesso",
                JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Confirma ou cancela a operação, retorna o parametro da escolha.
     *
     * @param janela
     * @param msg
     * @return
     */
    public static int printMessagePergunta(JFrame janela, String msg) {
        int t = JOptionPane.showConfirmDialog(janela,
                "Confirmar a operação?",
                "Confirme a operação",
                JOptionPane.YES_NO_OPTION);
        return t;
    }

}
