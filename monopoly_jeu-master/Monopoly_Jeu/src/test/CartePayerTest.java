package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import controller.CartePayerController;
import jeu.JoueurMonopoly;
import jeu.PlateauMonopoly;

/**
 * Teste la classe CasePayer
 * 
 * @author Massourang Jugurtha Lina Emma
 */

class CartePayerTest {

	JoueurMonopoly joueur = new JoueurMonopoly("Alice", 1, 1000);
	PlateauMonopoly plateau = new PlateauMonopoly(3);
	CartePayerController cartePayer;

	@Test
	/**
	 * Permet de tester la m�thode carteAction de la classe dans le cas o� la carte
	 * est celle du pr�sident du conseil donc le joueur 0 donne 10� � tous les
	 * autres joueurs
	 */
	void carteActionPresidentTest() {
		cartePayer = new CartePayerController("Pr�sident du conseil d'administration", "description", 10);
		cartePayer.action(plateau.getJoueur(0), plateau, null);
		assertEquals(990, plateau.getJoueur(0).getArgent());
		assertEquals(1000, plateau.getJoueur(1).getArgent());
		assertEquals(1000, plateau.getJoueur(2).getArgent());
	}

	@Test
	/**
	 * Permet de tester la m�thode carteAction de la classe donc l'argent du joueur
	 * baisse du prix de la carte et le prix dans la case OpenSpace augmente du prix
	 * de la carte
	 */
	void carteActionTest() {
		cartePayer = new CartePayerController("Carte Payer", "description", 30);
		cartePayer.action(joueur, plateau, null);
		assertEquals(970, joueur.getArgent());
		assertEquals(30, plateau.getCase(20).getPrix());
	}

}
