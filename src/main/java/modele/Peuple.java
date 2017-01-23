package modele;

/**
 * Created by o2156238 on 23/01/17.
 */
public enum Peuple {

    TERRIEN("terrien"),
    MARTIEN("martien");

    private String name ="";

    //Constructeur
    Peuple(String name){
        this.name = name;
    }

    //Récuperer le nom du peuple
    public String toString() {
        return name;
    }

}
