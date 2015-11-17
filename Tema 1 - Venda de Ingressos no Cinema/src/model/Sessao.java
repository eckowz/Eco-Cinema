package model;

import java.util.Date;

public class Sessao implements Comparable<Sessao> {

    private int codSessao;
    private Date horario;
    private Filme filme;
    private Sala sala;
    private int assentosDisponiveis;

    public Sessao(int codSessao, Date horario, Filme filme, Sala sala, int assentosDisponiveis) {
        this.codSessao = codSessao;
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

    public void setCodSessao(int codSessao) {
        this.codSessao = codSessao;
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

    public int getCodSessao() {
        return codSessao;
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
