package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import model.Case;
import view.FenetreActionSurSalarie;
import view.FenetreDeJeu;

public class ActionSurSalarieRevendreController implements EventHandler<ActionEvent> {

	private FenetreActionSurSalarie fenetreActionSurSalarie;

	public ActionSurSalarieRevendreController(FenetreActionSurSalarie fenetreActionSurSalarie) {
		this.fenetreActionSurSalarie = fenetreActionSurSalarie;
	}

	@Override
	public void handle(ActionEvent event) {
		FenetreDeJeu fenetreDeJeu = fenetreActionSurSalarie.getFenetreDeJeu();
		int position = fenetreActionSurSalarie.getPosition();
		int prixRevente = fenetreDeJeu.getPartie().getPM().getCase(position).getPrix()
				+ fenetreDeJeu.getPartie().getPM().getCase(position).getNbCompetence()
						* fenetreDeJeu.getPartie().getPM().getCase(position).getPrixCompetence();
		fenetreDeJeu
				.afficherMessage(fenetreDeJeu.getPartie().getPM().getCase(position).getPatron().getNom() + " revend "
						+ fenetreDeJeu.getPartie().getPM().getCase(position).getNom() + " pour " + prixRevente + "�");
		fenetreDeJeu.getPartie().getPM().getJoueurActif().getListeSalaries()
				.remove(fenetreDeJeu.getPartie().getPM().getCase(position));
		fenetreDeJeu.getPartie().getPM().getCase(position).setPatron(null);
		fenetreDeJeu.getPartie().getPM().getCase(position).getSignetPatron().setFill(Color.TRANSPARENT);
		fenetreDeJeu.getPartie().getPM().getJoueurActif().getListeCouleur();
		Case c = fenetreDeJeu.getPartie().getPM().getCase(position);

		if (c.getId() == 5 || c.getId() == 15 || c.getId() == 25 || c.getId() == 35) {
			fenetreDeJeu.getPartie().getPM().getJoueurActif()
					.setNbEntreprises(fenetreDeJeu.getPartie().getPM().getJoueurActif().getNbEntreprises() - 1);
		} else if (c.getId() == 12 || c.getId() == 28) {
			fenetreDeJeu.getPartie().getPM().getJoueurActif()
					.setNbEntreprises(fenetreDeJeu.getPartie().getPM().getJoueurActif().getNbEntreprises() - 1);
		} else {
			CaseSalarieController t = (CaseSalarieController) fenetreDeJeu.getPartie().getPM().getCase(position);
			t.setNbCompetence(0);
		}

		for (int i = 0; i < 6; i++) {
			fenetreDeJeu.getPartie().getPM().getCase(position).Salaries.get(i).setFill(Color.TRANSPARENT);
		}
		fenetreDeJeu.getPartie().getPM().getJoueurActif().ajouterArgent(prixRevente);
		fenetreActionSurSalarie.getStage().close();
		event.consume();
	}
}
