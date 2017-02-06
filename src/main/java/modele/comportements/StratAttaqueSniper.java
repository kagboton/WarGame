package modele.comportements;

import modele.attaques.IAttaque;
import modele.unite.Unite;

/**
 * Created by o2156238 on 30/01/17.
 */
public class StratAttaqueSniper implements IStratAttaque {

    @Override
    public IAttaque attaque(Unite u, int x, int y) {
        int attModifie = u.getAtt();
        int porteeModifie =u.getPortee();
        int rayon = 0
    }
}
