package gui;
   
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//import business.Teppich;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class TeppichhandelAnwendungssystem
{
	  
    //---Anfang Attribute der grafischen Oberflaeche---
    /*private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblArtikelnummer 			= new Label("Artikelnummer:");
    private Label lblKategorie   		 	= new Label("Kategorie:");
    private Label lblBreite  	 		 	= new Label("Breite:");
    private Label lblLaenge   	 			= new Label("Laenge:");
    private Label lblFarben  				= new Label("Farben:");
    private TextField txtArtikelnummer 	 	= new TextField();
    private TextField txtKategorie			= new TextField();
    private TextField txtBreite				= new TextField();
    private TextField txtLaenge				= new TextField();
    private TextField txtFarben	 			= new TextField();
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImpkategorie 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImpkategorie 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExpkategorie 		= new MenuItem("csv-Export");    
    //-------Ende Attribute der grafischen Oberflaeche-------
    
    // speichert temporaer ein Objekt vom Typ Teppich
    private Teppich teppich;
    
    public TeppichhandelAnwendungssystem(Stage primaryStage){
    	/*Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von Teppichen");
    	primaryStage.show();
    	//this.initKomponenten();
		//this.initListener();
    }
    
   /* private void initKomponenten() {
		// Labels
		lblEingabe.setLayoutX(20);
		lblEingabe.setLayoutY(40);
		Font font = new Font("Arial", 24);
		lblEingabe.setFont(font);
		lblEingabe.setStyle("-fx-font-weight: bold;");
		lblAnzeige.setLayoutX(400);
		lblAnzeige.setLayoutY(40);
		lblAnzeige.setFont(font);
		lblAnzeige.setStyle("-fx-font-weight: bold;");
		lblArtikelnummer.setLayoutX(20);
		lblArtikelnummer.setLayoutY(90);
		lblKategorie.setLayoutX(20);
		lblKategorie.setLayoutY(130);
		lblBreite.setLayoutX(20);
		lblBreite.setLayoutY(170);
		lblLaenge.setLayoutX(20);
		lblLaenge.setLayoutY(210);
		lblFarben.setLayoutX(20);
		lblFarben.setLayoutY(250);
		pane.getChildren().addAll(lblEingabe, lblAnzeige, lblArtikelnummer, lblKategorie, lblBreite, lblLaenge,
				lblFarben);

		// Textfelder
		txtArtikelnummer.setLayoutX(170);
		txtArtikelnummer.setLayoutY(90);
		txtArtikelnummer.setPrefWidth(200);
		txtKategorie.setLayoutX(170);
		txtKategorie.setLayoutY(130);
		txtKategorie.setPrefWidth(200);
		txtBreite.setLayoutX(170);
		txtBreite.setLayoutY(170);
		txtBreite.setPrefWidth(200);
		txtLaenge.setLayoutX(170);
		txtLaenge.setLayoutY(210);
		txtLaenge.setPrefWidth(200);
		txtFarben.setLayoutX(170);
		txtFarben.setLayoutY(250);
		txtFarben.setPrefWidth(200);
		pane.getChildren().addAll(txtArtikelnummer, txtKategorie, txtBreite, txtLaenge, txtFarben);

		// Textbereich
		txtAnzeige.setEditable(false);
		txtAnzeige.setLayoutX(400);
		txtAnzeige.setLayoutY(90);
		txtAnzeige.setPrefWidth(270);
		txtAnzeige.setPrefHeight(185);
		pane.getChildren().add(txtAnzeige);

		// Buttons
		btnEingabe.setLayoutX(20);
		btnEingabe.setLayoutY(290);
		btnAnzeige.setLayoutX(400);
		btnAnzeige.setLayoutY(290);
		pane.getChildren().addAll(btnEingabe, btnAnzeige);

		// Menue
		this.mnbrMenuLeiste.getMenus().add(mnDatei);
		this.mnDatei.getItems().add(mnItmCsvImpkategorie);
		this.mnDatei.getItems().add(mnItmTxtImpkategorie);
		this.mnDatei.getItems().add(new SeparatorMenuItem());
		this.mnDatei.getItems().add(mnItmCsvExpkategorie);
		pane.getChildren().add(mnbrMenuLeiste);
	}
*/
    
  /* private void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        	    nehmeTeppichAuf();
            }
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	            zeigeTeppicheAn();
	        } 
   	    });
	    mnItmCsvImpkategorie.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	       	 	leseAusDatei("csv");
	    	}
	    });
	    mnItmTxtImpkategorie.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		     	leseAusDatei("txt");
		    }
    	});
	    mnItmCsvExpkategorie.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				schreibeTeppicheInCsvDatei();
			}	
	    });
    }/*
    
    /*private void nehmeTeppichAuf(){
    	try{ 
    		this.teppich = new Teppich(
    			txtArtikelnummer.getText(), 
   	            txtKategorie.getText(),
   	            Integer.parseInt(txtBreite.getText()),
   	        	Integer.parseInt(txtLaenge.getText()),
    		    txtFarben.getText().split(";"));
    		zeigeInformationsfensterAn("Der Teppich wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
   
    private void zeigeTeppicheAn(){
    	if(this.teppich != null){
    		txtAnzeige.setText(
    			this.teppich.gibTeppichZurueck(' '));
    	}
    	else{
    		zeigeInformationsfensterAn("Bisher wurde keine Teppich aufgenommen!");
    	}
    }    
		  
    private void leseAusDatei(String typ){
    	try {
      		if("csv".equals(typ)){
      			BufferedReader ein = new BufferedReader(new FileReader("Teppich.csv"));
      			String[] zeile = ein.readLine().split(";");
      			this.teppich = new Teppich(zeile[0], 
      				zeile[1], 
      				Integer.parseInt(zeile[2]), 
      				Integer.parseInt(zeile[3]), 
      				zeile[4].split("_"));
      				ein.close();
      	  			zeigeInformationsfensterAn(
      	  	   			"Der Teppich wurde gelesen!");
      		}
       		else{
	   			zeigeInformationsfensterAn(
	   				"Noch nicht implementiert!");
	   		}
		}
		catch(IOException exc){
			zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
		
	private void schreibeTeppicheInCsvDatei() {
		try {
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("TeppicheAusgabe.csv", true));
			aus.write(teppich.gibTeppichZurueck(';'));
			aus.close();
   			zeigeInformationsfensterAn(
	   			"Die Teppiche wurden gespeichert!");
		}	
		catch(IOException exc){
			zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}
*/
    
	private void zeigeInformationsfensterAn(String meldung){
    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
    		"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
    void zeigeFehlermeldungsfensterAn(String meldung){
       	new MeldungsfensterAnzeiger(AlertType.ERROR,
        	"Fehler", meldung).zeigeMeldungsfensterAn();
    }

}
