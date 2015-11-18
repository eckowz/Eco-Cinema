package dao;

import java.util.Date;
import java.util.List;
import model.Sessao;

/**
 *
 * @author gserafini
 */
public interface SessaoDao {

    public void inserir(Sessao sessao);

    public void deletar(Sessao sessao);

    public void atualizar(Sessao sessao);

    public List<Sessao> listar();

    public Sessao procurarPorIdSessao(int idSessao);

    public List<Sessao> procurarPorHorario(Date horario);

    public int assentosDisponiveis(int idSessao);
}
