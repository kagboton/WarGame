package modele.comportements.deplacement;

/**
 * Created by o2156238 on 30/01/17.
 */
public class DeplacementStandard implements Deplacement{

    @Override
    public void deplacer(int x, int y) {
        int mvtmodifie = mvt;
        if(empoisonne) mvtmodifie-=2;
        if(Math.abs(x-xpos)+Math.abs(y-ypos)<=mvtmodifie){
            xpos=x;
            ypos=y;
            //	System.out.println("L'unite "+nom+" se deplace en "+xpos+", "+ypos);
        }else{
            //System.out.println("L'unite "+nom+" ne peut se deplacer si loin");
        }

    }
}
