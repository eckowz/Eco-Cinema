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

    private List<Filme> listaFilmes;

    public RepositorioFilmes() {
        listaFilmes = new ArrayList<Filme>();
    }

    public boolean addFilmes(Filme filme) {
        return (listaFilmes.add(filme));
    }

    public List<Filme> getListaFilmes() {
        return listaFilmes;
    }

    public boolean filmeExiste(int codigoFilme) {
        for (Filme filme : listaFilmes) {
            if (filme.getCodigoFilme()==(codigoFilme)) {
                return true;
            }
        }
        return false;
    }

    public Filme buscarFilme(int codigoFilme) {
        for (Filme filme : listaFilmes) {
            if (filme.getCodigoFilme()==(codigoFilme)) {
                return filme;
           }
        }
        return null;
    }
} 
