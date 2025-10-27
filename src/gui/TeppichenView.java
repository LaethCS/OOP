package gui;

import business.TeppichModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.TeppichenControl;

public class TeppichenView 
{
	private TeppichenControl control;
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
	
	public TeppichenView(Stage primaryStage, TeppichenControl control) 
	{
		Scene scene = new Scene(this.pane, 700, 340);
		this.control = control;
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von Teppichen");
    	primaryStage.show();
    	initKomponenten();
    	initListener();
		
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
	
	private void initListener() 
	 {
		    btnEingabe.setOnAction(new EventHandler<ActionEvent>() 
		    {
	            @Override
	            public void handle(ActionEvent e)
	            {
	        	    control.nehmeTeppichAuf();
	            }
		    });
		    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() 
		    {
		    	
		    	@Override
		        public void handle(ActionEvent e) 
		    	{
		            control.zeigeTeppicheAn();
		        } 
	   	    });
		    mnItmCsvImpkategorie.setOnAction(new EventHandler<ActionEvent>() 
		    {
		    	@Override
		        public void handle(ActionEvent e)
		    	{
		    		control.leseAusDatei("csv");
		    	}
		    });
		    mnItmTxtImpkategorie.setOnAction(new EventHandler<ActionEvent>() 
		    {
			    @Override
			    public void handle(ActionEvent e)
			    {
			    	control.leseAusDatei("txt");
			    }
	    	});
		    mnItmCsvExpkategorie.setOnAction(new EventHandler<ActionEvent>()
		    {
				@Override
				public void handle(ActionEvent e)
				{
					control.schreibeTeppicheInCsvDatei();
				}	
		    });
	    }


	public Pane getPane() {
		return pane;
	}

	public Label getLblEingabe() {
		return lblEingabe;
	}

	public Label getLblAnzeige() {
		return lblAnzeige;
	}

	public Label getLblArtikelnummer() {
		return lblArtikelnummer;
	}

	public Label getLblKategorie() {
		return lblKategorie;
	}

	public Label getLblBreite() {
		return lblBreite;
	}

	public Label getLblLaenge() {
		return lblLaenge;
	}

	public Label getLblFarben() {
		return lblFarben;
	}

	public TextField getTxtArtikelnummer() {
		return txtArtikelnummer;
	}

	public TextField getTxtKategorie() {
		return txtKategorie;
	}

	public TextField getTxtBreite() {
		return txtBreite;
	}

	public TextField getTxtLaenge() {
		return txtLaenge;
	}

	public TextField getTxtFarben() {
		return txtFarben;
	}

	public TextArea getTxtAnzeige() {
		return txtAnzeige;
	}

	public Button getBtnEingabe() {
		return btnEingabe;
	}

	public Button getBtnAnzeige() {
		return btnAnzeige;
	}

	public MenuBar getMnbrMenuLeiste() {
		return mnbrMenuLeiste;
	}

	public Menu getMnDatei() {
		return mnDatei;
	}

	public MenuItem getMnItmCsvImpkategorie() {
		return mnItmCsvImpkategorie;
	}

	public MenuItem getMnItmTxtImpkategorie() {
		return mnItmTxtImpkategorie;
	}

	public MenuItem getMnItmCsvExpkategorie() {
		return mnItmCsvExpkategorie;
	}




}
