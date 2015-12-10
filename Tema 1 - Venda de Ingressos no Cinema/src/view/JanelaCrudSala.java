/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.SalaController;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 631120345
 */
public class JanelaCrudSala extends JFrame {

    private SalaController controller;

    public final static String PAINELFORM = "Formulario Sala";
    public final static String PAINELTABELA = "Lista Sala";
    private JPanel painelPrincipal;
    private PainelFormularioSala painelFormulario;
    private PainelTabelaSala painelTabela;

    public JanelaCrudSala(SalaController controller) {
        this.controller = controller;
        this.controller.setJanela(this);
        iniciaComponentes();
        controller.atualizaTabela();
        this.setTitle("Eco-Cinema");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private void iniciaComponentes() {
        painelPrincipal = new JPanel(new CardLayout());
        painelTabela = new PainelTabelaSala(controller);
        painelPrincipal.add(painelTabela, PAINELTABELA);
        painelFormulario = new PainelFormularioSala(controller);
        painelPrincipal.add(painelFormulario, PAINELFORM);

        this.add(painelPrincipal);
//
//        painelBotoes = new JPanel(new FlowLayout());
//        botaoFormulario = new JButton(PAINELFORM);
//        botaoFormulario.addActionListener(new TrataBotoes());
//        painelBotoes.add(botaoFormulario);
//        botaoTabela = new JButton(PAINELTABELA);
//        botaoTabela.addActionListener(new TrataBotoes());
//        painelBotoes.add(botaoTabela);
//        this.add(painelBotoes, BorderLayout.NORTH);

    }
//
//    private class TrataBotoes implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            CardLayout card = (CardLayout) (painelPrincipal.getLayout());
//            if (e.getSource().equals(botaoFormulario)) {
//                card.show(painelPrincipal, PAINELFORM);
//            }
//            if (e.getSource().equals(botaoTabela)) {
//                card.show(painelPrincipal, PAINELTABELA);
//            }
//        }
//
//    }

    public void mostrarPainelSala(String painel) {
        CardLayout card = (CardLayout) (painelPrincipal.getLayout());
        card.show(painelPrincipal, painel);

    }

    public PainelFormularioSala getPainelFormulario() {
        return painelFormulario;
    }

    public PainelTabelaSala getPainelTabela() {
        return painelTabela;
    }

    public void setController(SalaController controller) {
        this.controller = controller;
    }

}
