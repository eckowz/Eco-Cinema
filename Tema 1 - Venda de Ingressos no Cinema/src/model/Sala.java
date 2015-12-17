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
public class Sala {

    private int idSala, codSala, quantidadeAssentos;

    public Sala(int codigoSala, int quantidadeAssentos) {
        this.idSala = -1;
        this.codSala = codigoSala;
        this.quantidadeAssentos = quantidadeAssentos;
    }

    public Sala(int idSala, int codSala, int quantidadeAssentos) {
        this.idSala = idSala;
        this.codSala = codSala;
        this.quantidadeAssentos = quantidadeAssentos;
    }

    public Sala() {
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getCodSala() {
        return codSala;
    }

    public void setCodSala(int codSala) {
        this.codSala = codSala;
    }

    public int getQuantidadeAssentos() {
        return quantidadeAssentos;
    }

    public void setQuantidadeAssentos(int quantidadeAssentos) {
        this.quantidadeAssentos = quantidadeAssentos;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sala other = (Sala) obj;
        if (!Objects.equals(this.codSala, other.codSala)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.codSala);
        return hash;
    }

    @Override
    public String toString() {
        return "" + codSala;
    }

    

}
