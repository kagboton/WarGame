package modele.comportements;

import modele.attaques.IAttaque;
import modele.unite.Unite;

/**
 * Created by o2156238 on 30/01/17.
 */
public interface IStratAttaque {

    public IAttaque attaque(Unite u, int x, int y);
}
