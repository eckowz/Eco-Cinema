/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eco.cinema;

import controller.FilmeController;
import view.JanelaCrudFilme;
import controller.SalaController;
import view.JanelaCrudSala;
import controller.SessaoController;
import view.JanelaCrudSessao;

/**
 *
 * @author gserafini
 */ 
public class EcoCinema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FilmeController FilmeController = new FilmeController();
        JanelaCrudFilme FilmeJanela = new JanelaCrudFilme(FilmeController);
        FilmeController.setJanela(FilmeJanela);
        
        SalaController SalaController = new SalaController();
        JanelaCrudSala SalaJanela = new JanelaCrudSala(SalaController);
        SalaController.setJanela(SalaJanela);
        
//        SessaoController SessaoController = new SessaoController();
//        JanelaCrudSessao SessaoJanela = new JanelaCrudSessao(SessaoController);
//        SessaoController.setJanela(SessaoJanela);
        
        
        
    }
    
}
