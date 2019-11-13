package control;

import model.FunctionsModel;
import model.ValidacionCrediticia;
import view.MainScreen;

public class ControllerFactory implements ControllerFactoryMethod{

	@Override
	public MainController createController(FunctionsModel vModel, MainScreen ms) {
		// TODO Auto-generated method stub
		CLAZZ z = CLAZZ.valueOf(vModel.getClass().getSimpleName());
		switch (z) {
		case ValidacionBiometrica:
			return new ValidacionBiometricaCtrl(vModel, ms);
		case ValidacionCrediticia:
			return new ValidacionCrediticiaCtrl(vModel, ms);			
		default:
			break;
		}
		
		return null;
	}

}

enum CLAZZ {
	ValidacionBiometrica, ValidacionCrediticia;
}
