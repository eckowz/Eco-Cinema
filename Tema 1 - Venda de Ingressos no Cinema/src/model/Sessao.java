package model;

import java.util.Date;

public class Sessao implements Comparable<Sessao> {

    private static int CODIGO_GERADO = 1;
    private int codSessao;
    private Date horario;
    private Filme filme;
    private Sala sala;
    private int assentosDisponiveis;

    public Sessao(Date horario, Filme filme, Sala sala) {
        this.codSessao = CODIGO_GERADO;
        CODIGO_GERADO++;
        this.horario = horario;
        this.filme = filme;
        this.sala = sala;
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
