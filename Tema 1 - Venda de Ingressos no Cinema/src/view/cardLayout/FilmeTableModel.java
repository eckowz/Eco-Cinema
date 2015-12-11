/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.cardLayout;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Filme;

/**
 *
 * @author Eckowz
 */
public class FilmeTableModel extends AbstractTableModel {

    private String header[];
    private List<Filme> filmes;

    public FilmeTableModel() {
        this.header = new String[]{"Título", "Gênero", "Sinopse"};
        this.filmes = new ArrayList<Filme>();
    }

    public FilmeTableModel(String[] header, List<Filme> f) {
        this.header = header;
        this.filmes = filmes;

    }

    @Override
    public int getRowCount() {
        return (this.filmes.size());
    }

    @Override
    public int getColumnCount() {
        return (3);
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return (this.filmes.get(rowIndex).getNomeFilme());
        } else if (columnIndex == 1) {
            return (this.filmes.get(rowIndex).getGeneroFilme());
        } else if (columnIndex == 2) {
            return (this.filmes.get(rowIndex).getSinopseFilme());
        } else {
            return null;
        }
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public Filme getFilme(int linha) {
        return (filmes.get(linha));
    }
}
