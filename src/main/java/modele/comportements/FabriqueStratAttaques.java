package modele.comportements;

import modele.utilitaires.Genre;

/**
 * Created by o2156238 on 30/01/17.
 */
public class FabriqueStratAttaques {

    private static FabriqueStratAttaques maFabrique = null;

    private FabriqueStratAttaques(){}

    public static FabriqueStratAttaques getInstance(){
        if(maFabrique==null){
            maFabrique = new FabriqueStratAttaques();
        }
        return maFabrique;
    }

    public IStratAttaque getStratAttaque(Genre strat){
        switch (strat){
            case POISON: return new StratAttaquePoison();
            case STANDARD: return new StratAttaqueStandard();
            case SNIPER: return new StratAttaqueSniper();
            case GRENADE: return new StratAttaqueGrenade();
        }
        throw new RuntimeException("Strartegie inexistante");
    }
}
