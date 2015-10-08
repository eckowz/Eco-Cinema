package repositorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import model.Sessao;
import util.Console;

public class RepositorioSessao {

    private List<Sessao> listaSessoes;

    public RepositorioSessao() {
        listaSessoes = new ArrayList<Sessao>();
    }

    public boolean addHorario(Sessao horario) {
        if (sessaoExiste(horario.getHorario())) {
            return false;
        }
        return (listaSessoes.add(horario));
    }

    public List<Sessao> getListaSessoes() {
        return listaSessoes;
    }

    public void removerSessao() {
        try {
            int codigoSessao = Console.scanInt("\nInforme o código da sessão: ")-1;
            getListaSessoes().remove(codigoSessao);
            System.out.println("Sessão removida.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro. Informe apenas o código da sessão");
        }

    }

    public boolean sessaoExiste(Date horario) {
        for (Sessao hora : listaSessoes) {
            if (hora.getHorario().equals(horario)) {
                return true;
            }
        }
        return false;
    }

    public boolean sessaoExistePorCodigo(int cod) {
        for (Sessao hora : listaSessoes) {
            if (hora.getCodSessao() == cod) {
                return true;
            }
        }
        return false;
    }

    public Sessao buscarHorarioSessao(Date horario) {
        for (Sessao hora : listaSessoes) {
            if (hora.getHorario().equals(horario)) {
                return hora;
            }
        }
        return null;
    }

    public boolean temAssento(int cod) {
        if (sessaoExistePorCodigo(cod)) {
            for (Sessao hora : listaSessoes) {
                if (hora.getCodSessao() == cod && hora.getSala().getQuantidadeAssentos() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public void ocupaAssento(int cod) {
        if (sessaoExistePorCodigo(cod)) {
            for (Sessao horarioSessao : listaSessoes) {
                if (horarioSessao.getCodSessao() == cod && temAssento(cod)) {
                    int a = horarioSessao.getSala().getQuantidadeAssentos() - 1;
                    horarioSessao.getSala().setQuantidadeAssentos(a);
                }
            }
        }
    }

    public int listarAssentosDisponiveisPorSessao(int cod) {
        for (Sessao horarioSessao : listaSessoes) {
            if (horarioSessao.getCodSessao() == cod) {
                return horarioSessao.getSala().getQuantidadeAssentos();
            }
        }
        return 0;
    }

}
