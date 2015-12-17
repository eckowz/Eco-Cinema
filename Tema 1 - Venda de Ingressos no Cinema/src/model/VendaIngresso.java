package model;

import java.util.Date;

public class VendaIngresso implements Comparable<VendaIngresso> {

    private int idVenda;
    private Date horarioVenda;
    private Sessao sessao;

    public VendaIngresso(int idVenda, Date horarioVenda, Sessao sessao) {
        this.idVenda = idVenda;
        this.horarioVenda = horarioVenda;
        this.sessao = sessao;
    }

    public VendaIngresso(Date horarioVenda, Sessao sessao) {
        this.horarioVenda = horarioVenda;
        this.sessao = sessao;
    }

    public VendaIngresso() {
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Date getHorarioVenda() {
        return horarioVenda;
    }

    public void setHorarioVenda(Date horarioVenda) {
        this.horarioVenda = horarioVenda;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    /**
     * public void setAssentosDisponiveis(HorarioSessao o){
     * this.assentosDisponiveis = o; }
     */
    @Override
    public int compareTo(VendaIngresso o) {
        return (this.getHorarioVenda().compareTo(o.getHorarioVenda()));
    }

}
