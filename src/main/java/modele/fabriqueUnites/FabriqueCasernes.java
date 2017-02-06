package modele.fabriqueUnites;

import modele.utilitaires.Peuple;

/**
 * Created by o2156238 on 06/02/17.
 */
public class FabriqueCasernes {

    private static FabriqueCasernes instance;

    private FabriqueCasernes(){

    }
    public static FabriqueCasernes getInstance(){
        if (instance==null){
            instance = new FabriqueCasernes();
        }
        return instance;
    }

    public ICaserne creerCaserne(Peuple p, int x, int y){
        switch (p){
            case TERRIEN: new CaserneTerre(x, y);
            case MARTIEN: new CaserneMars(x, y);

        }
        throw new RuntimeException("Tu le sors d'où ton peuple ?");
    }
}
