package model;

import java.util.Date;
import java.util.Objects;


public class Sessao implements Comparable<Sessao> {

    private int idSessao;
    private Date horario;
    private Filme filme;
    private Sala sala;
    private int assentosDisponiveis;

    public Sessao(int idSessao, Date horario, Filme filme, Sala sala, int assentosDisponiveis) {
        this.idSessao = idSessao;
        this.horario = horario;
        this.filme = filme;
        this.sala = sala;
        this.assentosDisponiveis = assentosDisponiveis;
    }

    public Sessao(Date horario, Filme filme, Sala sala, int assentosDisponiveis) {
        this.idSessao = -1;
        this.horario = horario;
        this.filme = filme;
        this.sala = sala;
        this.assentosDisponiveis = assentosDisponiveis;
    }

    public Sessao() {
    }

    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public int getAssentosDisponiveis() {
        return assentosDisponiveis;
    }

    public void setAssentosDisponiveis(int assentosDisponiveis) {
        this.assentosDisponiveis = assentosDisponiveis;
    }

    public int getIdSessao() {
        return idSessao;
    }

    public Date getHorario() {
        return horario;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public int compareTo(Sessao o) {
        return (this.getHorario().compareTo(o.getHorario()));
    }

    @Override
    public String toString() {
        return "Sessao{" + "horario=" + horario + ", filme=" + filme + ", sala=" + sala + ", assentosDisponiveis=" + assentosDisponiveis + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.horario);
        hash = 53 * hash + Objects.hashCode(this.filme);
        hash = 53 * hash + Objects.hashCode(this.sala);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sessao other = (Sessao) obj;
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        if (!Objects.equals(this.filme, other.filme)) {
            return false;
        }
        if (!Objects.equals(this.sala, other.sala)) {
            return false;
        }
        return true;
    }

}
