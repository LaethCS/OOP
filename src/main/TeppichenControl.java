package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.TeppichModel;
//import gui.Teppich;
import gui.TeppichenView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class TeppichenControl 
{
	private TeppichenView view;
	private TeppichModel model;

	public TeppichenControl(Stage primaryStage) 
	{
		this.view = new TeppichenView(primaryStage, this);
		this.model = new TeppichModel(null, null, 0, 0, null);
	}

	 public void nehmeTeppichAuf() 
	{
		try {
				this.model.setArtikelnummer(this.view.getTxtArtikelnummer().getText());
				this.model.setKategorie(this.view.getTxtKategorie().getText());
				this.model.setBreite(Integer.parseInt(this.view.getTxtBreite().getText()));
				this.model.setLaenge(Integer.parseInt(this.view.getTxtLaenge().getText()));
				this.model.setFarben(this.view.getTxtFarben().getText().split(";"));
				zeigeInformationsfensterAn("Der Teppich wurde aufgenommen!");
		} catch (Exception exc) {
			zeigeFehlermeldungsfensterAn(exc.getMessage());
		}
	}

	 public void zeigeTeppicheAn() {
		if (this.model != null) {
			this.view.getTxtAnzeige().setText(this.model.gibTeppichZurueck(' '));
		} else {
			zeigeInformationsfensterAn("Bisher wurde keine Teppich aufgenommen!");
		}
	}

	 public void leseAusDatei(String typ) {
		try {
			if ("csv".equals(typ)) {
				BufferedReader ein = new BufferedReader(new FileReader("Teppich.csv"));
				String[] zeile = ein.readLine().split(";");
				this.model = new TeppichModel(zeile[0], zeile[1], Integer.parseInt(zeile[2]),
						Integer.parseInt(zeile[3]), zeile[4].split("_"));
				ein.close();
				zeigeInformationsfensterAn("Der Teppich wurde gelesen!");
			} else {
				zeigeInformationsfensterAn("Noch nicht implementiert!");
			}
		} catch (IOException exc) {
			zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
		} catch (Exception exc) {
			zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!");
		}
	}

	 public void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

	public void zeigeFehlermeldungsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.ERROR, "Fehler", meldung).zeigeMeldungsfensterAn();
	}

	 public void schreibeTeppicheInCsvDatei() {
		try {
			BufferedWriter aus = new BufferedWriter(new FileWriter("TeppicheAusgabe.csv", true));
			aus.write(model.gibTeppichZurueck(';'));
			aus.close();
			zeigeInformationsfensterAn("Die Teppiche wurden gespeichert!");
		} catch (IOException exc) {
			zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		} catch (Exception exc) {
			zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}

}
