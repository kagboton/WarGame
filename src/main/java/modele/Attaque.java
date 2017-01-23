package modele;

public class Attaque {
	int degat;
	boolean poison;
	int impactX;
	int impactY;
	int rayon;
	public int getImpactY() {
		return impactY;
	}
	public int getRayon() {
		return rayon;
	}
	public Attaque(int degat,int x,int y, int rayon, boolean poison) {
		super();
		this.impactX=x;
		this.impactY=y;
		this.degat = degat;
		this.poison = poison;
		this.rayon = rayon;
	}
	public int getDegat() {
		return degat;
	}
	public boolean getPoison() {
		return poison;
	}
	public int getImpactX() {
		// TODO Auto-generated method stub
		return impactX;
	}
}
