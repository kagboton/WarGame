package modele.comportements;

import modele.attaques.IAttaque;
import modele.unite.Unite;
/**
 * Created by o2156238 on 30/01/17.
 */
public class StratAttaqueGrenade implements IStratAttaque {

    int attmodifie, porteemodifie;
    int rayon=0;



    @Override
    public IAttaque attaque(Unite u, int x, int y) {
        attmodifie = u.getAtt()+5;
        porteemodifie=u.getPortee()-3;
        poison=false;
        rayon=50;
    }
}
