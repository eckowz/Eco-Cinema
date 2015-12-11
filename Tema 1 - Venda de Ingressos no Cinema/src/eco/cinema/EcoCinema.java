/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eco.cinema;

import controller.cardLayout.FilmeController;
import view.cardLayout.JanelaCrudFilme;
import controller.cardLayout.SalaController;
import view.cardLayout.JanelaCrudSala;
import controller.cardLayout.SessaoController;
import view.cardLayout.JanelaCrudSessao;
import view.MainView;

/**
 *
 * @author gserafini
 */ 
public class EcoCinema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        FilmeController FilmeController = new FilmeController();
//        JanelaCrudFilme FilmeJanela = new JanelaCrudFilme(FilmeController);
//        FilmeController.setJanela(FilmeJanela);
//        
//        SalaController SalaController = new SalaController();
//        JanelaCrudSala SalaJanela = new JanelaCrudSala(SalaController);
//        SalaController.setJanela(SalaJanela);
//        
//        SessaoController SessaoController = new SessaoController();
//        JanelaCrudSessao SessaoJanela = new JanelaCrudSessao(SessaoController);
//        SessaoController.setJanela(SessaoJanela);
        new MainView().exec();

        
    }
    
}
