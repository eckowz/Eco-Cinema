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

    private int idFilme;
    private String nomeFilme, generoFilme, sinopseFilme;

    public Filme(int idFilme, String nomeFilme, String generoFilme, String sinopseFilme) {
        this.idFilme = idFilme;
        this.nomeFilme = nomeFilme;
        this.generoFilme = generoFilme;
        this.sinopseFilme = sinopseFilme;
    }

    public Filme(String nomeFilme, String generoFilme, String sinopseFilme) {
        this.nomeFilme = nomeFilme;
        this.generoFilme = generoFilme;
        this.sinopseFilme = sinopseFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public int getIdFilme() {
        return idFilme;
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
        if (!Objects.equals(this.idFilme, other.idFilme)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.idFilme);
        return hash;
    }

    @Override
    public String toString() {
        return idFilme + " - " + nomeFilme + ", " + generoFilme;
    }

}
