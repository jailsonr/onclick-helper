package control;

import javax.swing.ButtonModel;
import javax.swing.JMenuItem;

import model.FunctionsModel;
import model.ValidacionCrediticia;
import view.MainScreen;

public class ValidacionCrediticiaCtrl extends MainController{
	
	private ConnectionCtrl conn = ConnectionCtrl.getConnection();
	private ValidacionCrediticia vModel;
	private MainScreen ms;
	

	public ValidacionCrediticiaCtrl(FunctionsModel vModel, MainScreen ms) {
		super(ms);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initController() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void executeAction() {
		// TODO Auto-generated method stub
		
	}

}
