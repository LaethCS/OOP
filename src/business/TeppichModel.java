package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import fileCreatorsALGOL.ConcreteCreatorCsvTxt;
import fileCreatorsALGOL.ReaderCreatorALGOL;
import fileCreatorsALGOL.ReaderProductALGOL;

public class TeppichModel 
{
    private Teppich teppich;  

    public Teppich getTeppich() 
    {
        return teppich;
    }

    public void nehmeTeppichAuf(String artikelnummer, String kategorie, int breite, int laenge, String[] farben) throws Exception 
    {
        this.teppich = new Teppich(artikelnummer, kategorie, breite, laenge, farben);
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
        
        this.teppich = new Teppich(zeile[0], zeile[1], Integer.parseInt(zeile[2]), Integer.parseInt(zeile[3]), zeile[4].split("_"));
    }

    public void schreibeInCsvDatei() throws IOException, Exception 
    {
        if (this.teppich == null) 
        {
            throw new Exception("Kein Teppich zum Speichern vorhanden!");
        }
        BufferedWriter aus = new BufferedWriter(new FileWriter("TeppicheAusgabe.csv", true));
        aus.write(teppich.gibTeppichZurueck(';'));
        aus.close();
    }
}