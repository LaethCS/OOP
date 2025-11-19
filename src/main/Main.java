package main;

import gui.TeppichController;
import gui.TeppichhandelAnwendungssystem;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application 
{
	
	@Override
	public void start(Stage primaryStage) 
	{
		new TeppichController(primaryStage);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
