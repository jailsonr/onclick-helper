package control;

import model.FunctionsModel;
import view.MainScreen;

public interface ControllerFactoryMethod {
	
	public MainController createController(FunctionsModel vModel, MainScreen ms);

}
