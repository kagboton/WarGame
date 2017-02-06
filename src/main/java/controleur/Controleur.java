package controleur;

import modele.facade.GestionWarGame;
import modele.facade.IGestionWarGame;
import modele.exceptions.ExceptionJoueurDejaExistant;

/**
 * Created by o2156238 on 23/01/17.
 */
public class Controleur {

    private IGestionWarGame maFacade;

    //Constructeur
    public Controleur(){

        if(maFacade==null){
            maFacade = new GestionWarGame();
        }
    }

    public void creerJoueur(String nom) throws ExceptionJoueurDejaExistant {
        try {
            this.maFacade.creerJoueur(nom);
        } catch (ExceptionJoueurDejaExistant exceptionJoueurDejaExistant) {
            exceptionJoueurDejaExistant.printStackTrace();
        }
    }
}
