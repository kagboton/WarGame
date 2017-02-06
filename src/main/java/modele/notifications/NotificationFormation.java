package modele.notifications;

import modele.unite.Unite;

/**
 * Created by o2156238 on 06/02/17.
 */
public class NotificationFormation implements INotification {

    Unite uniteFormee;

    public NotificationFormation(Unite uniteFormee){
        this.uniteFormee = uniteFormee;
    }


    @Override
    public String getTexteNotification() {
        return uniteFormee.getNom() + "(" +uniteFormee.getComportementAttaque()+ ")" + "a été formée";
    }
}
