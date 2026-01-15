package gui.guiBodenbelaege;
   
import business.Teppich.Teppich;
import business.Teppich.TeppichModel;
import business.parkett.Parkett;
import business.parkett.ParkettModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class BodenbelaegeView
{
	
	private BodenbelaegeControl bodenbelaegeControl;
	private TeppichModel teppichModel;
	private ParkettModel parkettModel;
	    	//---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new  Pane();
	private Label lblAnzeigeTeppiche     = new Label("Anzeige Teppiche");
	private TextArea txtAnzeigeTeppiche  = new TextArea();
	private Button btnAnzeigeTeppiche    = new Button("Anzeige");
	
	private Label lblAnzeigeParkette     = new Label("Anzeige Parkette");
	private TextArea txtAnzeigeParkette  = new TextArea();
	private Button btnAnzeigeParkette   = new Button("csv-import und Anzeige");
	//-------Ende Attribute der grafischen Oberflaeche-------

	public BodenbelaegeView( BodenbelaegeControl bodenbelaegeControl, Stage primaryStage, TeppichModel teppichModel)
	{
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von Bodenbelaegen");
		primaryStage.show();
		this.bodenbelaegeControl = bodenbelaegeControl;
		this.teppichModel = teppichModel;
		this.parkettModel = ParkettModel.getInstance();
		this.initKomponenten();
		this.initListener();
	}

 	private void initKomponenten()
 	{
 		initTippichKomponenten();
 		initParkettKomponenten();
 		
	}
 	
 	private void initTippichKomponenten()
 	{
 		// Label
 		Font font = new Font("Arial", 20);
       	lblAnzeigeTeppiche.setLayoutX(310);
		lblAnzeigeTeppiche.setLayoutY(40);
		lblAnzeigeTeppiche.setFont(font);
		lblAnzeigeTeppiche.setStyle("-fx-font-weight: bold;");
       	pane.getChildren().add(lblAnzeigeTeppiche);

     // Textbereich	
    	txtAnzeigeTeppiche.setEditable(false);
 		txtAnzeigeTeppiche.setLayoutX(310);
		txtAnzeigeTeppiche.setLayoutY(90);
 		txtAnzeigeTeppiche.setPrefWidth(220);
		txtAnzeigeTeppiche.setPrefHeight(185);
	   	pane.getChildren().add(txtAnzeigeTeppiche);
	   	
    	// Button
      	btnAnzeigeTeppiche.setLayoutX(310);
    	btnAnzeigeTeppiche.setLayoutY(290);
    	pane.getChildren().add(btnAnzeigeTeppiche); 

		
 	}
 	
 	private void initParkettKomponenten()
 	{
 		Font font = new Font("Arial", 20);
		lblAnzeigeParkette.setLayoutX(20);
		lblAnzeigeParkette.setLayoutY(40);
		lblAnzeigeParkette.setFont(font);
		lblAnzeigeParkette.setStyle("-fx-font-weight: bold;"); 
		
		
       	pane.getChildren().add(lblAnzeigeParkette);  

		txtAnzeigeParkette.setEditable(false);
		txtAnzeigeParkette.setLayoutX(20);
		txtAnzeigeParkette.setLayoutY(90);
		txtAnzeigeParkette.setPrefWidth(220);
		txtAnzeigeParkette.setPrefHeight(185);
		
	   	pane.getChildren().add(txtAnzeigeParkette);        	


    	
    	btnAnzeigeParkette.setLayoutX(20);
    	btnAnzeigeParkette.setLayoutY(290);
    	
    	pane.getChildren().add(btnAnzeigeParkette); 

 	}
   
   private void initListener() 
   {
	    btnAnzeigeTeppiche.setOnAction( e -> zeigeTeppicheAn());
	    btnAnzeigeParkette.setOnAction(e -> zeigeParkettenAn());
    }
   
    public void zeigeTeppicheAn()
    {
    		if(!teppichModel.getTeppiche().isEmpty())
    		{
    			StringBuffer text = new StringBuffer();
    			for(Teppich teppich : teppichModel.getTeppiche())
    			{
    				text.append(teppich.gibTeppichZurueck(' '));
    			}
    			txtAnzeigeTeppiche.setText(text.toString());
    		}
    		else
    		{
    			zeigeInformationsfensterAn(
 				"Bisher wurde kein Teppich aufgenommen!");
    		}
    }	
   
    void zeigeFehlermeldungsfensterAn(String meldung){
	    	new MeldungsfensterAnzeiger(AlertType.ERROR,"Fehler", meldung).zeigeMeldungsfensterAn();
	}

	private void zeigeParkettenAn()
	{
		bodenbelaegeControl.leseParkettenAusCsvDatei();
		
	 	if(parkettModel.getParkette().size() > 0)
	 	{
			StringBuffer text = new StringBuffer();
			for(Parkett parkett: parkettModel.getParkette()) 
			{
				text.append(parkett.gibParkettZurueck(' ') + "\n");
			}
			this.txtAnzeigeParkette.setText(text.toString());
		}
		else
		{
			zeigeInformationsfensterAn("Es gibt keine Parkette in der csv-Datei!");
		}
	}

    
    private void zeigeInformationsfensterAn(String meldung)
    {
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
    }	
    
}
