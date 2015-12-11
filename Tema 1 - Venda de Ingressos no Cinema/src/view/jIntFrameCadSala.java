/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.SalaController;
import java.awt.event.KeyEvent;
import servico.SalaServico;

/**
 *
 * @author gserafini
 */
public class jIntFrameCadSala extends javax.swing.JInternalFrame {

    SalaServico salaServico = new SalaServico();
    SalaController salaController = new SalaController();

    /**
     * Creates new form jIntFrameCadSala
     */
    public jIntFrameCadSala() {
        initComponents();
        this.isMaximum=true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextNumeroSala = new javax.swing.JTextField();
        jTextQuantidadeDeAssentos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonCadastrarSala = new javax.swing.JButton();
        jButtonLimparCadastro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setToolTipText("");
        setMaximumSize(new java.awt.Dimension(500, 400));
        setMinimumSize(new java.awt.Dimension(500, 400));
        setName(""); // NOI18N

        jLabel2.setText("Número da Sala");

        jLabel3.setText("Quantidade de Assentos");

        jButtonCadastrarSala.setText("Cadastrar");
        jButtonCadastrarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarSalaActionPerformed(evt);
            }
        });
        jButtonCadastrarSala.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonCadastrarSalaKeyPressed(evt);
            }
        });

        jButtonLimparCadastro.setText("Limpar");
        jButtonLimparCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparCadastroActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cadastro das Salas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCadastrarSala)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLimparCadastro))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextQuantidadeDeAssentos))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextNumeroSala)))
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(121, 121, 121))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextNumeroSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextQuantidadeDeAssentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCadastrarSala)
                    .addComponent(jButtonLimparCadastro))
                .addGap(28, 28, 28))
        );

        setBounds(0, 0, 410, 308);
    }// </editor-fold>//GEN-END:initComponents

    public void limpar() {
        jTextNumeroSala.setText("");
        jTextQuantidadeDeAssentos.setText("");
    }
    private void jButtonCadastrarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarSalaActionPerformed
        // TODO add your handling code here:
        salaController.salvarSala(
                Integer.parseInt(jTextNumeroSala.getText()),
                Integer.parseInt(jTextQuantidadeDeAssentos.getText()));
        limpar();
    }//GEN-LAST:event_jButtonCadastrarSalaActionPerformed

    private void jButtonCadastrarSalaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonCadastrarSalaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            salaController.salvarSala(
                    Integer.parseInt(jTextNumeroSala.getText()),
                    Integer.parseInt(jTextQuantidadeDeAssentos.getText()));
            limpar();
        }
    }//GEN-LAST:event_jButtonCadastrarSalaKeyPressed

    private void jButtonLimparCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparCadastroActionPerformed
        // TODO add your handling code here:
        limpar();
    }//GEN-LAST:event_jButtonLimparCadastroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrarSala;
    private javax.swing.JButton jButtonLimparCadastro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextNumeroSala;
    private javax.swing.JTextField jTextQuantidadeDeAssentos;
    // End of variables declaration//GEN-END:variables
}