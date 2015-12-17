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
     * Mensagem não personalizavel de retorno com tratamento de Exception.
     *
     * @param janela necessário para o método, pode ser null
     * @param e o excepetion que será exibido
     */
    public static void printMessageErro(JFrame janela, Exception e) {
        JOptionPane.showMessageDialog(janela,
                "Ocorreu um erro " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Mensagem personalizavel de retorno com tratamento de Exception.
     *
     * @param janela necessário para o método, pode ser null
     * @param msg
     * @param e o excepetion que será exibido
     */
    public static void printMessageErro(JFrame janela, String msg, Exception e) {
        JOptionPane.showMessageDialog(janela,
                msg + "\n " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Mensagem de retorno com opção de informar texto adicional.
     *
     * @param janela Necessário para o método, pode ser null
     * @param msg Mensagem a ser exibita(não utilizado)
     */
    public static void printMessageCancelar(JFrame janela, String msg) {
        JOptionPane.showMessageDialog(janela,
                "Operação cancelada."
                + "\n " + msg,
                "Ops!",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Mensagem de retorno apenas com aviso de operação cancelada.
     *
     * @param janela Necessário para o método, pode ser null
     */
    public static void printMessageCancelar(JFrame janela) {
        JOptionPane.showMessageDialog(janela,
                "Operação cancelada.",
                "Ops!",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Mensagem de retorno para operação realizada com sucesso.
     *
     * @param janela - necessário para o método, pode ser null
     * @param msg - mensagem a ser exibita(não utilizado)
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
     * @param janela - necessário para o método, pode ser null
     * @param msg - mensagem a ser exibita(não utilizado)
     * @return - Retorna a resposta no formato JOptionPane.YES_NO_OPTION
     */
    public static int printMessagePergunta(JFrame janela, String msg) {
        int t = JOptionPane.showConfirmDialog(janela,
                "Confirmar a operação?",
                "Confirme a operação",
                JOptionPane.YES_NO_OPTION);
        return t;
    }

}
