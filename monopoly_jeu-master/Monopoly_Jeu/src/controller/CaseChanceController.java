package controller;

import application.Clavier;
import jeu.JoueurMonopoly;
import jeu.PlateauMonopoly;
import model.Carte;
import model.Case;
import view.FenetreDeJeu;

/**
 * Cr�e l'action d'une case chance
 * 
 * @author Massourang Jugurtha Lina Emma
 */
public class CaseChanceController extends Case implements DefaultControllerInterface {

	/**
	 * Indique le nom de la case
	 */
	public CaseChanceController() {
		super("Chance", 0);
	}

	/**
	 * M�thode d�finissant l'action de la carte.
	 * 
	 * @param joueur  JoueurMonopoly
	 * @param plateau PlateauMonopoly
	 * @param fp      FenetreDeJeu
	 */
	@Override
	public void action(JoueurMonopoly joueur, PlateauMonopoly plateau, FenetreDeJeu fjeu) {
	}

	@SuppressWarnings("static-access")
	@Override
	/**
	 * Permet de tirer et afficher une carte chance
	 * 
	 * @see Carte
	 */
	public void fenetreAction(FenetreDeJeu fjeu) {

		Clavier es = new Clavier();

		Carte carte = fjeu.getPartie().getPM().tirerCarteChance();
		es.println("-> " + fjeu.getPartie().getPM().getJoueurActif().getNom() + " tire la carte " + carte.getNom());
		fjeu.afficherMessage(fjeu.getPartie().getPM().getJoueurActif().getNom() + " tire la carte " + carte.getNom());

		if (fjeu.getPartie().PARTIE_AUTO)
			fjeu.getPartie().reprendrePartie();
		else
			fjeu.afficherFenetreCarteChance(carte.getNom(), carte.getDesc());

		fjeu.getPartie().pausePartie();
		while (fjeu.getPartie().getPausePartie() && !fjeu.getPartie().PARTIE_AUTO) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		carte.action(fjeu.getPartie().getPM().getJoueurActif(), fjeu.getPartie().getPM(), fjeu);
	}

	@Override
	public JoueurMonopoly getPatron() {
		return null;
	}

	@Override
	public String getCouleur() {
		return null;
	}

	@Override
	public int getSalaire() {
		return 0;
	}

	@Override
	public int getPrixCompetence() {
		return 0;
	}

	@Override
	public int getNbCompetence() {
		return 0;
	}

	@Override
	public boolean getRep() {
		return false;
	}

	@Override
	public boolean getPeutMonterEnCompetence() {
		return false;
	}

	@Override
	public void setPatron(JoueurMonopoly j) {
	}

	@Override
	public void setRep(boolean b) {
	}

	@Override
	public String toString() {
		return "CaseChance [" + super.toString() + "]";
	}

	@Override
	public String descriptionPoste() {
		// TODO Auto-generated method stub
		return null;
	}

}
