package gui.guiBodenbelaege;
import business.TeppichModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class BodenbelaegeControl implements Observer
{	
	private BodenbelaegeView bodenbelaegeView;
	private TeppichModel teppichModel;
	
	public BodenbelaegeControl(Stage primaryStage)
	{
 		this.teppichModel = TeppichModel.getInstance(); 		
 		this.teppichModel.addObserver(this);
		this.bodenbelaegeView = new BodenbelaegeView(this, primaryStage,teppichModel);
	}
	
	@Override
	public void update() 
	{
		this.bodenbelaegeView.zeigeTeppicheAn();
		
	}
}
