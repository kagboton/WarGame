package modele.facade;

import modele.unite.Unite;
import modele.exceptions.ExceptionJoueurDejaExistant;
import modele.exceptions.ExceptionJoueurInnexistant;
import modele.exceptions.ExceptionPeupleInexistant;
import modele.utilitaires.Genre;
import modele.utilitaires.Peuple;

import java.util.*;

/**
 * Created by o2156238 on 23/01/17.
 */
public class GestionWarGame implements IGestionWarGame {

    private Joueur[] joueurs = new Joueur[2];
    Collection<Unite> armee;
    Position position;
    int basex, basey;
    //Peuple peuple;
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
    public Unite creerUnite(String nom, Peuple p) throws ExceptionJoueurInnexistant {
        Unite u = null;
        for (Joueur j : joueurs) {
            if (!nom.equals(j.getNom())) {
                throw new ExceptionJoueurInnexistant();
            } else {
                switch (p) {
                    case MARTIEN:
                        u = nouvelleUnite("Soldat", 20, 5, 10, 15, 25, position);
                        armee.add(u);
                    case TERRIEN:
                    default:
                        u = nouvelleUnite("Soldat", 15, 8, 7, 10, 30,position);
                        armee.add(u);
                }
            }
        }
        return u;
    }

    private Unite nouvelleUnite(String nomUnite, int att, int def, int mvt, int portee, int vie, Position p){
        id++;
        return new Unite(nomUnite+id, att, def, mvt, portee, vie, p.x, p.y);

    }

    @Override
    public void changerNatureUnite(String nom, Genre g) {

    }

    @Override
    public void afficherUnite(String nom, Unite u) {

    }


}
