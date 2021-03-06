package dao;

import java.util.List;
import model.Filme;

/**
 *
 * @author gserafini
 */
public interface FilmeDao {

    public void inserir(Filme filme);

    public void deletar(Filme filme);

    public void atualizar(Filme filme);

    public Filme procurarPorIdFilme(int idFilme);

    public List<Filme> buscarPorNome(String nome);

    public List<Filme> listar();

}
