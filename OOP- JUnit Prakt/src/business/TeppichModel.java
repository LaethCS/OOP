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
        /*if (this.teppich == null) 
        {
            throw new Exception("Kein Teppich zum Speichern vorhanden!");
        }
        BufferedWriter aus = new BufferedWriter(new FileWriter("TeppicheAusgabe.csv", true));
        aus.write(teppich.gibTeppichZurueck(';'));
        aus.close();*/
    	
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