package modele;

import java.util.ArrayList;
import java.util.Collection;


public class Joueur_save {

	//public enum Peuple{TERRIEN,MARTIEN}

	String nom;
    int basex,basey;
    Peuple p;
	Collection<Unite> armee;

	static int id=0;


	public Joueur_save(String nom, Peuple p, int basex, int basey) {
		//super();
		this.nom = nom;
		this.p = p;
		this.basex = basex;
		this.basey = basey;
		armee=new ArrayList<Unite>();
	}

    public Collection<Unite> getArmee() {
        return armee;
    }

	public String getNom() {
		return nom;
	}

    /**
     * Methode pour créer une unité
     * @return Unite
     */
	public Unite creerUnite(){
		Unite u;
		switch(p){		
		case MARTIEN:
			id++;
			u=new Unite("Soldat"+id, 20, 5, 10, 15, 25,basex,basey);
			armee.add(u); 
			//System.out.println("Unite formee par "+nom+" :");
			//u.print();
			return u;
		case TERRIEN:
		default:
			id++;
			u=new Unite("Soldat"+id, 15, 8, 7, 10, 30,basex,basey);
			armee.add(u);
			//System.out.println("Unite formee par "+nom+" :");
			//u.print();
			return u;
		}
		
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
