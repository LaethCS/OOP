package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TeppichModel {
    private Teppich teppich;  // Einzelnes Attribut für einen Teppich (kann null sein)

    // Getter für den Teppich
    public Teppich getTeppich() {
        return teppich;
    }

    // Erzeugt einen neuen Teppich aus Eingabedaten (delegiert vom Controller)
    public void nehmeTeppichAuf(String artikelnummer, String kategorie, int breite, int laenge, String[] farben) throws Exception {
        this.teppich = new Teppich(artikelnummer, kategorie, breite, laenge, farben);
    }

    // Liest einen Teppich aus einer Datei (csv oder txt)
    public void leseAusDatei(String typ) throws IOException, Exception {
        if ("csv".equals(typ)) {
            BufferedReader ein = new BufferedReader(new FileReader("Teppich.csv"));
            String[] zeile = ein.readLine().split(";");
            this.teppich = new Teppich(zeile[0], zeile[1], Integer.parseInt(zeile[2]), Integer.parseInt(zeile[3]), zeile[4].split("_"));
            ein.close();
        } else {
            throw new UnsupportedOperationException("Noch nicht implementiert!");
        }
    }

    // Schreibt den aktuellen Teppich in eine CSV-Datei
    public void schreibeInCsvDatei() throws IOException, Exception {
        if (this.teppich == null) {
            throw new Exception("Kein Teppich zum Speichern vorhanden!");
        }
        BufferedWriter aus = new BufferedWriter(new FileWriter("TeppicheAusgabe.csv", true));
        aus.write(teppich.gibTeppichZurueck(';'));
        aus.close();
    }
}