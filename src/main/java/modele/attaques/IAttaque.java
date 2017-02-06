package modele.attaques;

import modele.unite.Unite;

/**
 * Created by o2156238 on 06/02/17.
 */
public abstract class IAttaque {

    private int impactX;
    private int impactY;
    private int rayon;
    private int degat;

    public IAttaque(int x, int y, int rayon){
        impactX =x;
        impactY =y;
        this.rayon =rayon;

    }

    public int getImpactX() {
        return impactX;
    }

    public int getImpactY() {
        return impactY;
    }

    public int getRayon() {
        return rayon;
    }

    public int getDegat() {
        return degat;
    }

    public Unite appliquerEffetSecondaire(Unite u) {
        return u;
    }

}
