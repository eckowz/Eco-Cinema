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

    public List<Filme> listar();

    public Filme procurarPorIdFilme(int idFilme);
        //public Filme procurarPorCodFilme(int codFilme);
    //public Filme procurarPorGeneroFilme(String genFilme);
}
