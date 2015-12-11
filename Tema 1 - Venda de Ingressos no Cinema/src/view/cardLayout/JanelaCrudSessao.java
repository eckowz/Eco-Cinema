/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.cardLayout;

import controller.cardLayout.SessaoController;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 631120345
 */
public class JanelaCrudSessao extends JFrame {

    private SessaoController controller;

    public final static String PAINELFORM = "Formulario Sessao";
    public final static String PAINELTABELA = "Lista Sessao";
    private JPanel painelPrincipal;
    private PainelFormularioSessao painelFormulario;
    private PainelTabelaSessao painelTabela;

    public JanelaCrudSessao(SessaoController controller) {
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
        painelTabela = new PainelTabelaSessao(controller);
        painelPrincipal.add(painelTabela, PAINELTABELA);
        painelFormulario = new PainelFormularioSessao(controller);
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

    public void mostrarPainelSessao(String painel) {
        CardLayout card = (CardLayout) (painelPrincipal.getLayout());
        card.show(painelPrincipal, painel);

    }

    public PainelFormularioSessao getPainelFormulario() {
        return painelFormulario;
    }

    public PainelTabelaSessao getPainelTabela() {
        return painelTabela;
    }

    public void setController(SessaoController controller) {
        this.controller = controller;
    }

}
