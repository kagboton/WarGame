package modele.comportements.attaque;


import modele.unite.Unite;

/**
 * Created by o2156238 on 30/01/17.
 */
public class AttaqueGrenade implements StrategieAttaque {

    int attmodifie, porteemodifie;
    int rayon=0;
    boolean poison;

    @Override
    public void attaquer(Unite u, int x, int y) {
        attmodifie = u.getAtt()+5;
        porteemodifie=u.getPortee()-3;
        poison=false;
        rayon=50;
    }
}
