package IhmFinal;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AnnuaireAdmin extends BorderPane {
	
	VBox total = new VBox();
	private VBox titre = new VBox();
	private GridPane haut = new GridPane();
	private HBox hBoxStagiaire1 = new HBox();
	private HBox rechercher = new HBox();
	
	private HBox photoInfos1 = new HBox(30);
	private HBox infos1 = new HBox(100);
	
	private HBox btnBas = new HBox();
	private CheckBox selectionner = new CheckBox("sélectionné");
	
//TEXT ET TEXTFIELD
	private Text titres = new Text("Annuaire des stagiaires :" );
	
	private Text nom = new Text("Nom " );
	private TextField tNom = new TextField("");
	private Text prenom = new Text ("Prénom " );
	private TextField tPrenom = new TextField("");
	
	private Text departement = new Text ("Département  ");
	
	
	private Text promo = new Text ("Promotion");
	private TextField tPromo = new TextField();
	
	private Text annee = new Text ("Année");
	private Text errorAdd = new Text (" ==> Vous n'avez pas remplit tous les champs. Recommencez");
	
//BOUTONS
	private Button btnRechercher = new Button("Rechercher");
	private Button btnAdd = new Button("Ajouter");

	public Button btnRetour = new Button ("Retour");
	public Button btnSup = new Button ("Supprimer");
	public Button btnImprimer = new Button ("Imprimer");
	public Button btnMaj = new Button("Mettre à jour");
	
	ScrollPane scroll = new ScrollPane();
	
	


	public AnnuaireAdmin() {
		super();	
//HAUT DE PAGE	
	//ANNEE
	
		//
		// DEPARTEMENT
		//
				DepartementDAO dao = new DepartementDAO();
				ObservableList<Departement> observableDepartements = FXCollections.observableArrayList(dao.getDepartement());
				ComboBox<Departement> cb1 = new ComboBox<>(observableDepartements);
				cb1.getSelectionModel().select(75);
				cb1.setVisibleRowCount(5);
				
//									
//			ANNEE
//				
			
			ComboBox<String> cb = new ComboBox<>();
			
			// Determine l'annee en cours et remonte sur 40 ans pour le choix année
			Date date = new Date();
			SimpleDateFormat modelEcritureAnnee = new SimpleDateFormat("yyyy");
			String anneeEnCours = modelEcritureAnnee.format(date);
			int anneeAChoisir = 0;
			for (int i=0; i<40; i++) {
				anneeAChoisir= Integer.parseInt(anneeEnCours) - i;
			cb.getItems().add(String.valueOf(anneeAChoisir));
			}
			
			cb.getSelectionModel().select(0); // on commence la box par l'indice 0
			cb.setVisibleRowCount(4); 		  // on affiche que 4 elements dans la box + menu deroulant
				

		titre.getChildren().addAll(titres,haut,rechercher);
		titre.setAlignment(Pos.CENTER);
		titre.setStyle("-fx-background-color:#e2fdff");
		titres.setFont(Font.font("Verdana",40));
		
		
		tNom.setPrefWidth(300.);		// MODIF ICI
		tPrenom.setPrefWidth(250.);		// MODIF ICI
		tPromo.setPrefWidth(220.);		// MODIF ICI
		haut.addRow(1,nom,tNom,prenom,tPrenom,annee,cb,departement,cb1,promo,tPromo);		// MODIF ICI
		haut.setPadding(new Insets(10,10,00,10));		// MODIF ICI
		
		
		
		haut.setStyle("-fx-background-color: #a5f6ff");
		haut.setPrefSize(1470,50);
		haut.setVgap(10);
		haut.setHgap(10);
		
// STAGIAIRE 1
		 ImageView selectedImage1 = new ImageView();   
	     Image image1 = new Image(Annuaire.class.getResourceAsStream("photoID.png"));
	     selectedImage1.setImage(image1);
	     selectedImage1.setFitWidth(50);		// MODIF ICI 
	     selectedImage1.setFitHeight(50);
	     
	     Text nomS1 = new Text("Deschamps");
	     nomS1.setFont(Font.font("Verdana",20));
	     Text prenomS1 = new Text ("Francis");
	     prenomS1.setFont(Font.font("Verdana",20));
	     Text anneeS1 = new Text ("2015");
	     anneeS1.setFont(Font.font("Verdana",20));
	     Text dptS1 = new Text ("974- La Réunion");
	     dptS1.setFont(Font.font("Verdana",20));
	     Text promoS1 = new Text ("AI 100");
	     promoS1.setFont(Font.font("Verdana",20));
	     infos1.getChildren().addAll(nomS1,prenomS1,anneeS1,dptS1,promoS1,selectionner);
	     photoInfos1.getChildren().addAll(selectedImage1,infos1);
	     
	     
	     photoInfos1.setAlignment(Pos.CENTER_LEFT);

	     infos1.setPrefSize(1470, 50);
	     infos1.setAlignment(Pos.CENTER);
	     photoInfos1.setPrefSize(1470, 50);
	     //selectionner.setAlignment(Pos.CENTER);
	     selectionner.setFont(Font.font("Verdana",15));
	     selectionner.setPrefSize(150, 50);
	     photoInfos1.setStyle("-fx-padding: 10;" + "-fx-border-style: solid ;"
	    	        + "-fx-border-width: 10;"
	    	        + "-fx-border-radius: 0;" + "-fx-border-color: #a5f6ff;");
	     hBoxStagiaire1.setPadding(new Insets(10,10,10,10));
	     
	     total.getChildren().addAll(hBoxStagiaire1);
	     total.setPrefSize(1470, 515);
	     total.setStyle("-fx-background-color:#e2fdff");
	     scroll.setContent(total);
	    // scroll.setHbarPolicy(ScrollBarPolicy.NEVER);
	     scroll.setVbarPolicy(ScrollBarPolicy.ALWAYS);
//AFFICHAGE BAS DE PAGE     
	     hBoxStagiaire1.getChildren().addAll(photoInfos1);
	     hBoxStagiaire1.setStyle("-fx-background-color: #e2fdff");
	     hBoxStagiaire1.setPrefSize(1470,50);
	     
	    
	     
	    rechercher.getChildren().addAll(btnRechercher,btnAdd);
	    rechercher.setPadding(new Insets(10));  // espace sous et au dessus de la HBox
	 	rechercher.setSpacing(10);
	    rechercher.setAlignment(Pos.CENTER);
	 	rechercher.setStyle("-fx-background-color:#a5f6ff");
	 	rechercher.setPrefSize(1000,50);
	 	
	 	btnBas.getChildren().addAll(btnMaj,btnSup,btnImprimer,btnRetour);
	 	btnBas.setAlignment(Pos.BOTTOM_CENTER);
	 	btnBas.setSpacing(20);
	 	btnBas.setStyle("-fx-background-color:#a5f6ff");
	 	btnBas.setPadding(new Insets (5));
	 	btnBas.setPrefSize(1470,40);
	     
//EVENEMENT
	     
	btnRetour.setOnAction(new EventHandler<ActionEvent>() {

		@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				BienvenueAdmin bienvenueAdmin = new BienvenueAdmin();
				Scene scene = new Scene(bienvenueAdmin);
				Stage stage = (Stage)AnnuaireAdmin.this.getScene().getWindow();
				stage.sizeToScene();
				stage.setScene(scene);
				
			} 
						
		});		
	errorAdd.setFill(Color.RED); // Bouton ajouter, si tout les champs ne sont pas remplit =>msg d'erreur, 
	//il faut maintenant ajouter la fonction ajouter

btnAdd.setOnAction(new EventHandler<ActionEvent>() { 

@Override
public void handle(ActionEvent event) {
if(tNom.getText().isEmpty() || tPrenom.getText().isEmpty()  || tPromo.getText().isEmpty()) {
rechercher.getChildren().addAll(errorAdd);}

else {

BienvenuF bienvenuF = new BienvenuF();
Scene scene = new Scene(bienvenuF);
Stage stage = (Stage)AnnuaireAdmin.this.getScene().getWindow();
stage.sizeToScene();
stage.setScene(scene);


}}

});		
	
//ASSEMBLAGE TOTAL
		
VBox deco2 = new VBox();
deco2.getChildren().add(btnBas);
deco2.setPrefSize(1470,90);
deco2.setStyle("-fx-background-color:#e2fdff");

setCenter(total);
setBottom(deco2);
setTop(titre);
	}
	
	


	


	public Text getNom() {
		return nom;
	}


	public void setNom(Text nom) {
		this.nom = nom;
	}


	public TextField getTnom() {
		return tNom;
	}


	public void setTnom(TextField tnom) {
		this.tNom = tnom;
	}


	public Text getPrenom() {
		return prenom;
	}


	public void setPrenom(Text prenom) {
		this.prenom = prenom;
	}


	public TextField getTprenom() {
		return tPrenom;
	}


	public void setTprenom(TextField tprenom) {
		this.tPrenom = tprenom;
	}


	public Text getDepartement() {
		return departement;
	}


	public void setDepartement(Text departement) {
		this.departement = departement;
	}




	public Text getPromo() {
		return promo;
	}


	public void setPromo(Text promo) {
		this.promo = promo;
	}


	public TextField getTpromo() {
		return tPromo;
	}


	public void setTpromo(TextField tpromo) {
		this.tPromo = tpromo;
	}


	public Text getAnnee() {
		return annee;
	}


	public void setAnnee(Text annee) {
		this.annee = annee;
	}


	public HBox getRechercher() {
		return rechercher;
	}


	public void setRechercher(HBox rechercher) {
		this.rechercher = rechercher;
	}


	public Button getBtnRechercher() {
		return btnRechercher;
	}


	public void setBtnRechercher(Button btnRechercher) {
		this.btnRechercher = btnRechercher;
	}
	
	public Button getBtnRetour() {
		return btnRetour;
	}


	public void setBtnRetour(Button btnRetour) {
		this.btnRetour = btnRetour;
	}

}
