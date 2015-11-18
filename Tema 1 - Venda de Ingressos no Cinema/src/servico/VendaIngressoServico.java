/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import dao.VendaIngressoDaoBd;
import java.util.List;
import model.VendaIngresso;

/**
 *
 * @author 631120345
 */
public class VendaIngressoServico {
    public void adicionarVendaIngresso(VendaIngresso vendaIngresso){
        new VendaIngressoDaoBd().inserir(vendaIngresso);
    }
    
    public List<VendaIngresso> listarVendaIngresso(){
        return (new VendaIngressoDaoBd().listar());
    }
}
