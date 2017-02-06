package modele.attaques;

import modele.unite.Unite;

public class AttaqueClassique extends IAttaque{

	int degat;


	public AttaqueClassique(int degat, int x, int y, int rayon) {
		super(x, y, rayon);
		this.degat = degat;
	}

	public int getDegat() {
		return degat;
	}

	@Override
	public Unite appliquerEffetSecondaire(Unite u) {
		return u;
	}
}
