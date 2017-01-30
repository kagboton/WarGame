package modele.unite;

import modele.comportements.attaque.StrategieAttaque;
import modele.comportements.attaque.AttaqueStandard;
import modele.comportements.deplacement.Deplacement;
import modele.comportements.deplacement.DeplacementStandard;
import modele.utilitaires.Genre;

/**
 * Created by o2156238 on 30/01/17.
 */
public class Unite {

    private String nom;
    private StrategieAttaque typeAttaque = new AttaqueStandard();
    private Deplacement typeDeplacement = new DeplacementStandard();
    private int att, def, mvt, portee, vie, xpos, ypos;
    private boolean empoisonne;
    private int dureeEmpoisonnement;
    private Genre g;

    //Constructeur avec des parametres
    public Unite(String nom, int att, int def, int mvt, int portee, int vie, int xpos, int ypos){
        this.nom = nom;
        this.att = att;
        this.def = def;
        this.mvt = mvt;
        this.portee = portee;
        this.vie = vie;
        this.xpos = xpos;
        this.ypos = ypos;
        this.g = Genre.STANDARD;
        empoisonne=false;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public StrategieAttaque getTypeAttaque() {
        return typeAttaque;
    }

    public void setTypeAttaque(StrategieAttaque typeAttaque) {
        this.typeAttaque = typeAttaque;
    }

    public Deplacement getTypeDeplacement() {
        return typeDeplacement;
    }

    public void setTypeDeplacement(Deplacement typeDeplacement) {
        this.typeDeplacement = typeDeplacement;
    }

    public int getAtt() {
        return att;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getMvt() {
        return mvt;
    }

    public void setMvt(int mvt) {
        this.mvt = mvt;
    }

    public int getPortee() {
        return portee;
    }

    public void setPortee(int portee) {
        this.portee = portee;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    public boolean isEmpoisonne() {
        return empoisonne;
    }

    public void setEmpoisonne(boolean empoisonne) {
        this.empoisonne = empoisonne;
    }

    public int getDureeEmpoisonnement() {
        return dureeEmpoisonnement;
    }

    public void setDureeEmpoisonnement(int dureeEmpoisonnement) {
        this.dureeEmpoisonnement = dureeEmpoisonnement;
    }

    public Genre getG() {
        return g;
    }

    public void setG(Genre g) {
        this.g = g;
    }
}
