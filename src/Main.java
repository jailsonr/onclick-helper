import control.ConnectionCtrl;
import control.ControllerFactory;
import control.ControllerFactoryMethod;
import control.MainController;
import control.ValidacionBiometricaCtrl;
import model.FunctionsModel;
import model.ValidacionBiometrica;
import view.LoginScreen;
import view.MainScreen;

public class Main {
	
	
	public static void main(String[] args) {
		ConnectionCtrl con = ConnectionCtrl.getConnection();
		MainScreen main = new MainScreen();
		
		ControllerFactoryMethod factory = new ControllerFactory();

		
		
	}

}
