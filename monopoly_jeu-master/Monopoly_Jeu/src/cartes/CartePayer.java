package cartes;

import application.Clavier;
import jeu.JoueurMonopoly;
import jeu.PlateauMonopoly;
import view.FenetreDeJeu;

/**
 * Cette classe permet a un joueur de se voir retirer un certain montant pour certaines action (amende, achat...)
 */
public class CartePayer extends Carte {
	
	private int montant;
	
	/**
	 * Constructeur
	 * @param titre String
	 * @param description String
	 * @param montant int
	 */
	public CartePayer(String titre, String description, int montant) {
		super(titre, description);
		this.montant = montant;
	}

	/**
	 * M�thode d�finissant l'action de la carte. 
	 * @param joueur JoueurMonopoly
	 * @param plateau PlateauMonopoly
	 * @param fp FenetreDeJeu
	 */
	@Override
	public void actionCarte(JoueurMonopoly joueur, PlateauMonopoly plateau, FenetreDeJeu fp) {
		
		Clavier es = new Clavier();
		
		if(getNom().equals("Pr�sident du conseil d'administration")) {
			for(int i=0; i<plateau.getNbJoueurs(); i++) {
				if(plateau.getJoueur(i) != joueur && !plateau.getJoueur(i).getEstFauche()) {
					plateau.getJoueur(i).ajouterArgent(10);
					joueur.retirerArgent(10);
				}
			}
			es.println("-> "+joueur.getNom()+" verse 10� � chaque joueur.");
			if(fp!=null)
				fp.afficherMessage(joueur.getNom()+" verse 10� � chaque joueur.");
		}
		else {
			joueur.retirerArgent(montant);
			plateau.getCase(20).setPrix(plateau.getCase(20).getPrix() + montant);
			es.println("-> "+joueur.getNom()+" d�pose " + montant + "� dans l'open space");
			if(fp !=null)
				fp.afficherMessage(joueur.getNom()+" d�pose " + montant + "� dans l'open space");
		}
	}
	public int getMontant(){
		return this.montant;
	}

	@Override
	public String toString() {
		return "CartePayer ["+ super.toString() +", montant= " + montant + "]";
	}
}
