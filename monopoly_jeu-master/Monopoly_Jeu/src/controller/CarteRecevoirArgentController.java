package controller;

import application.Clavier;
import jeu.JoueurMonopoly;
import jeu.PlateauMonopoly;
import model.Carte;
import view.FenetreDeJeu;

/**
 * Cette classe permet a un joueur de se voir cr�diter un certain montant pour
 * certaines action (passage a la case depart etc)
 */
public class CarteRecevoirArgentController extends Carte implements DefaultControllerInterface {

	private int montant;

	/**
	 * Constructeur
	 * 
	 * @param titre       String
	 * @param description String
	 * @param montant     int
	 *
	 */

	public CarteRecevoirArgentController(String titre, String description, int montant) {
		super(titre, description);
		this.montant = montant;
	}

	/**
	 * Methode definissant l'action de la carte.
	 * 
	 * @param joueur  JoueurMonopoly
	 * @param plateau PlateauMonopoly
	 * @param fp      FenetreDeJeu
	 */

	@Override
	public void action(JoueurMonopoly joueur, PlateauMonopoly plateau, FenetreDeJeu fp) {

		Clavier es = new Clavier();

		if (getNom().equals("Anniversaire")) {
			for (int i = 0; i < plateau.getNbJoueurs(); i++) {
				if (plateau.getJoueur(i) != joueur && !plateau.getJoueur(i).getEstFauche()) {
					plateau.getJoueur(i).retirerArgent(20);
					joueur.ajouterArgent(20);
				}
			}
			es.println("-> " + joueur.getNom() + " re�oit 20� de chaque joueur.");
			if (fp != null)
				fp.afficherMessage(joueur.getNom() + " re�oit 20� de chaque joueur.");
		}

		else {
			joueur.ajouterArgent(montant);
			es.println("-> " + joueur.getNom() + " re�oit " + montant + "� de la Banque");
		}
	}

	@Override
	public String toString() {
		return "CarteRecevoirArgent [" + super.toString() + " montant= " + montant + "]";
	}

}
