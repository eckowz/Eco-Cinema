/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Sala;

/**
 *
 * @author Eckowz
 */
public class SalaTableModel extends AbstractTableModel {

    private String header[];
    private List<Sala> salas;

    public SalaTableModel() {
        this.header = new String[]{"Código", "Quantidade de Assentos"};
        this.salas = new ArrayList<Sala>();
    }

    public SalaTableModel(String[] header, List<Sala> s) {
        this.header = header;
        this.salas = salas;

    }

    @Override
    public int getRowCount() {
        return (this.salas.size());
    }

    @Override
    public int getColumnCount() {
        return (2);
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return (this.salas.get(rowIndex).getCodSala());
        } else if (columnIndex == 1) {
            return (this.salas.get(rowIndex).getQuantidadeAssentos());
        } else {
            return null;
        }
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    public Sala getSala(int linha) {
        return (salas.get(linha));
    }
}
