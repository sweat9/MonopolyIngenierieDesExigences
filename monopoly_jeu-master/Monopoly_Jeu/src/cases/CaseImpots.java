package cases;

import fenetres.FenetreDeJeu;
import io.Console;
import jeudeplateau.Case;
import jeumonopoly.JoueurMonopoly;
import jeumonopoly.PlateauMonopoly;

/**
 * Cr�e l'action d'une case imp�t ou d'une taxe de luxe
*@author  Massourang Jugurtha Lina Emma
*/
public class CaseImpots extends Case {

	/**
	 * @param nom String : Intitul� de la case
	 * @param valeur int : prix de l'impot � payer
	 */
	public CaseImpots(String nom, int valeur) {
		super(nom, valeur);
	}

	/**
	 * Cette m�thode d�bite le joueur et cr�dite l'Open Space
	 * @see CaseOpenSpace
	 * @see jeudeplateau.Joueur
	 * @see Case
	 */
	public void actionCase(JoueurMonopoly joueur, PlateauMonopoly plateau, FenetreDeJeu fjeu) {

		Console es = new Console();

		es.println(" -> " + joueur.getNom() + " cr�dite de " + this.getPrix() + "� l'Open Space.");
		if(fjeu != null)
			fjeu.afficherMessage(joueur.getNom() + " cr�dite de " + this.getPrix() + "� l'Open Space.");

		joueur.retirerArgent(this.getPrix());

		int nouveauMontantOpenSpace = plateau.getCase(20).getPrix() + this.getPrix();
		plateau.getCase(20).setPrix(nouveauMontantOpenSpace);
	}

	
	@Override
	/**
	 * Reprend le cours de la partie
	 */
	public void fenetreAction(FenetreDeJeu fjeu) {
		fjeu.getPartie().reprendrePartie();
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
	public void setPatron(JoueurMonopoly j) {}

	@Override
	public void setRep(boolean b) {}
	
	public static void main(String[] args){

		System.out.println("TEST DE LA CLASSE : CaseImpots");
		JoueurMonopoly j = new JoueurMonopoly("Yann", 0, 1000);
		PlateauMonopoly p = new PlateauMonopoly(4);

		CaseImpots c = (CaseImpots) p.getCase(4);
		j.setPosition(4);
		c.actionCase(j, p, null);
		System.out.println(c.toString());
		System.out.println(p.getCase(20).toString());
		System.out.println(j.toString());
	}


}
