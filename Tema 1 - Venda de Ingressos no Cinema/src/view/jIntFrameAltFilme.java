/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Filme;
import servico.FilmeServico;
import util.FixedLengthDocument;

/**
 *
 * @author gserafini
 */
public class jIntFrameAltFilme extends javax.swing.JInternalFrame {

    FilmeServico filmeServico;
    /**
     * Instância a tabela como uma DefaultTableModel para que possa ser
     * utilizada como objeto e bloqueia a tabela para edição manual.
     */
    DefaultTableModel tabela = new DefaultTableModel(new Object[][]{},
            new Object[]{"Número do Filme", "Nome do Filme", "Gênero do Filme", "Sinopse do Filme"}
    ) {
        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }
    };

    /**
     * Cria e inicializa o form jIntFrameAltFilme.
     */
    public jIntFrameAltFilme() {
        initComponents();
        filmeServico = new FilmeServico();
        carregarDados();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonDeletar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButtonConfirmarEdicao = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jTextNomeFilme = new javax.swing.JTextField();
        jTextGeneroFilme = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextNumFilme = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaFilme = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setClosable(true);
        setIconifiable(true);
        setTitle("Alterar Filmes");
        setRequestFocusEnabled(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Número do Filme", "Nome do Filme", "Gênero do Filme", "Sinopse do Filme"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButtonDeletar.setText("Deletar");
        jButtonDeletar.setEnabled(false);
        jButtonDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletarActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.setEnabled(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jButtonConfirmarEdicao.setText("Confirmar Edição");
        jButtonConfirmarEdicao.setEnabled(false);
        jButtonConfirmarEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarEdicaoActionPerformed(evt);
            }
        });

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome do Filme:");

        jLabel3.setText("Gênero do Filme:");

        jLabel4.setText("Número do Filme:");

        jTextNumFilme.setEnabled(false);

        jTextAreaFilme.setColumns(20);
        jTextAreaFilme.setDocument(new FixedLengthDocument(500));
        jTextAreaFilme.setLineWrap(true);
        jTextAreaFilme.setRows(5);
        jScrollPane2.setViewportView(jTextAreaFilme);

        jLabel1.setText("Sinopse:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextGeneroFilme))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextNomeFilme))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonConfirmarEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextNumFilme, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addGap(42, 42, 42))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextNumFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextNomeFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextGeneroFilme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonConfirmarEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 575, 537);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Carrega os registros do banco para uma lista e preenche a tabela com
     * esses registros.
     */
    private void carregarDados() {
        tabela.setNumRows(0);
        List<Filme> lista;
        lista = filmeServico.listarFilmes();

        for (Filme lista1 : lista) {
            tabela.addRow(new String[]{String.valueOf(lista1.getIdFilme()),
                String.valueOf(lista1.getNomeFilme()),
                String.valueOf(lista1.getGeneroFilme()),
                String.valueOf(lista1.getSinopseFilme())
            });

        }

        jTable1.setModel(tabela);
        jButtonEditar.setEnabled(false);
        jButtonDeletar.setEnabled(false);
        jButtonConfirmarEdicao.setEnabled(false);
    }

    /**
     * Limpa todos os campos do formulario.
     */
    public void limparCampos() {
        jTextNumFilme.setText("");
        jTextNomeFilme.setText("");
        jTextGeneroFilme.setText("");
        jTextAreaFilme.setText("");
        jButtonEditar.setEnabled(false);
        jButtonDeletar.setEnabled(false);
        jButtonConfirmarEdicao.setEnabled(false);
    }

    public void removerRegistro() {
        int linhaSelecionada = jTable1.getSelectedRow();
        Filme filme = new Filme();
        String numeroFilme = (String) jTable1.getValueAt(linhaSelecionada, 0);
        filme.setIdFilme(Integer.parseInt(numeroFilme));

        int pergunta = PrintUtil.printMessagePergunta(null, title);
        if (pergunta == JOptionPane.YES_OPTION) {
            filmeServico.removerFilme(filme);
            PrintUtil.printMessageSucesso(null, title);
        } else {
            PrintUtil.printMessageCancelar(null, title);
            carregarDados();
        }
    }

    public void editarLinha() {
        int linhaSelecionada = jTable1.getSelectedRow();
        if (linhaSelecionada != -1) {
            jTextNumFilme.setText((String) jTable1.getValueAt(linhaSelecionada, 0));
            jTextNomeFilme.setText((String) jTable1.getValueAt(linhaSelecionada, 1));
            jTextGeneroFilme.setText((String) jTable1.getValueAt(linhaSelecionada, 2));
            jTextAreaFilme.setText((String) jTable1.getValueAt(linhaSelecionada, 3));
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha!");
        }
    }

    public void confirmarEdicao() {
        try {
            Filme filme = new Filme();
            filme.setIdFilme(Integer.parseInt(jTextNumFilme.getText()));
            filme.setNomeFilme(jTextNomeFilme.getText());
            filme.setGeneroFilme(jTextGeneroFilme.getText());
            filme.setSinopseFilme(jTextAreaFilme.getText());

            filmeServico.atualizarFilme(filme);

        } catch (NumberFormatException | HeadlessException e) {
            PrintUtil.printMessageErro(null, title, e);
        }
        carregarDados();
    }


    private void jButtonDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeletarActionPerformed
        removerRegistro();
        carregarDados();
    }//GEN-LAST:event_jButtonDeletarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        editarLinha();
        jButtonConfirmarEdicao.setEnabled(true);
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        limparCampos();
        carregarDados();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonConfirmarEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarEdicaoActionPerformed
        confirmarEdicao();
        carregarDados();
        limparCampos();
    }//GEN-LAST:event_jButtonConfirmarEdicaoActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jButtonEditar.setEnabled(true);
        jButtonDeletar.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        carregarDados();
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfirmarEdicao;
    private javax.swing.JButton jButtonDeletar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextAreaFilme;
    private javax.swing.JTextField jTextGeneroFilme;
    private javax.swing.JTextField jTextNomeFilme;
    private javax.swing.JTextField jTextNumFilme;
    // End of variables declaration//GEN-END:variables
}
