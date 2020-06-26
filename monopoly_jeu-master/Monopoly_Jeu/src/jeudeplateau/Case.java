package jeudeplateau;

import java.util.ArrayList;
import cases.CaseChance;
import cases.CaseCommunaute;
import cases.CaseDepart;
import cases.CaseImpots;
import cases.CaseServicePublic;
import fenetres.FenetreDeJeu;
import javafx.scene.shape.Polygon;
import jeumonopoly.JoueurMonopoly;
import jeumonopoly.PlateauMonopoly;

/**
 * D�finit les cases du Monopoly
*@author  Massourang Jugurtha Lina Emma
*/

public abstract class Case {

	private String nom;
	private int id = 0;
	private int valeur = 0;
	private Polygon signet = new Polygon();
	public ArrayList<Polygon> Salaries = new ArrayList<Polygon>();

	/**
	 * D�finit le nom de la case
	 * @param nom String
	 * @param valeur int
	 */
	public Case(String nom, int valeur) {
		this.nom = nom;
		this.valeur = valeur;

		for(int i=0; i<6; i++) {
			Polygon Salarie = new Polygon();
			Salaries.add(Salarie);
		}
	}

	/**
	 * Retourne le nom 
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Retourne l'id
	 * @return id
	 */
	public int getId(){
		return id;
	}

	/**
	 * Actualisation de l'id
	 * @param id int
	 */
	public void setId(int id){
		this.id = id;
	}

	/**
	 * Renvoie salaire du salarie
	 * @return prix
	 */
	public int getPrix() {
		return valeur;
	}

	/**
	 * D�finit le salaire du salarie
	 * @param valeur int
	 */
	public void setPrix(int valeur) {
		this.valeur = valeur;
	}


	/**
	 * Marque la case en fonction de la couleur du joueur
	 * @return Signet
	 */
	public Polygon getSignetPatron(){
		return this.signet;
	}

	/**
	 * D�finit un signet de possession d'un salari�
	 * @param r Polygon
	 */
	public void setSignet(Polygon r){
		this.signet = r;
	}

	/* PARTIE ABSTRAITE */

	/**
	 * Renvoie le directeur d'un salari�
	 * @return Patron
	 */
	public abstract JoueurMonopoly getPatron();

	/**
	 * Renvoie la couleur de la case
	 * @return couleur
	 */
	public abstract String getCouleur();

	/**
	 * Renvoie le salaire du salari� en fonction du nombre de comp�tences 
	 * @return apayer
	 */
	public abstract int getSalaire();

	/**
	 * Renvoie le prix d'une Salarie
	 * @return prixSalarie
	 */
	public abstract int getPrixCompetence();

	/**
	 * Rentourne le nombre de competence d'un salarie 
	 * @return nbSalarie
	 */
	public abstract int getNbCompetence();

	/**
	 * Retourne la r�ponse � la question : la question diff�re selon les classes.
	 * @return rep
	 */
	public abstract boolean getRep();

	/**
	 * D�termine si un joueur peut monter en competence. 
	 * Possible lorsque:
	 * - Le joueur poss�de toutes les salaries d'une m�me couleur
	 * - Le nombre de competence sur chaque case doit �tre identique pour en rajouter (ex : 1 Salarie sur chaque case d'une couleur pour  en poser une deuxi�me)
	 * @return boolean
	 * @see JoueurMonopoly
	 */
	public abstract boolean getPeutMonterEnCompetence();

	/**
	 * D�finition du directeur de la case.
	 * @param j : joueur
	 */
	public abstract void setPatron(JoueurMonopoly j);

	/**
	 * D�finition de la r�ponse du joueur via les boutons de l'interface.
	 * La r�ponse est d�fini alatoirement si la partie est en mode automatique.
	 * @param b : boolean
	 */
	public abstract void setRep(boolean b);

	/**
	 * Appelle la fen�tre d'action associ� � la case (acquisition d'une comp�tence, d'un grade, tirage d'une carte)
	 * @param fjeu : fenetre de la partie en cours
	 */
	public abstract void fenetreAction(FenetreDeJeu fjeu);

	/**
	 * Action de la case lorsqu'un joueur atteri dessus
	 * @param joueur JoueurMonopoly
	 * @param plateau PlateauMonopoly
	 * @param fjeu FenetreDeJeu
	 * @see CaseDepart
	 * @see CaseCommunaute
	 * @see CaseImpots
	 * @see CaseClient
	 * @see CaseChance
	 * @see CaseArretMaladie
	 * @see CaseServicePublic
	 * @see CaseOpenSpace
	 * @see CaseAllerArretMaladie
	 * @see CaseSalarie
	 */
	public abstract void actionCase(JoueurMonopoly joueur, PlateauMonopoly plateau, FenetreDeJeu fjeu);


	@Override
	public String toString() {
		return "Case [nom=" + nom + ", id=" + id + ", valeur=" + valeur + "]";
	}

}