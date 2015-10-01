/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author lhries
 */
public class Filme {

    private int codigoFilme;
    private String nomeFilme, generoFilme, sinopseFilme;

    public Filme(int codigoFilme, String nomeFilme, String generoFilme, String sinopseFilme) {
        this.codigoFilme = codigoFilme;
        this.nomeFilme = nomeFilme;
        this.generoFilme = generoFilme;
        this.sinopseFilme = sinopseFilme;
    }

    public int getCodigoFilme() {
        return codigoFilme;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public String getGeneroFilme() {
        return generoFilme;
    }

    public String getSinopseFilme() {
        return sinopseFilme;
    }

    public void setGeneroFilme(String generoFilme) {
        this.generoFilme = generoFilme;
    }

    public void setSinopseFilme(String sinopseFilme) {
        this.sinopseFilme = sinopseFilme;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Filme other = (Filme) obj;
        if (!Objects.equals(this.codigoFilme, other.codigoFilme)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.codigoFilme);
        return hash;
    }

    @Override
    public String toString() {
        return codigoFilme + " - " + nomeFilme + ", " + generoFilme;
    }

}
