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
 * @author lhries
 */
public class PrintUtil {
    public static void printMessageError(JFrame janela, String msg) {
            JOptionPane.showMessageDialog(janela, 
                    msg,
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);        
    }

    public static void printMessageSucesso(JFrame janela, String msg) {
            JOptionPane.showMessageDialog(janela, 
                    msg,
                    "Sucesso",
                    JOptionPane.PLAIN_MESSAGE);        
    }    
}
