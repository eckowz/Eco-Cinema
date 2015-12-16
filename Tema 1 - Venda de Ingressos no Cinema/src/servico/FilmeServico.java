package servico;

import dao.FilmeDao;
import dao.FilmeDaoBd;
import java.util.List;
import model.Filme;

/**
 *
 * @author gserafini
 */
public class FilmeServico {

    public boolean filmeExisteId(int idFilme) {
        FilmeDao dao = new FilmeDaoBd();
        Filme filme = dao.procurarPorIdFilme(idFilme);
        return (filme != null);
    }

    public Filme procurarPorIdFilme(int idFilme) {
        FilmeDao dao = new FilmeDaoBd();
        Filme filme = dao.procurarPorIdFilme(idFilme);
        return (filme);
    }

    public void addFilme(Filme filme) {
        new FilmeDaoBd().inserir(filme);
    }

    public List<Filme> listarFilmes() {
        return (new FilmeDaoBd().listar());
    }

    public void removerFilme(Filme filme) {
        new FilmeDaoBd().deletar(filme);
    }

    public void atualizarFilme(Filme filme) {
        new FilmeDaoBd().atualizar(filme);
    }
}
