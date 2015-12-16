/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Filme;
import model.Sala;
import model.Sessao;
import servico.FilmeServico;
import servico.SalaServico;
import servico.SessaoServico;
import util.DateUtil;

/**
 *
 * @author Eckowz
 */
public class jIntFrameCadSessao extends javax.swing.JInternalFrame {

    FilmeServico filmeServico;
    SalaServico salaServico;
    SessaoServico sessaoServico;

    /**
     * Creates new form jIntFrameCadSessao
     */
    public jIntFrameCadSessao() {
        initComponents();
        filmeServico = new FilmeServico();
        salaServico = new SalaServico();
        sessaoServico = new SessaoServico();
        carregarDadosSala();
        carregarDadosFilme();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonCadastrarSessao = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCombFilme = new javax.swing.JComboBox();
        jCombSala = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jCombHora = new javax.swing.JComboBox();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastrar Sessão");
        setToolTipText("");
        setMaximumSize(new java.awt.Dimension(575, 537));
        setMinimumSize(new java.awt.Dimension(575, 537));
        setName(""); // NOI18N
        setOpaque(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonCadastrarSessao.setText("Cadastrar");
        jButtonCadastrarSessao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarSessaoActionPerformed(evt);
            }
        });

        jLabel3.setText("Informe a Sala:");

        jLabel2.setText("Informe o Filme:");

        jLabel1.setText("Informe o horário:");

        jCombHora.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00:00:00", "00:30:00", "01:00:00", "01:30:00", "02:00:00", "02:30:00", "03:00:00", "03:30:00", "04:00:00", "04:30:00", "05:00:00", "05:30:00", "06:00:00", "06:30:00", "07:00:00", "07:30:00", "08:00:00", "08:30:00", "09:00:00", "09:30:00", "10:00:00", "10:30:00", "11:00:00", "11:30:00", "12:00:00", "12:30:00", "13:00:00", "13:30:00", "14:00:00", "14:30:00", "15:00:00", "15:30:00", "16:00:00", "16:30:00", "17:00:00", "17:30:00", "18:00:00", "18:30:00", "19:00:00", "19:30:00", "20:00:00", "20:30:00", "21:00:00", "21:30:00", "22:00:00", "22:30:00", "23:00:00", "23:30:00", " " }));

        jDateChooser.setDate(new Date());
        jDateChooser.setDateFormatString("dd/MM/yyyy");

        jLabel4.setText("Informe a data:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCombHora, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCombFilme, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCombSala, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonCadastrarSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCombFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jCombSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCombHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jButtonCadastrarSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        setBounds(0, 0, 575, 537);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Carrega os registros do banco para uma lista e preenche a tabela com
     * esses registros.
     */
    private void carregarDadosFilme() {
        List<Filme> lista;
        lista = filmeServico.listarFilmes();

        for (int i = 0; i < lista.size(); i++) {
            jCombFilme.addItem(lista.get(i));

        }
    }

    /**
     * Carrega os registros do banco para uma lista e preenche a tabela com
     * esses registros.
     */
    private void carregarDadosSala() {
        List<Sala> lista;
        lista = salaServico.listarSalas();

        for (int i = 0; i < lista.size(); i++) {
            jCombSala.addItem(lista.get(i));
        }
    }

    /**
     * Realiza a leitura dos campos do formulario e os adiciona ao banco através
     * dos serviços.
     */
    public void cadSessao() {
        try {
            Sessao sessao = new Sessao();

            String hora = (String) jCombHora.getSelectedItem();
            String data = DateUtil.dateToString((Date) jDateChooser.getDate());

            String tempDataHora = "" + data + " " + hora;
            Date dataHora = DateUtil.stringToDateHour(tempDataHora);

            Sala sala = (Sala) jCombSala.getSelectedItem();
            int assentosDisp = sala.getQuantidadeAssentos();

            sessao.setHorario(dataHora);
            sessao.setFilme((Filme) jCombFilme.getSelectedItem());
            sessao.setSala((Sala) jCombSala.getSelectedItem());
            sessao.setAssentosDisponiveis(assentosDisp);

            sessaoServico.adicionarSessao(sessao);

            PrintUtil.printMessageSucesso(null, title);
        } catch (ParseException | NullPointerException ex) {
            PrintUtil.printMessageErro(null, "Nenhum item pode estar em branco.", ex);
        }
    }

    private void jButtonCadastrarSessaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarSessaoActionPerformed
        cadSessao();
    }//GEN-LAST:event_jButtonCadastrarSessaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrarSessao;
    private javax.swing.JComboBox jCombFilme;
    private javax.swing.JComboBox jCombHora;
    private javax.swing.JComboBox jCombSala;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
