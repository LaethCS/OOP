package main;

import gui.guiBodenbelaege.BodenbelaegeControl;
import gui.guiTeppich.TeppichController;
import gui.guiTeppich.TeppichhandelAnwendungssystem;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application 
{
	
	@Override
	public void start(Stage primaryStage) 
	{
		new TeppichController(primaryStage);
		Stage fensterBodenbelege = new Stage();
		new BodenbelaegeControl(fensterBodenbelege);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
