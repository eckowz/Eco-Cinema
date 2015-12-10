/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.FilmeController;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 631120345
 */
public class JanelaCrudFilme extends JFrame {

    private FilmeController controller;

    public final static String PAINELFORM = "Formulario Filme";
    public final static String PAINELTABELA = "Lista Filme";
    private JPanel painelPrincipal;
    private PainelFormularioFilme painelFormulario;
    private PainelTabelaFilme painelTabela;

    public JanelaCrudFilme(FilmeController controller) {
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
        painelTabela = new PainelTabelaFilme(controller);
        painelPrincipal.add(painelTabela, PAINELTABELA);
        painelFormulario = new PainelFormularioFilme(controller);
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

    public void mostrarPainelFilme(String painel) {
        CardLayout card = (CardLayout) (painelPrincipal.getLayout());
        card.show(painelPrincipal, painel);

    }

    public PainelFormularioFilme getPainelFormulario() {
        return painelFormulario;
    }

    public PainelTabelaFilme getPainelTabela() {
        return painelTabela;
    }

    public void setController(FilmeController controller) {
        this.controller = controller;
    }

}
