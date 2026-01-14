package gui.guiTeppich;
   
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
	//https://github.com/scar-da-best/POO/tree/main/OOP/src/factory
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

///////////////////////////////////
/*
package business;

public class Teppich {
    
    private String artikelnummer;
    private String kategorie;
    private int breite;
    private int laenge;
    private String[] farben;
    
    public Teppich(String artikelnummer, String kategorie, int breite,
       	int laenge, String[] farben){
    	this.artikelnummer = artikelnummer;
      	this.kategorie = kategorie;
       	this.breite = breite;
       	this.laenge = laenge;
       	this.farben = farben;
       	if(farben == null)
       	{
       		throw new IllegalArgumentException();
       	}
    }

	public String getArtikelnummer() {
		return artikelnummer;
	}

	public void setArtikelnummer(String artikelnummer) {
		this.artikelnummer = artikelnummer;
	}

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	public int getBreite() {
		return breite;
	}

	public void setBreite(int breite) {
		this.breite = breite;
	}

	public int getLaenge() {
		return laenge;
	}

	public void setLaenge(int laenge) {
		this.laenge = laenge;
	}

	public String[] getFarben() {
		return farben;
	}

	public void setFarben(String[] farben) {
		this.farben = farben;
	}
	
 	public String getFarbenAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getFarben().length - 1; i++) {
			ergebnis = ergebnis + this.getFarben()[i] + trenner; 
		}
		return ergebnis	+ this.getFarben()[i];
	}
	
	public String gibTeppichZurueck(char trenner){
  		return this.getArtikelnummer() + trenner 
  			+ this.getKategorie() + trenner
  			+ this.getBreite() + trenner
  		    + this.getLaenge() + trenner + "\n"
  		    + this.getFarbenAlsString(trenner) + "\n";
  	}
}

package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.NotActiveException;
import java.util.ArrayList;

import fileCreatorsALGOL.ConcreteCreatorCsvTxt;
import fileCreatorsALGOL.ReaderCreatorALGOL;
import fileCreatorsALGOL.ReaderProductALGOL;
import ownUtil.Observer;
import ownUtil.Observerable;

public class TeppichModel implements Observerable
{
    //private Teppich teppich;
	private ArrayList<Teppich> teppiche = new ArrayList<Teppich>();
    private static TeppichModel teppichModel;
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public ArrayList<Teppich> getTeppiche() 
    {
        return teppiche;
    }

    private TeppichModel() {}
    
    public static TeppichModel getInstance()
    {
    	if(teppichModel == null)
    	{
    		teppichModel = new TeppichModel();
    	}
    	return teppichModel;
    }

    public void nehmeTeppichAuf(String artikelnummer, String kategorie, int breite, int laenge, String[] farben) throws Exception 
    {
        //this.teppich = new Teppich(artikelnummer, kategorie, breite, laenge, farben);
        Teppich teppich = new Teppich(artikelnummer, kategorie, breite, laenge, farben);
        addTeppich(teppich);
        notifyObservers();
    }
    
    public void addTeppich(Teppich teppich)
    {
    	teppiche.add(teppich);
    	
    }
    

    public void leseAusDatei(String typ) throws IOException, Exception
    {
    	ReaderCreatorALGOL creator;
    	
        if ("csv".equals(typ) || "txt".equals(typ)) 
        {
        	creator= new ConcreteCreatorCsvTxt();
        } else 
        {
            throw new UnsupportedOperationException("Noch nicht implementiert!");
        }
        
        ReaderProductALGOL product = creator.factoryMethod(typ);
        String[] zeile = product.leserAusDatei();
        product.schlieesenDatei();
        
        //this.teppich = new Teppich(zeile[0], zeile[1], Integer.parseInt(zeile[2]), Integer.parseInt(zeile[3]), zeile[4].split("_"));
        Teppich teppich = new Teppich(zeile[0], zeile[1], Integer.parseInt(zeile[2]), Integer.parseInt(zeile[3]), zeile[4].split("_"));
        addTeppich(teppich);
        notifyObservers();
    }

    public void schreibeInCsvDatei() throws IOException, Exception 
    {
       
    	
    	if (teppiche.isEmpty()) 
        {
            throw new Exception("Kein Teppich zum Speichern vorhanden!");
        }
    	
    	BufferedWriter aus = new BufferedWriter(new FileWriter("TeppicheAusgabe.csv", true));
    	
    	for(Teppich teppich : teppiche)
    	{	
            aus.write(teppich.gibTeppichZurueck(';'));
    	}
    	
    	aus.close();
    	
    }
    
    
	@Override
	public void addObserver(Observer obs) 
	{
		this.observers.add(obs);
		
	}
	@Override
	public void removeObserver(Observer obs) 
	{
		observers.remove(obs);
		
	}
	@Override
	public void notifyObservers() 
	{
		for(Observer obs: observers)
		{
			obs.update();
		}
		
	}
}

package fileCreatorsALGOL;

import java.io.IOException;

public class ConcreteCreatorCsvTxt extends ReaderCreatorALGOL
{

	@Override
	public ReaderProductALGOL factoryMethod(String typ) throws IOException 
	{
		// TODO Auto-generated method stub
		if(typ.equalsIgnoreCase("csv"))
		{
			return new ConcreteProductCsv();
			
		}
		else if(typ.equalsIgnoreCase("txt"))
		{
			return new ConcreteProductTxt();
		}
		else
		{
			throw new UnsupportedOperationException("Noch nicht implementiert!");

		}
	}
	
}
package fileCreatorsALGOL;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductCsv extends ReaderProductALGOL
{
	private BufferedReader ein;
	
	 public ConcreteProductCsv() throws FileNotFoundException 
	 {
	        this.ein = new BufferedReader(new FileReader("Teppich.csv"));;
	 }
	    
	   
	    
	@Override
	public String[] leserAusDatei() throws IOException 
	{
        String[] zeile = ein.readLine().split(";");
        return zeile;
	}

	@Override
	public void schlieesenDatei() throws IOException 
	{
        ein.close();

		// TODO Auto-generated method stub
	}
	
}package fileCreatorsALGOL;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductTxt extends ReaderProductALGOL 
{

	private BufferedReader ein;
	
	 public ConcreteProductTxt() throws FileNotFoundException 
	 {
	        this.ein = new BufferedReader(new FileReader("Teppich.txt"));;
	 }
	    
	   
	    
	@Override
	public String[] leserAusDatei() throws IOException 
	{
		String[] ergebnisZeile = new String[5];
		String zeile = ein.readLine();
		int i = 0;
		while(i < ergebnisZeile.length)
		{
			ergebnisZeile[i] = zeile;
			zeile = ein.readLine();
			i++;
		}
		return ergebnisZeile;
	}

	@Override
	public void schlieesenDatei() throws IOException 
	{
       ein.close();

		// TODO Auto-generated method stub
	}

}
package fileCreatorsALGOL;

import java.io.IOException;

public abstract class ReaderCreatorALGOL 
{
	public abstract ReaderProductALGOL factoryMethod(String typ) throws IOException;
}
package fileCreatorsALGOL;

import java.io.IOException;

public abstract class ReaderProductALGOL 
{
	public abstract String[] leserAusDatei() throws IOException;
    public abstract void schlieesenDatei() throws IOException;
}
package gui.guiBodenbelaege;
import business.TeppichModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class BodenbelaegeControl implements Observer
{	
	private BodenbelaegeView bodenbelaegeView;
	private TeppichModel teppichModel;
	
	public BodenbelaegeControl(Stage primaryStage)
	{
 		this.teppichModel = TeppichModel.getInstance(); 		
 		this.teppichModel.addObserver(this);
		this.bodenbelaegeView = new BodenbelaegeView(this, primaryStage,teppichModel);
	}
	
	@Override
	public void update() 
	{
		this.bodenbelaegeView.zeigeTeppicheAn();
		
	}
}package gui.guiBodenbelaege;
   
import business.Teppich;
import business.TeppichModel;
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
    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane = new  Pane();
    	private Label lblAnzeigeTeppiche     = new Label("Anzeige Teppiche");
    	private TextArea txtAnzeigeTeppiche  = new TextArea();
    	private Button btnAnzeigeTeppiche    = new Button("Anzeige");
    	//-------Ende Attribute der grafischen Oberflaeche-------
    
    	public BodenbelaegeView( BodenbelaegeControl bodenbelaegeControl, Stage primaryStage, TeppichModel teppichModel)
    	{
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige von Bodenbelaegen");
    		primaryStage.show();
    		this.bodenbelaegeControl = bodenbelaegeControl;
 		this.teppichModel = teppichModel;
 		this.initKomponenten();
		this.initListener();
    	}

 	private void initKomponenten()
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
   
   private void initListener() 
   {
	    btnAnzeigeTeppiche.setOnAction( e ->  zeigeTeppicheAn());
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
   
    private void zeigeInformationsfensterAn(String meldung)
    {
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
    }	
    
}
package gui.guiTeppich;

import java.io.IOException;

import business.Teppich;
import business.TeppichModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;
import ownUtil.Observer;

public class TeppichController implements Observer
{
    private TeppichView view;
    private TeppichModel model;

    // Konstruktor: Erzeugt View und Model selbst, initialisiert Scene und Stage
    public TeppichController(Stage primaryStage) {
        this.view = new TeppichView();  // View erzeugen
        this.model = TeppichModel.getInstance();
        this.model.addObserver(this);// Model erzeugen
        initListener();
        initStage(primaryStage);  // Scene und Stage initialisieren
    }

    private void initStage(Stage primaryStage) {
        Scene scene = new Scene(view.getPane(), 700, 340);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Verwaltung von Teppichen");
        primaryStage.show();
    }

    private void initListener() {
        view.getBtnEingabe().setOnAction(e -> nehmeTeppichAuf());
        view.getBtnAnzeige().setOnAction(e -> nehmeTeppichAuf());
        view.getMnItmCsvImpkategorie().setOnAction(e -> leseAusDatei("csv"));
        view.getMnItmTxtImpkategorie().setOnAction(e -> leseAusDatei("txt"));
        view.getMnItmCsvExpkategorie().setOnAction(e -> schreibeInCsvDatei());
    }

    private void nehmeTeppichAuf() {
        try {
            model.nehmeTeppichAuf(
                view.getTxtArtikelnummer().getText(),
                view.getTxtKategorie().getText(),
                Integer.parseInt(view.getTxtBreite().getText()),
                Integer.parseInt(view.getTxtLaenge().getText()),
                view.getTxtFarben().getText().split(";"));
            zeigeInformationsfensterAn("Der Teppich wurde aufgenommen!");
        } catch (Exception exc) {
            zeigeFehlermeldungsfensterAn(exc.getMessage());
        }
    }

    private void zeigeTeppicheAn() 
    {
        if (!model.getTeppiche().isEmpty()) 
        {
        	
			StringBuffer text = new StringBuffer();
			
			for(Teppich teppich : model.getTeppiche())
			{
				text.append(teppich.gibTeppichZurueck(' '));
			}
		
            view.getTxtAnzeige().setText(text.toString());
            
        } else 
        {
            zeigeInformationsfensterAn("Bisher wurde kein Teppich aufgenommen!");
        }
    }

    private void leseAusDatei(String typ) 
    {
        try 
        {
            model.leseAusDatei(typ);
            zeigeInformationsfensterAn("Der Teppich wurde gelesen!");
        } catch (UnsupportedOperationException e) {
            zeigeInformationsfensterAn(e.getMessage());
        } catch (IOException exc) {
            zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
        } catch (Exception exc) {
            zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!");
            exc.printStackTrace();
        }
    }

    private void schreibeInCsvDatei() {
        try {
            model.schreibeInCsvDatei();
            zeigeInformationsfensterAn("Der Teppich wurde gespeichert!");
        } catch (IOException exc) {
            zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
        } catch (Exception exc) {
            zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
        }
    }

    private void zeigeInformationsfensterAn(String meldung) {
        new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
    }

    private void zeigeFehlermeldungsfensterAn(String meldung) {
        new MeldungsfensterAnzeiger(AlertType.ERROR, "Fehler", meldung).zeigeMeldungsfensterAn();
    }

	@Override
	public void update() 
	{
		zeigeTeppicheAn();
		System.out.println("we are updaing");
	}
}
package gui.guiTeppich;

import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class TeppichView {
    // Attribute der grafischen Oberfläche (aus Original extrahiert)
    private Pane pane = new Pane();
    private Label lblEingabe = new Label("Eingabe");
    private Label lblAnzeige = new Label("Anzeige");
    private Label lblArtikelnummer = new Label("Artikelnummer:");
    private Label lblKategorie = new Label("Kategorie:");
    private Label lblBreite = new Label("Breite:");
    private Label lblLaenge = new Label("Laenge:");
    private Label lblFarben = new Label("Farben:");
    private TextField txtArtikelnummer = new TextField();
    private TextField txtKategorie = new TextField();
    private TextField txtBreite = new TextField();
    private TextField txtLaenge = new TextField();
    private TextField txtFarben = new TextField();
    private TextArea txtAnzeige = new TextArea();
    private Button btnEingabe = new Button("Eingabe");
    private Button btnAnzeige = new Button("Anzeige");
    private MenuBar mnbrMenuLeiste = new MenuBar();
    private Menu mnDatei = new Menu("Datei");
    private MenuItem mnItmCsvImpkategorie = new MenuItem("csv-Import");
    private MenuItem mnItmTxtImpkategorie = new MenuItem("txt-Import");
    private MenuItem mnItmCsvExpkategorie = new MenuItem("csv-Export");

    public TeppichView() {
        initKomponenten();
    }

    private void initKomponenten() {
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
        pane.getChildren().addAll(lblEingabe, lblAnzeige, lblArtikelnummer, lblKategorie, lblBreite, lblLaenge, lblFarben);

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

        // Menü
        mnbrMenuLeiste.getMenus().add(mnDatei);
        mnDatei.getItems().add(mnItmCsvImpkategorie);
        mnDatei.getItems().add(mnItmTxtImpkategorie);
        mnDatei.getItems().add(new SeparatorMenuItem());
        mnDatei.getItems().add(mnItmCsvExpkategorie);
        pane.getChildren().add(mnbrMenuLeiste);
    }

    // Getter für Zugriff aus Controller
    public Pane getPane() { return pane; }
    public TextField getTxtArtikelnummer() { return txtArtikelnummer; }
    public TextField getTxtKategorie() { return txtKategorie; }
    public TextField getTxtBreite() { return txtBreite; }
    public TextField getTxtLaenge() { return txtLaenge; }
    public TextField getTxtFarben() { return txtFarben; }
    public TextArea getTxtAnzeige() { return txtAnzeige; }
    public Button getBtnEingabe() { return btnEingabe; }
    public Button getBtnAnzeige() { return btnAnzeige; }
    public MenuItem getMnItmCsvImpkategorie() { return mnItmCsvImpkategorie; }
    public MenuItem getMnItmTxtImpkategorie() { return mnItmTxtImpkategorie; }
    public MenuItem getMnItmCsvExpkategorie() { return mnItmCsvExpkategorie; }
}

package main;

import gui.guiBodenbelaege.BodenbelaegeControl;
import gui.guiTeppich.TeppichController;
import gui.guiTeppich.TeppichhandelAnwendungssystem;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application 
{
	
	@Override
	public void start(Stage primaryStage) 
	{
		new TeppichController(primaryStage);
		Stage fensterBodenbelege = new Stage();
		new BodenbelaegeControl(fensterBodenbelege);
	}	
	
	public static void main(String[] args){
		launch(args);
	}

}package ownUtil;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MeldungsfensterAnzeiger {
	
	private AlertType alertTyp;	
	private String titel;
	private String meldung;
	
	public MeldungsfensterAnzeiger(AlertType alertTyp, String titel, String meldung){
		this.alertTyp = alertTyp;
		this.titel = titel;
		this.meldung = meldung;
		if(meldung == null || "".equals(meldung)){
			this.meldung = "Die Meldung ist nicht vorhanden.";
		}
	}

    public void zeigeMeldungsfensterAn(){
    	Alert alert = new Alert(alertTyp);
	    alert.setTitle(this.titel);
	    alert.setContentText(this.meldung);
	    alert.showAndWait();
    }   

}
package ownUtil;

public interface Observer 
{
	void update();
}
package ownUtil;

public interface Observerable 
{
	void addObserver(Observer obs);
	void removeObserver(Observer obs);
	void notifyObservers();
}
package test.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.experimental.theories.internal.BooleanSupplier;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import business.*;

class TeppichUnit 
{

	Teppich teppich;
	@BeforeEach
	void setUp()
	{
		String[] colors = {"rot", "orang"};
		this.teppich = new Teppich("123", "L�ufer", 150, 400, colors);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		teppich = null;
	}
	
	
	@Test
	void test() 
	{
		assertTrue(()->teppich.getKategorie().equals("L�ufer"));
		Throwable exc = assertThrows(IllegalArgumentException.class,() -> new Teppich("123","L�ufer",150,400, null));
		//exc.printStackTrace();

	}

}
*/
