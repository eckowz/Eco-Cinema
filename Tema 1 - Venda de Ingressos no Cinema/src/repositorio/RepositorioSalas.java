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

public class RepositorioSalas {

    private List<Sala> listaSalas;

    public RepositorioSalas() {
        listaSalas = new ArrayList<Sala>();
    }

    public boolean addSalas(Sala sala) {
        return (listaSalas.add(sala));
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
        for (Sala sala : listaSalas) {
            if (sala.getIdSala() == (cod)) {
                return i;
            }
            i++;
        }
        return 0;
    }

    public List<Sala> getListaSalas() {
        return listaSalas;
    }

    public boolean salaExiste(int codigoSala) {
        for (Sala sala : listaSalas) {
            if (sala.getIdSala() == (codigoSala)) {
                return true;
            }
        }
        return false;
    }

    public Sala buscarSala(int codigoSala) {
        for (Sala sala : listaSalas) {
            if (sala.getIdSala() == (codigoSala)) {
                return sala;
            }
        }
        return null;
    }
}
