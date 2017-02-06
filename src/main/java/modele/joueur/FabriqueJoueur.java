package modele.joueur;

import modele.utilitaires.Peuple;

/**
 * Created by o2156238 on 06/02/17.
 */
public class FabriqueJoueur {

    private static FabriqueJoueur instance;

    private FabriqueJoueur(){

    }

    public static FabriqueJoueur getInstance(){
        if(instance==null){
            instance = new FabriqueJoueur();
        }
        return instance;
    }

    public Joueur creerJoueur(String nom, Peuple p, int basex, int basey{
        return new Joueur( nom,  p,  basex, basey);
    }

}
