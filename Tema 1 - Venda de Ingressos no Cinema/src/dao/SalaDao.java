/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Sala;

/**
 *
 * @author 631120345
 */
public interface SalaDao {

    public void inserir(Sala sala);

    public void deletar(Sala sala);

    public void atualizar(Sala sala);

    public List<Sala> listar();

    public Sala procurarPorId(int idSala);

    public Sala procurarPorCodSala(int codSala);

    public Sala procurarPorQuantidadeAssentos(int qtdAssentos);
}
