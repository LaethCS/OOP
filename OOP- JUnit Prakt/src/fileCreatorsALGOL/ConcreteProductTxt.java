package fileCreatorsALGOL;

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
