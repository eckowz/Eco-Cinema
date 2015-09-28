/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Sala;

/**
 *
 * @author lhries
 */
public class RepositorioSalas {

    private List<Sala> salas;

    public RepositorioSalas() {
        salas = new ArrayList<Sala>();
    }

    public boolean addSalas(Sala sala) {
        return (salas.add(sala));
    }

    public List<Sala> getListaSalas() {
        return salas;
    }

    public boolean salaExiste(int codigoSala) {
        for (Sala sala : salas) {
            if (sala.getCodigoSala()==(codigoSala)) {
                return true;
            }
        }
        return false;
    }

    public Sala buscarSala(int codigoSala) {
        for (Sala sala : salas) {
            if (sala.getCodigoSala()==(codigoSala)) {
                return sala;
           }
        }
        return null;
    }
} 
