package IhmFinal;

import javax.swing.JPasswordField;

import Ihm.Connexions;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Connexion extends BorderPane{
	
	private HBox boxInstruction = new HBox();
	private GridPane centre = new GridPane();
	private Text instruction = new Text ("Connectez vous");
	
	private Text incorrect = new Text("  ==>  Vos identifiants sont incorrects");
	private Text incorrect1 = new Text("Recommencez ou revenez à la page précédente");
	
	private Text id = new Text("Entrez votre identifiant  ");
	private Text mp = new Text("Entrez votre mot de passe  ");
	private TextField tId = new TextField();
	private TextField tMp = new TextField();
	private Button btnConnexion = new Button("Connexion");
	private HBox deco1 = new HBox();
	private HBox deco2 = new HBox();
	private Button btnRetour = new Button ("Retour");
	

	
	
 public Connexion() {
	
	 deco1.setPrefSize(1470, 50);
		deco1.setStyle("-fx-background-color:#e2fdff");
		deco2.setPrefSize(1470, 50);
		deco2.setStyle("-fx-background-color:#e2fdff");
		
	incorrect.setFill(Color.RED);
	incorrect1.setFill(Color.RED);

	instruction.setFont(Font.font("Verdana",20));
	boxInstruction.getChildren().add(instruction);
	centre.add(boxInstruction, 1, 0);
	
	centre.add(id, 0, 2);
	centre.add(tId, 1, 2);
	centre.add(mp, 0, 3);
	centre.add(tMp, 1, 3);
	centre.add(btnConnexion, 1, 4);
	centre.add(btnRetour, 2, 4);
	centre.setVgap(5);
	
	centre.setAlignment(Pos.CENTER);
	centre.setPadding(new Insets (10));

	centre.setPrefHeight(200);
	centre.setPrefWidth(400);
	//centre.setPrefSize(5, 2);;
	
	//root.setTop(boxInstruction);
	setCenter(centre);
	setTop(deco1);
	setBottom(deco2);
	setStyle("-fx-background-color: #a5f6ff");
	setPrefSize(1470,755);
	
	btnRetour.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			BienvenuF bienvenuF = new BienvenuF();
			Scene scene = new Scene(bienvenuF);
			Stage stage = (Stage)Connexion.this.getScene().getWindow();
			
			stage.setScene(scene);
			
		} 
		
		
	});		
	
	String admin = "admin";
	String motP = "2";
	
	
	btnConnexion.setOnAction(new EventHandler<ActionEvent>() {

		@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
			
			if (tId.getText().equals(admin) && tMp.getText().equals(motP)) {
			
				BienvenueAdmin bienvenueAdmin = new BienvenueAdmin();
				Scene scene = new Scene(bienvenueAdmin);
				Stage stage = (Stage)Connexion.this.getScene().getWindow();
				stage.sizeToScene();
				stage.setScene(scene);
				
			}  else {
				
				centre.add(incorrect, 1, 5);
				centre.add(incorrect1, 1, 6);
					};
			
		}
						
		});		
}}
	


