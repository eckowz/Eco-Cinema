package servico;

import dao.SessaoDaoBd;
import java.util.List;
import model.Sessao;

/**
 *
 * @author gserafini
 */
public class SessaoServico {

    public void adicionarSessao(Sessao sessao) {
        new SessaoDaoBd().inserir(sessao);
    }

    public List<Sessao> listarSessoes() {
        return (new SessaoDaoBd().listar());
    }

    public int assentosDisponiveis(int idSessao) {
        return (new SessaoDaoBd().assentosDisponiveis(idSessao));
    }

    public void ocupaAssento(Sessao sessao, int qtd) {
        new SessaoDaoBd().ocuparAssento(sessao, qtd);
    }

    public Boolean sessaoExiste(int idSessao) {
        return (new SessaoDaoBd().sessaoExiste(idSessao));

    }

    public Sessao procurarPorIdSessao(int idSessao) {
        return (new SessaoDaoBd().procurarPorIdSessao(idSessao));
    }

    public void removerSessao(Sessao sessao) {
        new SessaoDaoBd().deletar(sessao);
    }
}
