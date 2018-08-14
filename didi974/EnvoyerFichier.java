package IhmFinal;

import java.awt.Dimension;
import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class EnvoyerFichier extends BorderPane {
	
	private VBox centreV = new VBox();
	private HBox barreOuvrir = new HBox(); //new
	private Text txtAdresse = new Text(30,30,"Sélectionnez votre annuaire :"); //modif
	private TextField adresseAnnuaire = new TextField(""); // VIDE
	private Button btnSend = new Button("Envoyer");
	private Button btnRetour = new Button ("Retour");
	private Button btnOuvrir = new Button ("Ouvrir"); // nouveau
	private HBox sendBack = new HBox();
	private Text msgErreur = new Text("==> Aucun fichier n'a été selectionné"); //nouveau
	
	private HBox deco1 = new HBox();
	private HBox deco2 = new HBox();
	
	public EnvoyerFichier() {
		
		deco1.setPrefSize(1000, 50);
		deco1.setStyle("-fx-background-color:#e2fdff");
		deco2.setPrefSize(1000, 50);
		deco2.setStyle("-fx-background-color:#e2fdff");
		
		msgErreur.setFill(Color.RED); //nouveau
		
		btnOuvrir.setPadding(new Insets(7));
		btnSend.setPadding(new Insets(10));
		adresseAnnuaire.setPrefSize(1, 30);
		
		txtAdresse.setFont(Font.font("Verdana",20));
		txtAdresse.setFill(Color.BLACK);
		adresseAnnuaire.setPrefWidth(600);
		
		barreOuvrir.getChildren().addAll(adresseAnnuaire,btnOuvrir);
		barreOuvrir.setPadding(new Insets(10));
		barreOuvrir.setSpacing(10);
		barreOuvrir.setAlignment(Pos.CENTER);
		
		sendBack.getChildren().addAll(btnSend);
		sendBack.setAlignment(Pos.CENTER);
		centreV.getChildren().addAll(txtAdresse,barreOuvrir,sendBack);
		centreV.setAlignment(Pos.CENTER);
		centreV.setPadding(new Insets(10,20,20,10));
		centreV.setSpacing(10);
		
		setRight(btnRetour);
		
		setCenter(centreV);
		setTop(deco1);
		setBottom(deco2);
		setStyle("-fx-background-color: #a5f6ff");
		setPrefSize(1470,755);
		
		btnRetour.setOnAction(new EventHandler<ActionEvent>() { //modif => envoi sur bienvenueAdmin au lieu de bienvenuF

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				BienvenueAdmin bienvenueAdmin = new BienvenueAdmin();
				Scene scene = new Scene(bienvenueAdmin);
				Stage stage = (Stage)EnvoyerFichier.this.getScene().getWindow();
				
				stage.setScene(scene);
				
			} 
			
			
		});		
		
		btnOuvrir.setOnAction(new EventHandler<ActionEvent>() { // nouveau

			@Override
			public void handle(ActionEvent event) {
		
		FileChooser fileChooser = new FileChooser();
		File initDir = new File("C:/Users/formation/Desktop/");
		fileChooser.setInitialDirectory(initDir);
		Stage stage=(Stage)EnvoyerFichier.this.getScene().getWindow();;
		File f = fileChooser.showOpenDialog(stage.getOwner());
		
		if (f != null){	//LE BOUTON ENVOYER FONCTION	
		adresseAnnuaire.setText(f.getAbsolutePath()); //donne le path de l'annuaire
		}
} 			
		});		
		
		
		btnSend.setOnAction(new EventHandler<ActionEvent>() { //nouveau

			@Override
			public void handle(ActionEvent event) {
				
				if(adresseAnnuaire.getText().isEmpty()) {
					centreV.getChildren().addAll(msgErreur);
				} else {
					
					// ENVOYER LE LIENS COMME FICHIER SOURCE
				}		
			} 
			
			
		});		
		
	
		
		
	}

	public VBox getCentreV() {
		return centreV;
	}

	public void setCentreV(VBox centreV) {
		this.centreV = centreV;
	}

	public Text getTxtAdresse() {
		return txtAdresse;
	}

	public void setTxtAdresse(Text txtAdresse) {
		this.txtAdresse = txtAdresse;
	}

	public TextField getAdresseAnnuaire() {
		return adresseAnnuaire;
	}

	public void setAdresseAnnuaire(TextField adresseAnnuaire) {
		this.adresseAnnuaire = adresseAnnuaire;
	}

	public Button getBtnSend() {
		return btnSend;
	}

	public void setBtnSend(Button btnSend) {
		this.btnSend = btnSend;
	}
	

}
