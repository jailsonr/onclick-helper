package control;

import javax.swing.ButtonModel;
import javax.swing.JMenuItem;

import model.FunctionsModel;
import view.MainScreen;

public abstract class MainController {
	
	public MainScreen ms;
	
	public MainController(MainScreen ms) {
		this.ms = ms;
	}
	
	private String sqlUpdate;
	
	private void setSQLs(String sqpUpdate) {
		this.sqlUpdate = sqlUpdate;

	}
	
	public  void initController() {
		executeAction();
	}

	protected abstract void executeAction();

}
