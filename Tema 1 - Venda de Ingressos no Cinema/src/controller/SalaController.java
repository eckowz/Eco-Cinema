
package controller;

import dao.SalaDao;
import dao.SalaDaoBd;
import model.Sala;
import view.PrintUtil;
public class SalaController {

   public void salvarSala(int codSala, int qtdAssentos) {
            Sala sala = new Sala(codSala, qtdAssentos);
            SalaDao dao = new SalaDaoBd();
            dao.inserir(sala);
            PrintUtil.printMessageSucesso(null, "Cadastro realizado com sucesso!");

    }    

}
