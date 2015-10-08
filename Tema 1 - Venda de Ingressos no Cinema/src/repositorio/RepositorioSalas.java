/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Sala;
import util.Console;

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

    public void removerSala() {
        try {
            int codigoSala = Console.scanInt("\nInforme o código da sala: ");
            if (salaExiste(codigoSala)) {
                getListaSalas().remove(buscaIndiceSala(codigoSala));
                System.out.println("Sala removida.");
            }else{
                System.out.println("Sala não encontrada.");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro.");
        }

    }

    public int buscaIndiceSala(int cod) {
        int i = 0;
        for (Sala sala : salas) {
            if (sala.getCodigoSala() == (cod)) {
                return i;
            }
            i++;
        }
        return 0;
    }

    public List<Sala> getListaSalas() {
        return salas;
    }

    public boolean salaExiste(int codigoSala) {
        for (Sala sala : salas) {
            if (sala.getCodigoSala() == (codigoSala)) {
                return true;
            }
        }
        return false;
    }

    public Sala buscarSala(int codigoSala) {
        for (Sala sala : salas) {
            if (sala.getCodigoSala() == (codigoSala)) {
                return sala;
            }
        }
        return null;
    }
}
