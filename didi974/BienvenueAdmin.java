package IhmFinal;

import Ihm.Bienvenue;
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

public class BienvenueAdmin extends BorderPane{

//RENVOIE L'ADMIN SUR LA PAGE BIENVENUE DE DEPART AVEC ACCES A L'ANNUAIRE ET LE BOUTON CHARGER UN ANNUAIRE QUI ENVOIE A ENVOYERFICHIER


		
		private BorderPane centre1= new BorderPane();
		private VBox centre = new VBox();
		private Text txtBienvenue = new Text(50,50,"Bienvenue");
		private Button btnChargerAnnuaire = new Button("Charger un annuaire");
		private Button btnAnnuaire = new Button("Accéder à l'annuaire");
		public Button btnDeconnexion = new Button ("Deconnexion"); //MODIF
		private VBox root = new VBox();
		private HBox deco1 = new HBox();
		private HBox deco2 = new HBox();
		
		public BienvenueAdmin() {
			super();
			
			deco1.setPrefSize(1000, 50);
			deco1.setStyle("-fx-background-color:#e2fdff");
			deco2.setPrefSize(1000, 50);
			deco2.setStyle("-fx-background-color:#e2fdff");
			
			
			txtBienvenue.setFont(Font.font("Verdana",80));
			txtBienvenue.setFill(Color.BLACK);
			
			
			
			
			 final ImageView selectedImage = new ImageView();   
		     Image image1 = new Image(BienvenuF.class.getResourceAsStream("logo.png"));
		     
		     selectedImage.setImage(image1);
		     
		     
		     root.getChildren().add(selectedImage);
		     root.setPadding(new Insets(10));
		     root.setAlignment(Pos.CENTER);
		     
		     
		    btnAnnuaire.setPadding(new Insets(10));
		    btnChargerAnnuaire.setPadding(new Insets(10));
		    
		     centre.getChildren().addAll(txtBienvenue, root, btnAnnuaire);
		     centre1.setCenter(centre);
		     centre1.setBottom(btnChargerAnnuaire);
		     centre1.setRight(btnDeconnexion);
		     centre.setMaxSize(1000, 700);
		     centre.setAlignment(Pos.CENTER);
		     centre1.setPrefSize(1000, 800);
		     centre1.setPadding(new Insets(10));
			
			 //centre.setSpacing(10);
			 setTop(deco1);
			 setBottom(deco2);
			 setCenter(centre1);
			 
			// setBottom(btnChargerAnnuaire);
			// setPadding(new Insets(20));
			 setStyle("-fx-background-color: #a5f6ff");
			 setPrefSize(1470,755);
			
			
			btnAnnuaire.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					AnnuaireAdmin annuaireAdmin = new AnnuaireAdmin();
					Scene scene = new Scene(annuaireAdmin);
					Stage stage = (Stage)BienvenueAdmin.this.getScene().getWindow();
					stage.setScene(scene);
					
				} 	
				
			});		
			
			
			btnChargerAnnuaire.setOnAction(new EventHandler<ActionEvent>() {


					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						EnvoyerFichier envoyerFichier = new EnvoyerFichier();
						Scene scene = new Scene(envoyerFichier);
						Stage stage = (Stage)BienvenueAdmin.this.getScene().getWindow();
						stage.sizeToScene();
						stage.setScene(scene);
						
					} 
					
					
				});		
			
			btnDeconnexion.setOnAction(new EventHandler<ActionEvent>() {


				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					BienvenuF bienvenuF = new BienvenuF();
					Scene scene = new Scene(bienvenuF);
					Stage stage = (Stage)BienvenueAdmin.this.getScene().getWindow();
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
			return btnChargerAnnuaire;
		}

		public void setBtnChargerAnnuaire(Button btnChargerAnnuaire) {
			this.btnChargerAnnuaire = btnChargerAnnuaire;
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



