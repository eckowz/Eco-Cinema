/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.VendaIngresso;

/**
 *
 * @author 631120345
 */
public interface VendaIngressoDao {
    public void inserir(VendaIngresso vendaIngresso);
    public void deletar(VendaIngresso vendaIngresso);
    public void atualizar(VendaIngresso vendaIngresso);
    public List<VendaIngresso> listar();
}
