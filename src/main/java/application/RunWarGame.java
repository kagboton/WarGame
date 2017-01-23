package application;

import modele.*;
import modele.Joueur;
import modele.Unite;

import java.util.Collection;
import java.util.Scanner;


public class RunWarGame {


	public static int selectionnerRace(int x, int y) {
		int choix;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Voulez vous être marsien (1) ou terrien (2) ?\n Saisissez le numero correspondant");
			choix = sc.nextInt();
		} while (choix !=1 && choix!=2);
		return choix;
	}


	public static void gestionAction(int choix, Joueur joueur, Joueur joueur2) {
		switch (choix) {
			case 1 : {
				int cx;
				do {
					System.out.println(joueur.getNom() + ", voici types d'unite possibles :\n");
					System.out.println("1 - Former un Sniper");
					System.out.println("2 - Former un Grenadier");
					Scanner sc = new Scanner(System.in);
					cx = sc.nextInt();
				} while(cx!= 1 && cx != 2);
				Unite u =joueur.creerUnite();
				if (cx == 1) {
					joueur.changerTypeUnite(u.getNom(), Genre.SNIPER);
				}
				else {
					joueur.changerTypeUnite(u.getNom(),Genre.GRENADE);
				}
				break;
			}

			case 0 : {
				joueur.finDeTour();
				break;
			}

			case 2 : {
				Collection<Unite> armee = joueur.getArmee();
				System.out.println("Armee de "+joueur.getNom()+" :");
				for(Unite u : armee) {
					System.out.println("********************************* ");
					u.print();
					System.out.println("********************************* ");
				}
				actionJeu(joueur,joueur2);
			}



			case 3 : {
				Collection<Unite> armee = joueur.getArmee();
				System.out.println(joueur.getNom()+", quelle unite voulez vous deplacer:");
				int indice = 0;
				for(Unite u : armee) {
					System.out.println("******* Unite "+indice+"********* ");
					u.print();
					System.out.println("********************************* ");
					indice ++;
				}
				String cx;
				Scanner sc = new Scanner(System.in);
				System.out.println("Saisissez le nom de l'unite a deplacer" );

					cx = sc.next();
				System.out.println("Quelles seront les nouvelles coordonnees ?");
				System.out.println("en x ?");
				int x = sc.nextInt();
				System.out.println("en y ?");
				int y = sc.nextInt();
				joueur.deplacer(cx,x,y);
				break;


			}


			case 4 : {
				Collection<Unite> armee = joueur.getArmee();
				System.out.println(joueur.getNom()+", quelle unite va attaquer ?");
				int indice = 0;
				for(Unite u : armee) {
					System.out.println("******* Unite "+indice+"********* ");
					u.print();
					System.out.println("********************************* ");
					indice ++;
				}
				String cx;
				Scanner sc = new Scanner(System.in);
				System.out.println("Saisissez le nom de l unite qui va attaquer" );
				cx = sc.next();
				System.out.println("Quelles seront les nouvelles coordonnees d'attaque ?");
				System.out.println("en x ?");
				int x = sc.nextInt();
				System.out.println("en y ?");
				int y = sc.nextInt();
				Attaque a = joueur.attaquer(cx, x, y);
				joueur2.defendre(a);

			}



		}
	}

	public static void actionJeu(Joueur joueur, Joueur joueur2) {
		int choix;
		Scanner sc;
		do {
			System.out.println(joueur.getNom() + ", voici les actions possibles :\n");
			System.out.println("1 - Former une unite");
			System.out.println("2 - Afficher mon armee");
			System.out.println("3 - Deplacer une unite");
			System.out.println("4 - Changer nature d une unite");
			System.out.println("0 - Fin de tour");
			sc = new Scanner(System.in);
			choix = sc.nextInt();
		} while(choix< 0 && choix >4);
		gestionAction(choix,joueur,joueur2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" -------------------------------");
		System.out.println("| Bienvenu dans notre WarGame ! |");
		System.out.println(" -------------------------------");
		System.out.println("----------------------------------------------------");
		System.out.println("Saisissez le pseudo du joueur 1");
		String pseudo1 = sc.next();
		int c1 = selectionnerRace(0,0);
		System.out.println("Saisissez le pseudo du joueur 2");
		String pseudo2 = sc.next();
		int c2 = selectionnerRace(5,5);
		System.out.println("----------------------------------------------------");

		Joueur[] joueurs = new Joueur[2];
		int joueurCourant = 0;
		if (c1 == 1) {
			joueurs[0] = new Joueur(pseudo1, Peuple.MARTIEN,0,0);

		}
		else {
			joueurs[0] = new Joueur(pseudo1,Peuple.TERRIEN,0,0);
		}
		if (c2 == 1) {
			joueurs[1] = new Joueur(pseudo2,Peuple.MARTIEN,5,5);

		}
		else {
			joueurs[1] = new Joueur(pseudo2,Peuple.TERRIEN,5,5);
		}


		do {


			actionJeu(joueurs[joueurCourant],joueurs[(joueurCourant+1)%2]);
			joueurCourant = (joueurCourant +1)%2;

			actionJeu(joueurs[joueurCourant],joueurs[(joueurCourant+1)%2]);
			joueurCourant = (joueurCourant +1)%2;
		}while (joueurs[0].getArmee().size()>0 && joueurs[1].getArmee().size()>0);


	}

}
