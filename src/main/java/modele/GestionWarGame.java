package modele;

import modele.exceptions.ExceptionJoueurDejaExistant;
import modele.exceptions.ExceptionJoueurInnexistant;
import modele.exceptions.ExceptionPeupleInexistant;

import java.util.*;

/**
 * Created by o2156238 on 23/01/17.
 */
public class GestionWarGame implements IGestionWarGame {

    private Joueur[] joueurs = new Joueur[2];
    Collection<Unite> armee;
    //Peuple p;
    static int id =0;

    //Constructeur par défaut
    public GestionWarGame(){
        armee = new ArrayList<Unite>();
    }

    @Override
    public void creerJoueur(String nom) throws ExceptionJoueurDejaExistant {
        for (int i = 0; i< joueurs.length; i++){
            if(nom.equals(joueurs[i].getNom())){
                throw new ExceptionJoueurDejaExistant();
            }
            else {
                Joueur j = new Joueur(nom);
                joueurs[i] = j;
            }
        }

    }

    @Override
    public void choisirRace(String nom, Peuple peuple) throws ExceptionPeupleInexistant, ExceptionJoueurInnexistant {
        for (Joueur j : joueurs){
            if(!nom.equals(j.getNom())){
                throw new ExceptionJoueurInnexistant();
            }
            else {
                j.setP(peuple);
            }
        }

    }

    @Override
    public Unite creerUnite(Peuple p) {
        Unite u;
        switch(p){
            case MARTIEN:
                id++;
                u=new Unite("Soldat"+id, 20, 5, 10, 15, 25,basex,basey);
                armee.add(u);
                
                return u;
            case TERRIEN:
            default:
                id++;
                u=new Unite("Soldat"+id, 15, 8, 7, 10, 30,basex,basey);
                armee.add(u);

                return u;
        }
    }

    @Override
    public void changerNatureUnite(String nom, Genre g) {

    }
}
