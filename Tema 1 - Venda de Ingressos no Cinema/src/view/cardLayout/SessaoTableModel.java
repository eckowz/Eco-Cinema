/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.cardLayout;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Sessao;

/**
 *
 * @author Eckowz
 */
public class SessaoTableModel extends AbstractTableModel {

    private String header[];
    private List<Sessao> sessoes;

    public SessaoTableModel() {
        this.header = new String[]{"Horário", "Filme", "Sala", "Assentos Disponiveis"};
        this.sessoes = new ArrayList<Sessao>();
    }

    public SessaoTableModel(String[] header, List<Sessao> f) {
        this.header = header;
        this.sessoes = sessoes;

    }

    @Override
    public int getRowCount() {
        return (this.sessoes.size());
    }

    @Override
    public int getColumnCount() {
        return (4);
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return (this.sessoes.get(rowIndex).getHorario());
        } else if (columnIndex == 1) {
            return (this.sessoes.get(rowIndex).getFilme());
        } else if (columnIndex == 2) {
            return (this.sessoes.get(rowIndex).getSala());
        } else if (columnIndex == 3) {
            return (this.sessoes.get(rowIndex).getAssentosDisponiveis());
        } else {
            return null;
        }
    }

    public void setSessoes(List<Sessao> sessoes) {
        this.sessoes = sessoes;
    }

    public Sessao getSessao(int linha) {
        return (sessoes.get(linha));
    }
}
