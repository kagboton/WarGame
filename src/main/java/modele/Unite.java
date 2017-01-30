package modele;

import modele.utilitaires.Genre;

public class Unite {
	
	//public enum Genre{STANDARD,SNIPER,POISON,GRENADE}
	
	String nom;
	
	int att,def,mvt,portee,vie,xpos,ypos;
	
	boolean empoisonne;
	int dureeempoisonnement;
	
	Genre g;

	public Unite(String nom, int att, int def, int mvt, int portee, int vie,
			int xpos, int ypos) {
		super();
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

	public Genre getG() {
		return g;
	}

	public void setG(Genre g) {
		this.g = g;
	}

	public int getAtt() {
		return att;
	}

	public int getMvt() {
		return mvt;
	}

	public int getDef() {
		return def;
	}

	public int getVie() {
		return vie;
	}

	public int getXpos() {
		return xpos;
	}

	public int getYpos() {
		return ypos;
	}
	
	public void deplace( int x, int y){
		int mvtmodifie=mvt;
		if(empoisonne) mvtmodifie-=2; 
		if(Math.abs(x-xpos)+Math.abs(y-ypos)<=mvtmodifie){			
			xpos=x;
			ypos=y;
		//	System.out.println("L'unite "+nom+" se deplace en "+xpos+", "+ypos);
		}else{
			//System.out.println("L'unite "+nom+" ne peut se deplacer si loin");
		}
	}
	
	public Attaque attaque(int x, int y){
		int attmodifie, porteemodifie;
		int rayon=0;
		boolean poison;

		switch(g){
		case STANDARD:					
			attmodifie=att;
			porteemodifie=portee;
			poison=false;
			rayon = 10;
			break;
		case SNIPER:
			attmodifie=att-5;
			porteemodifie=portee+3;
			poison=false;
			rayon=1;
			break;
		case POISON:
			attmodifie=att-5;
			porteemodifie=portee-3;
			poison=true;
			rayon=20;
			break;
		case GRENADE:
			attmodifie=att+5;
			porteemodifie=portee-3;
			poison=false;
			rayon=50;
			break;
		default :
			attmodifie=att;
			porteemodifie=portee;
			poison=false;
			break;				
		}
		
		if(Math.sqrt(Math.pow((xpos-x),2)+Math.pow((ypos-y),2))<=porteemodifie){
			//System.out.println("L'unite "+nom+" attaque et fait un maximum de "+attmodifie+" en degats");
			return new Attaque(attmodifie,x,y,rayon,poison);
		}else{
			//System.out.println("L'unite "+nom+" ne peut attaquer si loin");
			return new Attaque(0,x,y,0,false);
		}
	}
	
	public void defendre(Attaque a){
		//System.out.println(Math.sqrt(Math.pow((a.getImpactX()-this.getXpos()),2)+ Math.pow((a.getImpactY()-this.getYpos()),2)));
		//System.out.println(a.getRayon());
		if (Math.sqrt(Math.pow((a.getImpactX()-this.getXpos()),2)+ Math.pow((a.getImpactY()-this.getYpos()),2))<=a.getRayon()){
			int deg=a.getDegat()-def;
			if(deg<0) deg=0;
			if(deg>vie) deg=vie;
			vie-=deg;
			if(a.getPoison()){
				empoisonne=true;
				dureeempoisonnement=5;
			}
			//System.out.println("L'unite "+nom+" se defend contre "+def+" degats");
			//System.out.println("L'unite "+nom+" perd "+deg+" points de vie (il lui reste "+vie+")");
			if(empoisonne) System.out.println("L'unite "+nom+" est empoisonnee");
		}
		else {
			System.out.println("plouf");
		}
	}
	
	public void finDeTour(){
		if(empoisonne){
			dureeempoisonnement--;
			if(dureeempoisonnement==0) empoisonne=false;
		}
	}



	public void print(){
		System.out.println("Unite \t"+nom);
		System.out.println("Vie : \t"+vie);
		System.out.println("Att : \t"+att);
		System.out.println("Def : \t"+def);
		System.out.println("Portee : \t"+portee);
		System.out.println("Position : \t("+xpos+","+ypos+")");
		if(empoisonne) System.out.println("EMPOISSONNE");
	}

}
