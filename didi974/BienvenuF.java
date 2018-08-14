package IhmFinal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BienvenuF extends BorderPane {
	
	private BorderPane centre1= new BorderPane();
	private VBox centre = new VBox();
	private Text txtBienvenue = new Text(50,50,"Bienvenue");
	private Button btnConnexion = new Button("Connectez vous");
	private Button btnAnnuaire = new Button("Accéder à l'annuaire");
	private VBox root = new VBox();
	private HBox deco1 = new HBox();
	private HBox deco2 = new HBox();
	
	public BienvenuF() {
		super();
		
		deco1.setPrefSize(1470, 50);
		deco1.setStyle("-fx-background-color:#e2fdff");
		deco2.setPrefSize(1470, 50);
		deco2.setStyle("-fx-background-color:#e2fdff");
		
		
		txtBienvenue.setFont(Font.font("Verdana",80));
		txtBienvenue.setFill(Color.BLACK);
		
		
			
		 final ImageView selectedImage = new ImageView();   
	     Image image1 = new Image(BienvenuF.class.getResourceAsStream("logo.png"));
	     
	     selectedImage.setImage(image1);
	     
	     
	     root.getChildren().add(selectedImage);
	     root.setPadding(new Insets(10));
	     root.setAlignment(Pos.CENTER);
	     root.setPrefSize(1470, 100);
	     
	     
	    btnAnnuaire.setPadding(new Insets(10));
	    btnConnexion.setPadding(new Insets(10));
	    
	    
	     centre.getChildren().addAll(txtBienvenue, root, btnAnnuaire);
	     centre.setAlignment(Pos.CENTER);
	     centre.setPrefSize(1470, 755);
	     centre1.setCenter(centre);
	     centre1.setRight(btnConnexion);
	     centre1.setPrefSize(1470, 755);
	     centre1.setPadding(new Insets(10));
	     
	    /* centre.setStyle("-fx-padding: 10;" + "-fx-border-style: solid ;"
	    	        + "-fx-border-width: 10;"
	    	        + "-fx-border-radius: 0;" + "-fx-border-color: red;");*/
		
		 
		 setTop(deco1);
		 setBottom(deco2);
		 setCenter(centre1);
		 
		
		 setStyle("-fx-background-color: #a5f6ff");
		 setPrefSize(1470, 755);
		
		
		btnAnnuaire.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Annuaire annuaire = new Annuaire();
				Scene scene = new Scene(annuaire);
				Stage stage = (Stage)BienvenuF.this.getScene().getWindow();
				stage.setScene(scene);
				
			} 	
			
		});		
		
		btnConnexion.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Connexion connexion = new Connexion();
				Scene scene = new Scene(connexion);
				Stage stage = (Stage)BienvenuF.this.getScene().getWindow();
				stage.sizeToScene();
				stage.setScene(scene);
				
			} 
			
			
		});		
	}
	
	

	public VBox getCentre() {
		return centre;
	}

	public void setCentre(VBox centre) {
		this.centre = centre;
	}

	public Text getTxtBienvenue() {
		return txtBienvenue;
	}

	public void setTxtBienvenue(Text txtBienvenue) {
		this.txtBienvenue = txtBienvenue;
	}

	public Button getBtnChargerAnnuaire() {
		return btnConnexion;
	}

	public void setBtnChargerAnnuaire(Button btnChargerAnnuaire) {
		this.btnConnexion = btnChargerAnnuaire;
	}

	public Button getBtnAnnuaire() {
		return btnAnnuaire;
	}

	public void setBtnAnnuaire(Button btnAnnuaire) {
		this.btnAnnuaire = btnAnnuaire;
	}

	public VBox getRoot() {
		return root;
	}

	public void setRoot(VBox root) {
		this.root = root;
	}



	
	

}
