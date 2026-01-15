package gui.guiBodenbelaege;
import java.io.IOException;

import business.Teppich.TeppichModel;
import business.parkett.ParkettModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class BodenbelaegeControl implements Observer
{	
	private BodenbelaegeView bodenbelaegeView;
	private TeppichModel teppichModel;
	private ParkettModel parkettModel;
	
	public BodenbelaegeControl(Stage primaryStage)
	{
 		this.teppichModel = TeppichModel.getInstance(); 		
 		this.teppichModel.addObserver(this);
 		this.parkettModel = ParkettModel.getInstance();
		this.bodenbelaegeView = new BodenbelaegeView(this, primaryStage,teppichModel);
	}
	
	@Override
	public void update() 
	{
		this.bodenbelaegeView.zeigeTeppicheAn();
		
	}
	
	public void leseParkettenAusCsvDatei(){
		try
		{
			this.parkettModel.leseParkettenAusCsvDatei();
		}
		catch(IOException exc)
		{
			this.bodenbelaegeView.zeigeFehlermeldungsfensterAn("IOException beim Lesen von Sporthallen!");
		}
		catch(Exception exc)
		{
			this.bodenbelaegeView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen von " + " Sporthallen!");
		}
	}

	
}
