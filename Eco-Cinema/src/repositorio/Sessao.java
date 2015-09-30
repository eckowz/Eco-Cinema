package repositorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import model.HorarioSessao;

public class Sessao {

    private List<HorarioSessao> listaHorarios;

    public Sessao() {
        listaHorarios = new ArrayList<HorarioSessao>();
    }

    public boolean addHorario(HorarioSessao horario) {
        if (consultaExiste(horario.getHorario())) {
            return false;
        }
        return (listaHorarios.add(horario));
    }

    public List<HorarioSessao> getListaHorarios() {
        Collections.sort(listaHorarios);
        return listaHorarios;
    }

    public boolean consultaExiste(Date horario) {
        for (HorarioSessao hor : listaHorarios) {
            if (hor.getHorario().equals(horario)) {
                return true;
            }
        }
        return false;
    }

    public HorarioSessao buscarHorarioSessao(Date horario) {
        for (HorarioSessao hora : listaHorarios) {
            if (hora.getHorario().equals(horario)) {
                return hora;
            }
        }
        return null;
    }

}
