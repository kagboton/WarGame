package modele.comportements.attaque;

/**
 * Created by o2156238 on 30/01/17.
 */
public class AttaquePoison implements StrategieAttaque {
    @Override
    public void attaquer() {
        System.out.println("StrategieAttaque poison !");
    }
}
