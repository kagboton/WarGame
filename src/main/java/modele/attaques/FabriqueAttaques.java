package modele.attaques;

import modele.utilitaires.TypeAttaque;

/**
 * Created by o2156238 on 06/02/17.
 */
public class FabriqueAttaques {

    private static FabriqueAttaques instance;

    private FabriqueAttaques(){}

    public static FabriqueAttaques getInstance(){
        if(instance==null){
            instance = new FabriqueAttaques();
        }
        return instance;
    }

    public IAttaque creerAttaqueDegat(int degat, int x, int y, int rayon){
        return new AttaqueClassique(degat, x, y, rayon);

    }

    public IAttaque creerAttaqueAvecEffetSecondaire(int x, int y, int rayon){
        return new AttaqueEmpoisonnee(x, y, rayon);
    }

    public IAttaque creerAttaqueNeutre(){
        return new AttaqueNeutre();

    }

}
