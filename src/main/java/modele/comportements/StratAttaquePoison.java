package modele.comportements;

import modele.attaques.FabriqueAttaques;
import modele.attaques.IAttaque;
import modele.unite.Unite;

/**
 * Created by o2156238 on 30/01/17.
 */
public class StratAttaquePoison implements IStratAttaque {


    @Override
    public IAttaque attaque(Unite u, int x, int y) {
        int attModifie = u.getAtt() - 5;
        int porteeModifie =u.getPortee() - 3;
        int rayon = 20;

        if(this.attaquePossible(u, porteeModifie, x, y)){
            u.setAction("L'unite" +u.getNom()+"attaque et tente de");
            return FabriqueAttaques.getInstance().creerAttaqueAvecEffetSecondaire(x, y, rayon);
        }
        u.setAction("L'unite" +u.getNom()+ "ne peu pas attaquer .....");
        return FabriqueAttaques.getInstance().creerAttaqueNeutre();
    }
}
