package model;

import java.util.Date;

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
        this.horario = horario;
        this.filme = filme;
        this.sala = sala;
        this.assentosDisponiveis = assentosDisponiveis;
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

    /**
     * public void setAssentosDisponiveis(HorarioSessao o){
     * this.assentosDisponiveis = o; }
     */
    @Override
    public int compareTo(Sessao o) {
        return (this.getHorario().compareTo(o.getHorario()));
    }

}
