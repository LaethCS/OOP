package business.parkett;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParkettModel 
{
	private ArrayList<Parkett> parkette = new ArrayList<>();
	private static ParkettModel parketModel;
	
	private ParkettModel() {}
	
	public static ParkettModel getInstance()
	{
		if(parketModel == null)
		{
			parketModel = new ParkettModel();
		}
		return ParkettModel.parketModel;
	}
	
	public void leseParkettenAusCsvDatei() throws IOException 
	{
			BufferedReader ein = new BufferedReader(new FileReader("Parkett.csv"));
	 		ArrayList<Parkett> ergebnis = new ArrayList<>(); 
			String zeileStr = ein.readLine();
			
			while(zeileStr != null) 
			{
				String[] zeile = zeileStr.split(";");
	           		ergebnis.add(new Parkett(zeile[0], zeile[1], zeile[2]));
	           		zeileStr = ein.readLine();
			}    
	 		ein.close();
	 		this.parkette = ergebnis;
	 }
	
	public ArrayList<Parkett> getParkette()
	{
		return this.parkette;
	}

}
