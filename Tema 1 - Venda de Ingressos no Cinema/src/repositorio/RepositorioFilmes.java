/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Filme;

/**
 *
 * @author lhries
 */
public class RepositorioFilmes {

    private List<Filme> filmes;

    public RepositorioFilmes() {
        filmes = new ArrayList<Filme>();
    }

    public boolean addFilmes(Filme filme) {
        return (filmes.add(filme));
    }

    public List<Filme> getListaFilmes() {
        return filmes;
    }

    public boolean filmeExiste(int codigoFilme) {
        for (Filme filme : filmes) {
            if (filme.getCodigoFilme()==(codigoFilme)) {
                return true;
            }
        }
        return false;
    }

    public Filme buscarFilme(int codigoFilme) {
        for (Filme filme : filmes) {
            if (filme.getCodigoFilme()==(codigoFilme)) {
                return filme;
           }
        }
        return null;
    }
} 
