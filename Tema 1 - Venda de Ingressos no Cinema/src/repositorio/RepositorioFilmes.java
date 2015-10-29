/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Filme;
import util.Console;

public class RepositorioFilmes {

    private List<Filme> listaFilmes;

    public RepositorioFilmes() {
        listaFilmes = new ArrayList<Filme>();
    }

    public boolean addFilmes(Filme filme) {
        return (listaFilmes.add(filme));
    }

    public void removerFilme() {
        try {
            int codigoFilme = Console.scanInt("\nInforme o código do filme: ");
            if (filmeExiste(codigoFilme)) {
                getListaFilmes().remove(buscaIndiceFilme(codigoFilme));
                System.out.println("Filme removido.");
            } else {
                System.out.println("Filme não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro.");
        }

    }

    public int buscaIndiceFilme(int cod) {
        int i = 0;
        for (Filme filme : listaFilmes) {
            if (filme.getCodigoFilme() == (cod)) {
                return i;
            }
            i++;
        }
        return 0;
    }

    public List<Filme> getListaFilmes() {
        return listaFilmes;
    }

    public boolean filmeExiste(int codigoFilme) {
        for (Filme filme : listaFilmes) {
            if (filme.getCodigoFilme() == (codigoFilme)) {
                return true;
            }
        }
        return false;
    }

    public Filme buscarFilme(int codigoFilme) {
        for (Filme filme : listaFilmes) {
            if (filme.getCodigoFilme() == (codigoFilme)) {
                return filme;
            }
        }
        return null;
    }
}
