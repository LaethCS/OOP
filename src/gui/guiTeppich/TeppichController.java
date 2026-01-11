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
