package servico;

import dao.SalaDao;
import dao.SalaDaoBd;
import java.util.List;
import model.Sala;

/**
 *
 * @author gserafini
 */
public class SalaServico {

    public boolean salaExisteId(int idSala) {
        SalaDao dao = new SalaDaoBd();
        Sala sala = dao.procurarPorId(idSala);
        return (sala != null);
    }

    public boolean salaExisteCodSala(int codSala) {
        SalaDao dao = new SalaDaoBd();
        Sala sala = dao.procurarPorCodSala(codSala);
        return (sala != null);
    }

    public Sala procurarPorCodSala(int codSala) {
        SalaDao dao = new SalaDaoBd();
        Sala sala = dao.procurarPorCodSala(codSala);
        return (sala);
    }

    public void addSala(Sala sala) {
        new SalaDaoBd().inserir(sala);
    }

    public List<Sala> listarSalas() {
        return (new SalaDaoBd().listar());
    }

    public void removerSala(Sala sala) {
        new SalaDaoBd().deletar(sala);
    }
    
    public void atualizarSala(Sala sala) {
        new SalaDaoBd().atualizar(sala);
    }
}
