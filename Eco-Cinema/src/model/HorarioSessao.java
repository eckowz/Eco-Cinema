package model;

import java.util.Date;

public class HorarioSessao implements Comparable<HorarioSessao> {
    private Date horario;
    private Filme filme;
    private Sala sala;
    
    public HorarioSessao(Date horario, Filme filme, Sala sala)
    {
        this.horario = horario;
        this.filme = filme;
        this.sala = sala;
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
    public int compareTo(HorarioSessao o) {
        return(this.getHorario().compareTo(o.getHorario()));
    }
    
    
}
