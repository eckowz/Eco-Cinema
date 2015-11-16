
package servico;

/**
 *
 * @author gserafini
 */
public class SessaoServico {

    public void adicionarSessao(Sessao sessao){
        new SessaoDaoBd().inserir(consulta);
    }
    
    public List<Consulta> listarSessoes() {
        return (new SessaoDaoBd().listar());
    }
}
