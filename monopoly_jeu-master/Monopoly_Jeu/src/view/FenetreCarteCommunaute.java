package view;

import controller.CommunauteQuitterController;
import controller.CommunauteValiderController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Fenetre;

/**
 * Fen�tre � afficher lorqu'on atterit sur une CaseCommunaute.
 */
public class FenetreCarteCommunaute extends Fenetre {

	private FenetreDeJeu fenetreDeJeu;
	private Stage stage;
	private HBox root;
	private VBox carte;
	private Button b_Ok;
	private Label l_Intitule = new Label("COMMUNAUT�");
	private Label l_Description = new Label("?");

	/**
	 * constructeur prenant en param�tre FenetreDeJeu
	 * 
	 * @param fjeu FenetreDeJeu
	 */
	public FenetreCarteCommunaute(FenetreDeJeu fjeu) {

		this.fenetreDeJeu = fjeu;

		this.stage = new Stage();
		this.stage.setTitle("Carte Communaut�");
		this.stage.initOwner(fjeu.getStage());
		this.stage.initModality(Modality.APPLICATION_MODAL);

		root = new HBox();
		initRoot();

		Scene scene = new Scene(root, 440, 200);
		stage.setScene(scene);

		stage.setOnHiding(new CommunauteQuitterController(this));
	}

	/**
	 * Initialise la HBox root de la FenetreCarteChance avec une image, une
	 * description de la carte et un bouton OK.
	 */
	private void initRoot() {

		root.setFillHeight(true);
		root.setAlignment(Pos.CENTER_LEFT);
		root.setPadding(new Insets(10, 10, 10, 10));
		root.setSpacing(15);
		root.setStyle(
				"-fx-background-color: #CDE6D0; -fx-border-style: dashed; -fx-border-width: 3px; -fx-border-color: blue");

		Image i_communaute = new Image("images/communaute.jpg");
		ImageView iv_communaute = new ImageView(i_communaute);
		root.getChildren().add(iv_communaute);

		this.carte = new VBox();
		carte.setFillWidth(true);

		l_Intitule.setStyle("-fx-font-size: 20px");
		carte.getChildren().add(l_Intitule);
		l_Description.setStyle("-fx-padding: 10px 0px");
		carte.getChildren().add(l_Description);

		b_Ok = new Button("OK");
		b_Ok.setDefaultButton(true);
		b_Ok.setOnAction(new CommunauteValiderController(this));
		b_Ok.setStyle(" -fx-background-color:#090a0c,\n"
				+ "        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n"
				+ "        linear-gradient(#20262b, #191d22),\n"
				+ "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n"
				+ "    -fx-background-radius: 5,4,3,5;\n" + "    -fx-background-insets: 0,1,2,0;\n"
				+ "    -fx-text-fill: white;\n"
				+ "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n"
				+ "    -fx-font-family: \"Arial\";\n" + "    -fx-text-fill: linear-gradient(white, #d0d0d0);\n"
				+ "    -fx-font-size: 12px;\n" + "    -fx-padding: 10 20 10 20;");
		carte.getChildren().add(b_Ok);

		root.getChildren().add(carte);
	}

	/**
	 * Renvoie la Stage de la fen�tre.
	 * 
	 * @return stage Stage
	 */
	public Stage getStage() {
		return stage;
	}

	/**
	 * D�finit le Intitule de la carte.
	 * 
	 * @param Intitule String
	 */
	public void setIntitule(String Intitule) {
		l_Intitule = new Label("COMMUNAUT�");
	}

	/**
	 * D�finit la description de la carte.
	 * 
	 * @param description String
	 */
	public void setDescription(String description) {
		l_Description = new Label(description);
	}

	public FenetreDeJeu getFenetreDeJeu() {
		return fenetreDeJeu;
	}

	public void setFenetreDeJeu(FenetreDeJeu fenetreDeJeu) {
		this.fenetreDeJeu = fenetreDeJeu;
	}

	/**
	 * Affiche la fen�tre en r�initialisant la HBox root � chaque appel.
	 */
	public void afficherCarte() {
		root = new HBox();
		initRoot();

		Scene scene = new Scene(root, 440, 200);
		stage.setScene(scene);
		stage.show();
	}

}
