package modele;

import modele.exceptions.ExceptionJoueurDejaExistant;
import modele.exceptions.ExceptionJoueurInnexistant;
import modele.exceptions.ExceptionPeupleInexistant;

/**
 * Created by o2156238 on 23/01/17.
 */
public interface IGestionWarGame {

    /**
     * Créer un nouveau joueur
     * @param nom du joueur
     * @throws ExceptionJoueurDejaExistant
     */
    void creerJoueur(String nom) throws ExceptionJoueurDejaExistant;

    /**
     * Methode pour que le joueur choisisse sa race
     * @param nom du
     * @param peuple
     * @throws ExceptionPeupleInexistant
     */
    void choisirRace(String nom, Peuple peuple) throws ExceptionPeupleInexistant, ExceptionJoueurInnexistant;

    /**
     * Méthode permettant de former une unite
     * @param peuple => le genre de l'unité
     * @return
     */
    Unite creerUnite(Peuple peuple);

    /**
     * Méthode pour changer la nature d'une unité
     * @param nom => nom de l'unité
     * @param g => genre à appliquer
     */
    void changerNatureUnite(String nom, Genre g);



}
