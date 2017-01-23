package modele;

import java.util.ArrayList;
import java.util.Collection;


public class Joueur {
	
	private String nom;
    private int idJoueur;
    private static int identifiant = 0;
    Peuple p;
    Position position;
    int basex,basey;

	Collection<Unite> armee;



    //Constructeur avec des paramètres
	public Joueur(String nom) {
        this.idJoueur = identifiant;
		this.nom = nom;
        identifiant++;
	}

    /**
     * Getters et Setters
     */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    public Peuple getP() {
        return p;
    }

    public void setP(Peuple p) {
        this.p = p;
    }

    public int getBasex() {
        return basex;
    }

    public void setBasex(int basex) {
        this.basex = position.x;
    }

    public int getBasey() {
        return basey;
    }

    public void setBasey(int basey) {
        this.basey = position.y;
    }

    public Collection<Unite> getArmee() {
        return armee;
    }




	
	public void changerTypeUnite(String nom, Genre g){
		for(Unite e:armee)
			if(e.getNom().equals(nom))
				e.setG(g);		
	}
	
	public void deplacer(String nom, int x, int y){
		for(Unite e:armee)
			if(e.getNom().equals(nom))
				e.deplace(x, y);
	}
	
	
	
	public void defendre(Attaque a){
		for(Unite e:armee) {
			e.defendre(a);
			
		}

	}
	
	public Attaque attaquer(String nom, int x, int y){
		for(Unite e:armee)
			if(e.getNom().equals(nom))
				return e.attaque(x, y);
		return new Attaque(0,x,y,0, false);
	}
	
	public void finDeTour(){
		for(Unite e:armee){
			//e.print();
			e.finDeTour();
		}
	}


}
