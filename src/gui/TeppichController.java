package gui;

import java.io.IOException;

import business.TeppichModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class TeppichController 
{
    private TeppichView view;
    private TeppichModel model;

    // Konstruktor: Erzeugt View und Model selbst, initialisiert Scene und Stage
    public TeppichController(Stage primaryStage) {
        this.view = new TeppichView();  // View erzeugen
        this.model = new TeppichModel();  // Model erzeugen
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
        view.getBtnEingabe().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                nehmeTeppichAuf();
            }
        });
        view.getBtnAnzeige().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                zeigeTeppicheAn();
            }
        });
        view.getMnItmCsvImpkategorie().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                leseAusDatei("csv");
            }
        });
        view.getMnItmTxtImpkategorie().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                leseAusDatei("txt");
            }
        });
        view.getMnItmCsvExpkategorie().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                schreibeInCsvDatei();
            }
        });
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

    private void zeigeTeppicheAn() {
        if (model.getTeppich() != null) {
            view.getTxtAnzeige().setText(model.getTeppich().gibTeppichZurueck(' '));
        } else {
            zeigeInformationsfensterAn("Bisher wurde kein Teppich aufgenommen!");
        }
    }

    private void leseAusDatei(String typ) {
        try {
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
}